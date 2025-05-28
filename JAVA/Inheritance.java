

public class Inheritance
{
        public  static class Animal
        {
            public void sound()
            {
                System.out.println("sound");
            }
            static class Dog extends Animal
            {
                @Override
                public void sound()
                {
                    System.out.println("make");
                }
            }
            public static void main(String[] args)
            {
            Animal a=new Animal();
            Dog d=new Dog();
            a.sound();
            d.sound();
            }
        }
    }
