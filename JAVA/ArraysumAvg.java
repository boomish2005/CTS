
import java.util.Scanner;

public class ArraysumAvg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int s=0;int i;
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            s=s+a[i];
        }
        s=s+a[i];
        double avg=(double)s/n;
        System.out.println("sum"+s);
        System.out.println("average"+avg);
    }
}
