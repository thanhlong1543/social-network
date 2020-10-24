package tp.kits3.ambi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
/*
 * @author: Duc
 * */
@Component
public class TimeCalculation {
	public static String calculate(String da){
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = d.format(myFormatObj);
        String[] splitDayandTimeNow = formattedDate.split(" ");
        String[] dateNow = splitDayandTimeNow[0].split("-");
        String[] timeNow = splitDayandTimeNow[1].split(":");

        String[] splitDayandTime = da.split(" ");
        String[] date = splitDayandTime[0].split("-");
        String[] time = splitDayandTime[1].split(":");

        int calDay = Integer.parseInt(dateNow[2]) - Integer.parseInt(date[2]);
        int calMonth = Integer.parseInt(dateNow[1]) - Integer.parseInt(date[1]);
        int calYear = Integer.parseInt(dateNow[0]) - Integer.parseInt(date[0]);
        if(calYear == 0 && calMonth == 0 && calDay < 7 && calDay >= 0){//under 1 year n 1 month
            if(calDay < 1){// 1 day ago
                int calHour = Integer.parseInt(timeNow[0]) - Integer.parseInt(time[0]);
                if(calHour < 1){// 0-1h
                    int calMin = Integer.parseInt(timeNow[1]) - Integer.parseInt(time[1]);

                    return calMin+" minutes ago";
                }
                else if(calHour == 1){
                    return calHour+" hour ago";
                }
                else{
                    return calHour+" hours ago";
                }
            }
            else if(calDay == 1){
                return calDay+" day ago";
            }
            else{
                return calDay+" days ago";
            }
        }
        else{
            return date[2]+"-"+date[1]+"-"+date[0];
        }
    }

	public static String getCurrentTime() {
		LocalDateTime d = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	    
	    String formattedDate = d.format(myFormatObj);
		return formattedDate.toString();
	}
}
