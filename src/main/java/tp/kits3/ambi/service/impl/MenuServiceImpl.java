package tp.kits3.ambi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kits3.ambi.dao.MenuDao;
import tp.kits3.ambi.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuDao menuDao;
}
