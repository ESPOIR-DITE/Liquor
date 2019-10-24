package company.com.util.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class currentTime {
    public static String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
       // System.out.println(dtf.format(now)); //2016/11/16 12:08:43
    return dtf.format(now);
    }
}
