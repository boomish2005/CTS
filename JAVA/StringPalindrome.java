
import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String t=a;
        String r = new StringBuilder(a).reverse().toString();
        if(r.equals(t))
        {
            System.out.println("palindrome");
        }
        else
        {
            System.out.println("Not palindrome");
        }
        sc.close();
    }
}
