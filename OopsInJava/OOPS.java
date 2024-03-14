package OopsInJava;
public class OOPS {
   public static class Student {   //here student is a user defined data type
        private String name;
        int roll_no;
        double percentage;
   }
    public static void main(String[] args) {
      class  Cars{  //here you can declare inside the main method also;
            String car_name;
            double price;
            int speed;
        }

        Student s1=new Student();//creating a student s1 (objects of class student)
        s1.name="umar";
        s1.roll_no=22;
        s1.percentage=99.32;
        System.out.println(s1.name);
    }
}
