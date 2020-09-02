package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.NotificationActionDao;
import tp.kits3.ambi.service.NotificationActionService;
@Service
public class NotificationActionServiceImpl implements NotificationActionService{
	@Autowired
	NotificationActionDao notificationActionDao;
}
