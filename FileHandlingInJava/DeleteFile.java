package FileHandlingInJava;
import java.io.File;
public class DeleteFile {
    public static void main(String[] args) {

            File myFile=new File("my file.txt");
            if(myFile.exists()) {
                if (myFile.delete()) {
                    System.out.println("file is successfully deleted :" + myFile.getName());
                } else {
                    System.out.println("file failed to delete");
                }
            }else {
                System.out.println("file does not exists");
            }
        }
}

