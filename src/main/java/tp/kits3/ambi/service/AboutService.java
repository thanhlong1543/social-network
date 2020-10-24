package tp.kits3.ambi.service;

import tp.kits3.ambi.vo.About;

public interface AboutService {
	About getUserAboutByUserId(int id);
	void updateAbout(About about);
}
