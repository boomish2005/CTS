import java.util.Scanner;

public class CustomException 
{
    class InvalidAgeException extends Exception
    {
        public InvalidAgeException(String m)
        {
            super(m);
        }
    }
    public class Age
    {
        public static void c(int age) throws InvalidAgeException
        {
            if(age<18)
            {
                throw new InvalidAgeException("age>18");
            }
            System.out.println(age);
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            try
            {
                System.out.println("enter age");
                int k=sc.nextInt();
                c(k);
            }
            catch(InvalidAgeException e)
            {
                System.out.println(e.getMessage());
            }
            finally
            {
                sc.close();
            }
        }
    }
}