
enum stopWatchmode{
       start,
       pause,
       stop
        }
public class timer_mode implements Runnable {
        boolean on;
        Thread thread;
        stopWatchmode currentMode;
        String display = "00:00:00";
        int hour, minute, second, millisecond;
        protected timer_mode() {
            this.currentMode = stopWatchmode.stop;
            this.on =false;
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            this.millisecond = 0;
        }

       // Start / Pause / Resume the stopwatch !
        public void B(){
            if(this.currentMode == stopWatchmode.stop){
                start_stopwatch();
            }
            else if(this.currentMode == stopWatchmode.start){
                pause_watch();
            }
            else if(this.currentMode == stopWatchmode.pause){
                resume_stopwatch();
            }
        }
        //C : (Reset Stopwatch to “00:00:00”).
        public void C(){
             stop_stopwatch();
        }
        //stop_stopwatch() : stop the timer .
        public void stop_stopwatch(){
            Printer.watch_Screen(display);
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
            this.millisecond = 0;
            set_display();
            this.on = false;
            this.currentMode = stopWatchmode.stop;
        }

        //start_stopwatch() : will start the timer
        public void start_stopwatch(){
                this.currentMode = stopWatchmode.start;
                this.on = true;
                this.hour = 0;
                this.minute = 0;
                this.second = 0;
                this.millisecond = 0;
                set_display();
                Printer.watch_Screen(display);
                this.thread = new Thread(this);
                thread.start();
        }

        //if the stopWatch in pause mode, and we choose B then the resume_stopwatch() will resume the timer .
        public void resume_stopwatch(){
                this.on = false; //to be sure that the first thread stop
                this.currentMode = stopWatchmode.start;
                Printer.watch_Screen(display);
                this.on = true;
                thread = new Thread(this);
                thread.start();
        }

        // if the stopWatch is running, and we choose B then the pause_watch() will pause the timer .
        public void pause_watch(){
                this.currentMode = stopWatchmode.pause;
                this.on = false;
                Printer.watch_Screen(display);

        }

    public void run()
    {
        // while the stopwatch is on
        while (on) {
            try {
                Thread.sleep(1);  // pause 1 millisecond
                update();              // update the timer (update the hour , second , millisecond to the new time)
                set_display();         // Properly formatting the display of the timer
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    // update the timer (update the hour , second , millisecond to the new time))
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

  // Properly formatting the display of the timer
    public void set_display()
    {
        if (hour < 10)
            display = "0" + hour + " : ";
        else
            display = hour + " : ";

        if (minute < 10)
            display += "0" + minute + " : ";
        else
            display += minute + " : ";

        if (second < 10)
            display += "0" + second + " : ";
        else
            display += second + " : ";

        if (millisecond < 10)
            display += "00" + millisecond;
        else if (millisecond < 100)
            display += "0" + millisecond;
        else
            display += millisecond;

    }
}
