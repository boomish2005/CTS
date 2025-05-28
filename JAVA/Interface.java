public class Interface {
    interface Play
    {
        void play();
    }
    class Guitar implements  Plays
    {
        public void play()
        {
            System.out.println("guitar");
        }
    }
    class Pano implements  Plays
    {
        public void play()
        {
            System.out.println("pano");
        }
    }
    public class Main
    {
        public static void main(String[] args) {
            Plays g=new Guitar();
            Plays p=new Pano();
            g.play();
            p.play();
        }
    }

}
