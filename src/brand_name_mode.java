import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
public class brand_name_mode{

    protected brand_name_mode(){
    }

    /* B :Print the watch brand
    “The One s2!” into a  local file (named output.txt).
    */
    public void B(){
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("The One s2!");
            writer.close();
            Printer.watch_Screen("The One s2!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Do nothing
    public void C(){
    }

}
