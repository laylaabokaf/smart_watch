import java.time.LocalTime;

public class time_mode{

    protected time_mode(){
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
     //C : set an alarm after 2 min.
     public void C(){
        Thread t = new Thread(() -> {
            try {
                Printer.watch_Screen("alarm set ");
                Thread.sleep(2*60*1000);
                Printer.watch_Screen("time to woke up!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
     }
}
