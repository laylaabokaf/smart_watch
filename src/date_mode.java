import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class date_mode extends watch {


        protected date_mode(){
        }
      //Move to the next mode.
      public watch A(){
          return this.set_mode();
      }
         //Print the year
        public void B(){
                Date dt=new Date();
                int year = Calendar.getInstance().get(Calendar.YEAR);
                Printer.watch_Screen(String.valueOf(year));
        }
      //  Print the name of the day
        public void C(){
                Date date=new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                String dayWeekText = new SimpleDateFormat("EEEE").format(date);
                Printer.watch_Screen(dayWeekText);

        }


}
