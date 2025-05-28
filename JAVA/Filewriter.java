import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filewriter
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        try (BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt")))
        {
            writer.write(a);
            System.out.println("written");
        }
        catch(IOException e)
        {
            System.out.println("error occurred"+e.getMessage());
        }
        finally
        {
            sc.close();
        }
    }
    }
