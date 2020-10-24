package tp.kits3.ambi.api;
/**
 * @author Nguyen Van Truong
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.kits3.ambi.service.MenuService;
import tp.kits3.ambi.vo.Menu;
@RestController
public class ApiMenu {

	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "api/update/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public Menu greeting(@PathVariable("id")int id) {
		System.out.println(menuService.selectOne(id).getName());
		return menuService.selectOne(id);
	}
}
