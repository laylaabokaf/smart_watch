import java.util.Scanner;


        /*
        welcome to my smartwatch Project !
        name : Layla abokaf
        email : abokafl@post.bgu.ac.il
        Project: this is my OJT Home Assignment
         */
public class start_the_watch {
    /*
    smartwatch simulation !!
    just run the main function .
     */
    public static void main(String args[]){
        watch mySmartWatch = watch.getInstance();
        Printer.start_the_watch();
        Boolean on =true;
        while (on){
            Scanner sc= new Scanner(System.in);
            char Button = sc.next().charAt(0);
            if(Button == 'A')
                mySmartWatch.A();
            else if (Button == 'B')
                mySmartWatch.B();
            else if (Button == 'C')
                mySmartWatch.C();
            else if(Button == 'E'){
                System.exit(0);
            }
        }
    }
}
