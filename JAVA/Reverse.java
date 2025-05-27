
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String r = new StringBuilder(a).reverse().toString();
        System.out.println(r);
    }
}
