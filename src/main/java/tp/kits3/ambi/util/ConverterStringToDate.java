package tp.kits3.ambi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ConverterStringToDate {
	public Date stringToDate(String date) {
		String dateInString = date.replace(".0", "");
		SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dtIn = new Date();
		try {
			dtIn = inFormat.parse(dateInString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtIn;
	}
}
