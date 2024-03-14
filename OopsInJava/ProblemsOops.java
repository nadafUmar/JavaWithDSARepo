package OopsInJava;

import java.util.Scanner;

public class ProblemsOops {

    public static class fraction {
        int num;
        int denom;
        public  fraction(int num,int denom){
            this.num=num;
            this.denom=denom;
            simplify();  //simplified the fraction
        }
        public  void simplify(){
            int min=Math.min(num,denom);

            for(int i=min;i>=1;i--){
                if(num%i==0 && denom%i==0){
                    num/=i;
                    denom/=i;
                }
            }
        }
    }
    public static fraction addFraction(fraction f1,fraction f2){

         int n=f1.num*f2.denom +f1.denom*f2.num;
         int d=f1.denom*f2.denom;
         return new fraction(n,d);
    }
    public static void main(String[] args) {
        //Q make  addition subtraction multiplication division of fractions
        Scanner sc=new Scanner(System.in);

        fraction f1=new fraction(12,4);
        fraction f2=new fraction(40,4);

        System.out.println(f1.num + "/"+f1.denom);
        System.out.println(f2.num + "/"+f2.denom);
        fraction f3=addFraction(f1,f2);
        System.out.println(f3.num+"/"+f3.denom);

        //ypu can make now subtractionFraction,productFraction,divisionFraction functions

    }
}
