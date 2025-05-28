public class Classcreation_Objectcreation {
    static class Car
    {
    String make;
    String model;
    int year;
    public Car(String make,String model,int year)
    {
        this.make=make;
        this.model=model;
        this.year=year;
    }
    public  void display()
    {
        System.out.println(year +" " + make +" "+ " " +model);
    }
}    public static void main(String[] args) {
    Car a=new Car("tvs","xl",2010);
    Car b=new Car("xl","xl",2018);
    a.display();
    b.display();
} 
}
