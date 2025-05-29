import java.util.Scanner;

public class ArrayList 
{
    public static void main(String[] args) {
        ArrayList<String> names=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter names");
        while(true)
        {
            String name=sc.nextLine();
            if(name.equalsIgnoreCase("done")) break;
            names.add(name);
        }
        System.out.println("Student Names:");
        for (int i=0;i<names.size();i++)
        {
            System.out.println((i+1)+". "+names.get(i));
        }
        sc.close();
    }  
}
