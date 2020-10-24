package tp.kits3.ambi.dao;

import java.util.List;

import tp.kits3.ambi.vo.Notifications;

public interface NotificationsDao extends GenericDao<Notifications> {
	List<Notifications> getListNotificationById(int id);
	Notifications selectToCheckExistNoti(int id, int memo, int notiTypeId);
	int getNumberOfNotiByUserId(int id, boolean b);
}
