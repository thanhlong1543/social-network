package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.NotificationActionDao;
import tp.kits3.ambi.vo.NotificationAction;


@Repository
public class NotificationActionDaoImpl extends GenericDaoImpl<NotificationAction> implements NotificationActionDao {
	public NotificationActionDaoImpl() {
		super("notificationActionMapper");
	}
}
