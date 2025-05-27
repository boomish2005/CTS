import java.util.*;
public class Leap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%4==0 || n%100!=0 || n%400!=0)
        {
            System.out.println("leap");
        }
        else
        {
            System.out.println("not");
        }
    }
}
