public class MethodOverload {
    public int add(int a,int b)
    {
        return a+b;
    }
    public int add(int a,int b,int c)
    {
        return a+b+c;
    }
    public int add(int a,int b,int c,int d)
    {
        return a+b+c+d;
    }
    public static void main(String[] args)
    {
        MethodOverload sc=new MethodOverload();
        int s=sc.add(4,5,6);
        System.out.println(s); 
        int r=sc.add(2,3,4,5);
        System.out.println(r);
    }
}
