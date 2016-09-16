import java.io.IOException;
import javax.swing.JFrame;


public class Main {

   public static String name;
   public static String parid;
   public static int correct;
   public static int time_elapsed;
   public static int points;

   public static void main(String[] args) throws IOException {
   page1 pg1 = new page1();  
   pg1.setVisible(true);
   pg1.setState(page1.NORMAL);
   pg1.setLocationRelativeTo(null);
   }
   public static void main2(){
   page2 pg2 = new page2();
   pg2.setVisible(true);
   pg2.setState(pg2.NORMAL);
   pg2.setFocusableWindowState(true);
   pg2.setLocationRelativeTo(null);
   }
   public static void main3(){
      page3 pg3 = new page3();
      pg3.setVisible(true);
      pg3.setState(pg3.NORMAL);
      pg3.setFocusableWindowState(true);
      pg3.setLocationRelativeTo(null);
   }
   
   public static void hs(){
      highscore hs = new highscore();
      hs.setVisible(true);
      hs.setState(hs.NORMAL);
      hs.setFocusableWindowState(true);
      hs.setLocationRelativeTo(null); 
      hs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
   }
}
