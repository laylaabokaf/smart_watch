public class start_the_watch {
    public static void main(String args[]){
        watch smart_watch = watch.getInstance();
        System.out.println(smart_watch.getCurrent_mode());
        smart_watch.B();
        smart_watch.C();
        smart_watch = smart_watch.A();
        System.out.println(smart_watch.getCurrent_mode());
        smart_watch.B();
        smart_watch.C();
        smart_watch.A();
       System.out.println(smart_watch.getCurrent_mode());
       timer t =new timer();


    }
}
