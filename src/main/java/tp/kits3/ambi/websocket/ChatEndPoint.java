package tp.kits3.ambi.websocket;

import java.util.Objects;

import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import tp.kits3.ambi.config.MyApplicationContextAware;
import tp.kits3.ambi.service.impl.UserServiceImpl;
import tp.kits3.ambi.vo.User;

/**
 * @author Pham Thanh Tam
 */
@ServerEndpoint(value = "/chat/{username}", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
@Component
public class ChatEndPoint {

    private UserServiceImpl userService = (UserServiceImpl) MyApplicationContextAware.getApplicationContext().getBean("userServiceImpl");
	@OnOpen
	public void onOpen(@PathParam(Constants.USER_NAME_KEY) String userName,Session session) {

		User user = new User();
		try {
			String email = userName + "@gmail.com";
			user = userService.selectByEmail(email);
	

		if (Objects.isNull(userName) || userName.isEmpty()) {
			throw new RegistrationFailedException("User name is required");
		} else {
			session.getUserProperties().put(Constants.USER_NAME_KEY, userName);
			if (ChatSessionManager.register(session)) {
				System.out.printf("Session opened for %s\n", userName);

				ChatSessionManager.publish(new Message(userName, user.getUserUrl(), "", user.getName(),
						user.getUseravt(), user.getUserId().toString(), "checkOnline", "asd"), session);
			} else {
				throw new RegistrationFailedException("Unable to register, username already exists, try another");
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		if (throwable instanceof RegistrationFailedException) {
			System.out.println(throwable.getMessage()+ "   "+ throwable.getStackTrace());
			System.out.println(throwable.getCause());
			ChatSessionManager.close(session, CloseCodes.VIOLATED_POLICY, throwable.getMessage());
		}
	}

	@OnMessage
	public void onMessage(Message message, Session session) {
		ChatSessionManager.publish(message, session);
	}

	@OnClose
	public void onClose(Session session) {
		if (ChatSessionManager.remove(session)) {
			System.out.printf("Session closed for %s\n", session.getUserProperties().get(Constants.USER_NAME_KEY));

			// ChatSessionManager.publish(new Message((String)
			// session.getUserProperties().get(Constants.USER_NAME_KEY), "***left the
			// chat***","1"), session);
		}
	}

	private static class RegistrationFailedException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RegistrationFailedException(String message) {
			super(message);
			System.out.println(message);
			
		}
	}
}
