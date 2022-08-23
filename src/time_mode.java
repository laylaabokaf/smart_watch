import java.time.LocalTime;

public class time_mode extends watch {

    protected time_mode(){
    }

    public watch A(){
      return  this.set_mode();
    }
    //B: Print the time in AM/PM mode.
     public void B(){
         String format;
         LocalTime myObj = LocalTime.now();
         String[] arr = myObj.toString().split(":");
         int hour = Integer.parseInt(arr[0]);

         if (hour > 12) {
             hour = hour - 12;
             format = "PM";
         }
         else if (hour == 00) {
             hour = 12;
             format = "AM";
         }
         else if (hour == 12) {
             hour = 12;
             format = "PM";
         }
         else {
             format = "AM";
         }
         String minute = arr[1];
         Printer.watch_Screen(hour + ":" + minute + " " + format);
     }
     //Print “Light”
     public void C(){
        Printer.watch_Screen("Light");
     }
}
