package tp.kits3.ambi.websocket;

/**
 *@author Pham Thanh Tam
 */
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.config.MyApplicationContextAware;
import tp.kits3.ambi.service.ConversationUserService;
import tp.kits3.ambi.service.FriendService;
import tp.kits3.ambi.service.UserService;
import tp.kits3.ambi.vo.ConversationUser;
import tp.kits3.ambi.vo.User;

@Component
class ChatSessionManager {
	private static FriendService friendService = (FriendService) MyApplicationContextAware.getApplicationContext()
			.getBean("friendServiceImpl");
	private static ConversationUserService conversationUserService = (ConversationUserService) MyApplicationContextAware.getApplicationContext()
			.getBean("conversationUserServiceImpl");
	private static UserService userService = (UserService) MyApplicationContextAware.getApplicationContext()
			.getBean("userServiceImpl");
	private static Lock LOCK = new ReentrantLock();
	private static Set<Session> SESSIONS = new CopyOnWriteArraySet<>();

	static void publish(Message message, Session origin) {
		assert !Objects.isNull(message) && !Objects.isNull(origin);

//        SESSIONS.stream().filter(session -> !session.equals(origin)).forEach(session -> {
//            try {
//                session.getBasicRemote().sendObject(message);
//				  String test = SESSIONS.stream()
//				  .filter(elem -> ((String) elem.getUserProperties().get(Constants.USER_NAME_KEY)).equals("asd"))
//				  .findFirst().get().getPathParameters().get("username");
//				 if (SESSIONS.contains(origin)) {
//					 SESSIONS.stream().filter(session1 -> session1.getPathParameters().get("username").equals("1")).forEach(session1 ->{
//						System.out.println( session1.getPathParameters().get("username"));
//						try {
//							
//							session1.getBasicRemote().sendObject(message);
//						} catch (IOException e) {
//							e.printStackTrace();
//						} catch (EncodeException e) {
//							e.printStackTrace();
//						}
//					 });
//					 System.out.println("123 true");
//				}
		;
//				 
//            } catch (IOException | EncodeException e) {
//                e.printStackTrace();
//            }
//        });
		if (message.getSendtype().equals("checkOnline")) {
			List<User> users = friendService.selectByUserId(Integer.parseInt(message.getUserid()), 2);
			for (User user : users) {
				SESSIONS.stream().filter(
						session1 -> session1.getPathParameters().get(Constants.USER_NAME_KEY).equals(user.getUserUrl()))
						.forEach(session1 -> {
							try {
								Message messageUser = new Message(user.getUserUrl(), "checkOnline",
										user.getUserId().toString(), "0", user.getUseravt(),
										user.getUserId().toString(), "checkOnline", "asd");
								origin.getBasicRemote().sendObject(messageUser);
								session1.getBasicRemote().sendObject(message);
							} catch (Exception e) {
								e.printStackTrace();
							}
						});

			}

//			for (User user : users) {
//				try {
//					String test = user.getUserUrl();
//					System.out.println(test);
//					SESSIONS.stream()
//							.filter(session1 -> session1.getPathParameters().get(Constants.USER_NAME_KEY).equals(user.getUserUrl()))
//							.forEach(session1 -> {
//								System.out.println(session1.getPathParameters().get(Constants.USER_NAME_KEY));
//								try {
//									session1.getBasicRemote().sendObject(message);
//								} catch (IOException e) {
//									e.printStackTrace();
//								} catch (EncodeException e) {
//									e.printStackTrace();
//								}
//							});
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//
//			}
		} else if (message.getSendtype().equals("message")) {
			List<ConversationUser> conversationUsers = conversationUserService.selectByConId((Integer.parseInt(message.getId())));
			for (ConversationUser conversationUser : conversationUsers) {
				User user = userService.selectOne(conversationUser.getUserId());
				SESSIONS.stream().filter(
						session -> session.getPathParameters().get(Constants.USER_NAME_KEY).equals(user.getUserUrl()) 
								&& ! session.equals(origin))
						.forEach(session -> {
							try {
								System.out.println("!!! " + user.getUserUrl() +" :: "+ session.getPathParameters().get(Constants.USER_NAME_KEY));
								session.getBasicRemote().sendObject(message);
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
			}
			
		} else if (message.getSendtype().equals("notification")) {
				User user = userService.selectOne(Integer.parseInt(message.getUserid()));
				SESSIONS.stream().filter(
						session -> session.getPathParameters().get(Constants.USER_NAME_KEY).equals(user.getUserUrl()) 
								&& ! session.equals(origin))
						.forEach(session -> {
							try {
								session.getBasicRemote().sendObject(message);
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
			
		} else{
			SESSIONS.stream().filter(session -> !session.equals(origin)).forEach(session -> {
				try {
					session.getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException e) {
					e.printStackTrace();
				}
			});
		}

	}

	static boolean register(Session session) {
		assert !Objects.isNull(session);
		boolean result = false;
		try {
			LOCK.lock();
			result = !SESSIONS.contains(session) && !SESSIONS.stream()
					.filter(elem -> ((String) elem.getUserProperties().get(Constants.USER_NAME_KEY))
							.equals((String) session.getUserProperties().get(Constants.USER_NAME_KEY)))
					.findFirst().isPresent() && SESSIONS.add(session);
		} finally {
			LOCK.unlock();
		}

		return result;
	}

	static void close(Session session, CloseCodes closeCode, String message) {
		assert !Objects.isNull(session) && !Objects.isNull(closeCode);

		try {
			session.close(new CloseReason(closeCode, message));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static boolean remove(Session session) {
		assert !Objects.isNull(session);

		return SESSIONS.remove(session);
	}
}
