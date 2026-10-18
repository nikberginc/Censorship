import java.util.Scanner;


public class MainUser {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //the path to txt file
        String txt_path ="Text_file.txt";

        try{ 
            System.out.println("Program loading...");
            Thread.sleep(100); 
        

            System.out.println("Program running");
            Thread.sleep(1000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\n\n\n\n\nPlease insert where your text file is (must be like this: C:\\Users...\\file.txt):");
        System.out.print("\n\nIf the file is in THIS FILE (CENSORSHIP) than type NO! \n»» ");
        String path_check = scanner.nextLine();



        


        char first_path_check = path_check.toLowerCase().charAt(0);


        if (first_path_check != 'n'){

            txt_path = path_check;
            
            TxtReader.readTXT(txt_path);
            System.out.println("\n\n\n\nFile found and valid!\n\n");

            try{ 
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try{ 
            System.out.println("\n\n\nText loading...");
            Thread.sleep(1000); 
        

            System.out.println("Generating censored text...");
            Thread.sleep(1000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nCensored text created:\n\n");
        System.out.println("\n\n\n"+CurseChecker.chackerCURSE(TxtReader.readTXT(txt_path))+"\n\n\n\n");

        scanner.close();
    }   

}
