package tp.kits3.ambi.dao.impl;

import org.springframework.stereotype.Repository;

import tp.kits3.ambi.dao.NotificationObjectDao;
import tp.kits3.ambi.vo.NotificationObject;


@Repository
public class NotificationObjectDaoImpl extends GenericDaoImpl<NotificationObject> implements NotificationObjectDao {
	public NotificationObjectDaoImpl() {
		super("notificationObjectMapper");
	}
}
