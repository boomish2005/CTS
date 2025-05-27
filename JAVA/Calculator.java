import java.util.Scanner;
class Calculator {
    public static void main(String[] args) {
        String o;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("1. +\n2. -\n3. *\n4. /");
        int c=sc.nextInt();
        int r=0;
        switch(c)
        {
            case 1:
                r=a+b;
                o="+";
                break;
            case 2:
                r=a-b;
                o="-";
                break;
            case 3:
                r=a*b;
                o="*";
                break;
            case 4:
                if(b==0)
                {
                    System.out.println("Error");
                }
                r=a/b;
                o="/";
                break;
            default:
                System.out.println("Invalid");
        }
        System.out.println(r);
        sc.close(); 
    }
}