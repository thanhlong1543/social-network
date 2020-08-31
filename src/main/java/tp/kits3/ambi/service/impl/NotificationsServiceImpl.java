package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.NotificationsDao;
import tp.kits3.ambi.service.NotificationsService;
@Service
public class NotificationsServiceImpl implements NotificationsService{
	@Autowired
	NotificationsDao notificationsDao;
}
