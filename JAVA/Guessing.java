
import java.util.Scanner;

public class Guessing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c;
        do
        {
            c=sc.nextInt();
            if(c>n)
            {
                System.out.println("high");
            }
            else if(c<n)
            {
                System.out.println("low");
            }
            else
            {
                System.out.println("correct");
            }
        }
        while(c!=n);
        sc.close();
    }
}
