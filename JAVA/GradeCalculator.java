
import java.util.*;;
public  class GradeCalculator
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.err.println("enter marks  0-100");
        if(n>=90 && n<100)
        {
            System.out.println("A");
        }
        else if(n>=80 && n<89)
        {     
            System.out.println("B");
        }
        else if(n>=70 && n<79)
        {
            System.out.println("C");
        }
        else if(n>=60 && n<69)
        {
            System.out.println("D");
        }
        else
        {

            System.out.println("F");
        }  
    }
}