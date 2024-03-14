package FileHandlingInJava;
import java.io.File;
public class CreateFile {
    public static void main(String[] args) {
        try {
            File myFile=new File("my file.txt");
            if(myFile.createNewFile()) { //this method returns true if file successfully created and false if already exists
                System.out.println(myFile.getName() + " file is successfully created");//this method returns name of file

            }else {
                System.out.println("file already exists");
                System.out.println(myFile.getAbsolutePath());
            }
        }catch(Exception e){
                System.out.println("file cannot created");
                e.printStackTrace();
        }

    }
}


