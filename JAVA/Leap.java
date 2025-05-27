import java.util.*;
public class Leap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%4==0 || n%100!=0 || n%400!=0)
        {
            System.err.println("leap");
        }
        else
        {
            System.err.println("not");
        }
    }
}
