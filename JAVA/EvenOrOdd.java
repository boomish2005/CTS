
import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%2==0)
        {
            System.err.println("Even");
        }
        else
        {
            System.err.println("odd");
        }
    }
}
