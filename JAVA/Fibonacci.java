
import java.util.Scanner;

public  class Fibonacci
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<0)
        {
            System.out.println("not a number");
        }
        else
        {
            long r=f(n);
            System.out.println(r);
        }
        sc.close();
    }
    public static long f(int n)
    {
        if(n<=1)
        {
            return n;
        }
        else
        {
            return f(n-1)+f(n-2);
        }
    }
}
