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
watch class , is a singleton class " class that have just one object " .
so we have one watch .
we will also extend this class to 4 subclasses , each one will be a different mode .
 */
abstract class watch {
    private watch_mode current_mode = watch_mode.time;
    private static watch single_watch = null;
    protected watch()
    {}

   public abstract watch A();
    public abstract void B();
    public abstract void C();

    public static watch getInstance()
    {
        if (single_watch == null)
            single_watch = new time_mode();
        return single_watch;
    }
    private void setCurrent_mode(){
        current_mode = current_mode.next();
    }

    /*
     set_mode() : when the user choose batten A , the mode will change to the next mode
    starting with "time" mode.
    also the instance of the class "watch" will change to the new mode, so we can use the new mode functions!
     */
    protected watch set_mode(){
        //set to next mode
         setCurrent_mode();
         switch (current_mode){
             case time:
                 return single_watch = new time_mode();
             case date:
                return single_watch = new date_mode();
             case timer:
                 return single_watch = new timer_mode();
             case brand_name:
                 return  single_watch = new brand_name_mode();
         }
    return null;
    }

    public watch_mode getCurrent_mode() {
        return current_mode;
    }
}
