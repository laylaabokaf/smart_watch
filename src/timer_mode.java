import java.util.Scanner;
enum stopWatchmode{
       start,
       pause,
       resume,
       stop
        }
public class timer_mode extends watch   implements Runnable {
        boolean on;
        stopWatchmode currentMode = stopWatchmode.stop;
        String disp = "00:00:00";
        int hour, minute, second, millisecond;
        protected timer_mode(){
            this.on =false;
        }

        public watch A(){
                return  this.set_mode();
        }
       // Start / Pause / Resume
        //Stopwatch.
        public void B(){

        }
        //top Stopwatch
        //(Reset to
        //“00:00:00”).
        public void C(){
                String disp = "00:00:00";
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            this.millisecond = 0;
            changeLabel();
            Printer.watch_Screen(disp);
                Printer.watch_Screen(disp);
                on = false;
                currentMode = stopWatchmode.stop;
        }

        public void start_stopwatch(){
                currentMode = stopWatchmode.start;
                on =false;
                this.hour = 0;
                this.minute = 0;
                this.second = 0;
                this.millisecond = 0;
                 changeLabel();
                Printer.watch_Screen(disp);
                on = true;
                //System.out.println(Thread.currentThread().getId());
                Thread thread = new Thread(this);
                //System.out.println(thread.getId());
                thread.start();

        }

        public void resume_stopwatch(){
            if(currentMode == stopWatchmode.pause) {
                currentMode = stopWatchmode.start;
                Printer.watch_Screen(disp);
                on = true;
                System.out.println(Thread.currentThread().getId());
                Thread thread = new Thread(this);
                System.out.println(thread.getId());
                thread.start();
            }
            else{
                System.out.println("can't resume if u didnt pause the stopwatch");
            }
        }

        public void pause_watch(){
            if(currentMode == stopWatchmode.start) {
                on = false;
                Printer.watch_Screen(disp);
                currentMode = stopWatchmode.pause;
            }
            else {
                System.out.println("cant pause if the stopwatch didnt start!");
            }
        }

    public void run()
    {

        // while the stopwatch is on
        while (on) {
            try {
                // pause 1 millisecond
                Thread.sleep(1);
                // update the time
                update();
                // changeLabel
                changeLabel();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void update()
    {
        millisecond++;
        if (millisecond == 1000) {
            millisecond = 0;
            second++;
            if (second == 60) {
                second = 0;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
            }
        }

    }


    public void changeLabel()
    {
        // Properly formatting the display of the timer
        if (hour < 10)
            disp = "0" + hour + " : ";
        else
            disp = hour + " : ";

        if (minute < 10)
            disp += "0" + minute + " : ";
        else
            disp += minute + " : ";

        if (second < 10)
            disp += "0" + second + " : ";
        else
            disp += second + " : ";

        if (millisecond < 10)
            disp += "00" + millisecond;
        else if (millisecond < 100)
            disp += "0" + millisecond;
        else
            disp += millisecond;

    }

    //testing timer
    public static void main(String args[]){
            timer_mode timer = new timer_mode();
            while(true){
                System.out.println("enter 1 to start the stopwatch ");
                System.out.println("enter 2 to pause the stopwatch ");
                System.out.println("enter 3 to resume the stopwatch ");
                System.out.println("enter 4 to reset the stopwatch ");
                Scanner sc= new Scanner(System.in);
                int a= sc.nextInt();
                if(a==1){
                    timer.start_stopwatch();
                }
                if(a==2)
                    timer.pause_watch();
                if(a==3)
                    timer.resume_stopwatch();
                if (a==4)
                    timer.C();
            }

    }

}
