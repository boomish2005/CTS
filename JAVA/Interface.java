public class Interface {
    interface Play
    {
        void play();
    }
    public static class Guitar implements Play
    {
        public void play()
        {
            System.out.println("guitar");
        }
    }
    static class Pano implements Play
    {
        public void play()
        {
            System.out.println("pano");
        }
    }
    public static class Main
    {
        public static void main(String[] args) {
            Play g=new Guitar();
            Play p=new Pano();
            g.play();
            p.play();
        }
    }
}