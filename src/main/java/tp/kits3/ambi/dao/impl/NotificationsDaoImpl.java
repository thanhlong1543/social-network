package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.NotificationsDao;
import tp.kits3.ambi.vo.Notifications;


@Repository
public class NotificationsDaoImpl extends GenericDaoImpl<Notifications> implements NotificationsDao {
	public NotificationsDaoImpl() {
		super("notificationsMapper");
	}
}
