import java.util.Scanner;

public class Factorial
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<0)
        {
            System.out.println("not 0");
            return;
        }
        else
        {
            long f=1;
            for(int i=0;i<=n;i++)
            {
                f=f*i;
            }
            System.out.println(f);
            sc.close();
        }

    }
}