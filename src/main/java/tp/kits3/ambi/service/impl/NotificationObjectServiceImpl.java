package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.NotificationObjectDao;
import tp.kits3.ambi.service.NotificationObjectService;
@Service
public class NotificationObjectServiceImpl implements NotificationObjectService{
	@Autowired
	NotificationObjectDao notificationObjectDao;
}
