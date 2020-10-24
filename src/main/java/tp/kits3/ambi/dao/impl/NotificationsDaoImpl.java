package tp.kits3.ambi.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.NotificationsDao;
import tp.kits3.ambi.vo.Notifications;

/*
 * @author: Duc
 * */
@Repository
public class NotificationsDaoImpl extends GenericDaoImpl<Notifications> implements NotificationsDao {
	public NotificationsDaoImpl() {
		super("notificationsMapper");
	}
	@Override
	public List<Notifications> getListNotificationById(int id) {
		SqlSession session = getInstance().openSession();
		List<Notifications> list = session.selectList("mappers.notificationsMapper.selectNotiByUserId", id);
		session.close();
		return list;
	}
	@Override
	public Notifications selectToCheckExistNoti(int id, int memo, int notiTypeId) {
		SqlSession session = getInstance().openSession();
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("userId", id);
		params.put("memo", memo);
		params.put("notiTypeId", notiTypeId);
		Notifications noti = session.selectOne("mappers.notificationsMapper.selectWithoutNotiId", params);
		session.close();
		return noti;
	}
	@Override
	public int getNumberOfNotiByUserId(int id, boolean b) {
		SqlSession session = getInstance().openSession();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", id);
		params.put("isread", b);
		int num = session.selectOne("mappers.notificationsMapper.getNumberOfNotiByUserId", params);
		return num;
	}
}
