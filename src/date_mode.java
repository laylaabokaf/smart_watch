import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
public class date_mode {

        protected date_mode(){
        }

         //Print the year
        public void B(){
                int year = Calendar.getInstance().get(Calendar.YEAR);
                Printer.watch_Screen(String.valueOf(year));
        }
        //  Print the name of the current day
        public void C(){
                Date date=new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                String dayWeekText = new SimpleDateFormat("EEEE").format(date);
                Printer.watch_Screen(dayWeekText);
        }
}
