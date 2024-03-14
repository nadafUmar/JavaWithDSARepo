package FileHandlingInJava;
import java.io.FileWriter;
public class WriteFile {
    public static void main(String[] args) {

        try {
            FileWriter fw=new FileWriter("my file.txt");
            fw.write("this is my file, i will become multi trillionare one day definitly");
            fw.close();
            System.out.println("successfully wrote to the file");
        }catch (Exception e) {
            System.out.println("an error occured");
            e.printStackTrace();
        }
    }
}
