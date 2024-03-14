package FileHandlingInJava;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

        try {
            File myFile=new File("my file.txt");
            if(myFile.exists()) {
                System.out.println("file name is :" + myFile.getName());
                System.out.println("file location is :" + myFile.getAbsolutePath());
                System.out.println("can we write in file :"+myFile.canWrite());
                System.out.println("can we read from file:"+myFile.canRead());
                System.out.println("file size in byte:"+myFile.length());
            }else {
                System.out.println("file does not exists");
            }
        }catch (Exception e){
            System.out.println("an error occured");
            e.printStackTrace();
        }
    }
}
