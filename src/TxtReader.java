import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class TxtReader {
    public static String readTXT (String txt_path){

         try {
            String text = Files.readString(Path.of(txt_path));
            return text;

        } catch (IOException e) {
            System.out.println("\n\n\nError reading file: \t" + e.getMessage()+" \t please reload the program and try again");
            System.exit(0);
            return null;
        }


    }

}
