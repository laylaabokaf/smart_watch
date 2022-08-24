enum watch_mode {
    time,
    date,
    timer,
    brand_name ;
    private static watch_mode[] vals = values();
    public watch_mode next() //returns the next enums value
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}

/*
watch class , is a singleton class  .
we will have only one  watch .
the smartwatch modes will be a fields at the watch class , that will mack it easier to jump between them ,
 each one will be a different class with different methods .
 */
public class watch {
    private time_mode timeMode = new time_mode();
    private date_mode dateMode = new date_mode();
    private timer_mode timerMode = new timer_mode();
    private brand_name_mode brandMode = new brand_name_mode();
    private watch_mode current_mode = watch_mode.time;
    private static watch single_watch = null;

    private watch() {
    }

    //method A is the same for all modes , so we just jump to next mode
    public void A() {
        setCurrent_mode();
    }


    //B : will run the method b for the current mode
    public void B() {
        if (current_mode == watch_mode.time)
            timeMode.B();
        if (current_mode == watch_mode.date)
            dateMode.B();
        if (current_mode == watch_mode.timer)
            timerMode.B();
        if (current_mode == watch_mode.brand_name)
            brandMode.B();
    }


    //C : will run the method c for the current mode
    public void C() {
        if (current_mode == watch_mode.time)
            timeMode.C();
        if (current_mode == watch_mode.date)
            dateMode.C();
        if (current_mode == watch_mode.timer)
            timerMode.C();
        if (current_mode == watch_mode.brand_name)
            brandMode.C();

    }

    public static watch getInstance() {
        if (single_watch == null)
            single_watch = new watch();
        return single_watch;
    }

    private void setCurrent_mode() {
        current_mode = current_mode.next();
    }

    /*
     set_mode() : when the user choose batten A , the mode will change to the next mode
    starting with "time" mode.
     */
}

