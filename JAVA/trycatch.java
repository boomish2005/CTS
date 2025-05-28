import java.util.Scanner;

public class trycatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a/b;
            System.out.println(c);
        }
        catch(ArithmeticException e)
        {
            System.out.println("cant divide by 0");
        }
        sc.close();
    }
}
