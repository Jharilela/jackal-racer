import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class page2 extends javax.swing.JFrame {

 int i = 1;
 int dif=0, correct=0,dist=250;
 int start_time=0,end_time=0;
 int l=850;
 int width = 150, height = 90, width_text = 130, height_text=30;
 ImageIcon pic;
 int random=0;
 String words[][] = new String[][]
 {{"KEY","LOG","MAD","NAP","BUT","ODD","PAL","FLY","ANY","RAM",
    "SAW","TAN","URN","VET","WED","DAY","GET","YAP","HIM","ZOO",
     "GOD","MAN","NEW","NOW","OLD","SEE","TWO","WAY","WHO","BOY",
      "DID","ITS","LET","PUT","SAY","SHE","TOO","USE","DAD","MOM",
        "ACT","BAR","CAR","DEW","EAT","FAR","GYM","HEY","INK","JET"},
 //3 LETTER WORDS
 {"JAZZ","BUZZ","QUIZ","JACK","JUMP","COZY","JUKE","JUNK","ZONK","JAVA",
   "JOKE","ZINC","BOXY","FLUX","JAMS","JEEP","JOBS","LAZY","MAZE","MOJO",
     "ZING","ZOOM","GAZE","HAZE","JAYS","KICK","QUAD","AQUA","BOOK","JAIL",
       "TEST","EXAM","NAZI","FISH","TOAD","BITE","REAL","ONYX","SUIT","VIBE",
         "COIN","BURN","PRAY","BALL","KISS","BIRD","SWAN","PLUG","TREE","PURE"},
 //4 LETTER WORDS
 {"CHILD","DRINK","SPORT","DANCE","PHONE","FRIEND","HAPPY","ROBOT","BASKET","GROOT",
    "TIGER","GLASS","TRUST","GUIDE","MONEY","DONOR","CLOTH","FIGHT","PAPER","ZEBRA",
      "CAMEL","LIGHT","TOWEL","GLOBE","BRAIN","BRAVE","BOARD","BORED","SWITCH","FRAME",
        "RULER","PIZZA","QUICK","MANGO","APPLE","BLITZ","REMIX","JELLY","JUICE","FRUIT",
          "SQUID","LEAVE","MAJOR","HEART","HOLES","PRIZE","PROXY","PAINT","VAULT","CLIMB"},
 //5 LETTER WORDS
 {"RECORD","REMOTE","DECADE","CHERRY","DECENT","PARENT","ACTIVE","GENTLE","HONEST","ABDUCT",
   "BRIDGE","PUZZLE","INVENT","MINGLE","QUARTZ","JOCKEY","HOCKEY","MONKEY","FLOWER","SPIRIT",
    "CANVAS","JACKAL","FINGER","RANDOM","PYJAMA","CHEESE","ENZYME","OBJECT","CASTLE","DURIAN",
     "VIOLET","ORANGE","PAPAYA","WIZARD","FROZEN","BRAZIL","RUSSIA","EUROPE","BRONZE","BLAZER",
      "UPSIZE","OPAQUE","JOKERS","INJURY","ZODIAC","FLIGHT","LIVING","SCHOOL","COURSE","AVENUE"},
 //6 LETTER WORDS
 {"MISTAKE","REFLECT","HANGING","PERFUME","PHYSICS","HISTORY","CONSOLE","AMERICA","SELLING","FINANCE",
   "RESPECT","SPONSOR","VISIBLE","GERMANY","MYANMAR","ENGLAND","SPANISH","IRELAND","VEHICLE","TALENTS",
    "SHALLOW","MORNING","PRESENT","GESTURE","ADDRESS","COLLECT","SEASONS","CLOTHES","COSTUME","BALANCE",
     "FREEDOM","WEATHER","PRODUCE","BURNOUT","CAPTURE","PERFORM","SURGERY","CHARGER","LETTERS","THERAPY",
      "DROPLET","WAITING","BEDROOM","RONALDO","ANDROID","EXPENSE","JACUZZI","AIRLINE","ROOSTER","STARTER"},
 //7 LETTER WORDS
 {"ABSOLUTE","BACHELOR","BLACKOUT","CHILDREN","COMPLAIN","DINOSAUR","DYNAMITE","EMIGRANT","FRACTION","GOLDFISH",
   "HANGOVER","HARMONIC","HUMANITY","IMPOSTER","ISOLATED","JEALOUSY","KILOBYTE","LAUGHTER","LOVESICK","MAGNETIC",
     "MANGROVE","MERCIFUL","MOISTURE","MONSIEUR","NATURISM","NOVELIST","OBLIGATE","OLYMPIAD","OUTBREAK","PANICKED",
      "PARTICLE","PERSUING","PICTURED","PLAYSUIT","PLEASING","PLUTONIC","POLARIZE","PONYTAIL","POWERFUL","PROCLAIM",
       "PROFILED","QUERYING","SCRAMBLE","RANDOMLY","RELAUNCH","SAMPLING","VELOCITY","THOUSAND","THANKFUL","STUDYING"}};
 //8 LETTER WORDS

 public void game_over(){
    Calendar fin = Calendar.getInstance();
    end_time = (int)fin.getTimeInMillis();
    wolf_run.stop();
   caps.stop();
   cloud.stop();
       JOptionPane.showMessageDialog(rootPane, "Game over", "Sorry", JOptionPane.PLAIN_MESSAGE);
       dispose();
       double time_taken = (end_time-start_time)/1000;
       DecimalFormat df = new DecimalFormat("#.##");
       df.format(time_taken);
       Main.time_elapsed = (int)time_taken;
       Main.correct=this.correct;
       
       try {
         write();
      } catch (FileNotFoundException ex) {
         Logger.getLogger(page3.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(page3.class.getName()).log(Level.SEVERE, null, ex);
      }
       
       Main.main3();
 }
    public void write() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("src/highscores.txt");
        BufferedReader br = new BufferedReader(fr);
        String users="";
        String str;
        while((str=br.readLine())!=null){
           users=users+str+" \n";
        }
        br.close();

        FileWriter fw = new FileWriter("src/highscores.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(users+Main.name+" | "+Main.parid+ " | "+Main.correct+" | "+Main.time_elapsed+" | "+Main.points+" |");
        pw.close();
           System.out.println("write successful");
    }
 
   public page2() {
      initComponents();
      start_button.setVisible(true);
      wolf.setVisible(false);
      answer.setVisible(false);
      cloud1.setVisible(false);
      cloud1_text.setVisible(false);
      cloud2.setVisible(false);
      cloud2_text.setVisible(false);
      cloud3.setVisible(false);
      cloud3_text.setVisible(false);
      cloud4.setVisible(false); 
      cloud4_text.setVisible(false);
      
      cloud1.setBounds(l, (int)(Math.random()*230), width, height);
      cloud1_text.setBounds(cloud1.getX()+10, cloud1.getY()+40, width_text, height_text);
      while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud1_text.setText(words[dif][random]);
      cloud1_text.setToolTipText(words[dif][random]); 
      words[dif][random]="null";
      break;}
      }
      
      cloud2.setBounds(l+dist, (int)(Math.random()*230), width, height);
      cloud2_text.setBounds(cloud2.getX()+10, cloud2.getY()+40, width_text, height_text);
      while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud2_text.setText(words[dif][random]);
      cloud2_text.setToolTipText(words[dif][random]); 
      words[dif][random]="null";
      break;}
      }
      
      cloud3.setBounds(l+(dist*2), (int)(Math.random()*230), width, height);
      cloud3_text.setBounds(cloud3.getX()+10, cloud3.getY()+40, width_text, height_text);
      while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud3_text.setText(words[dif][random]);
      cloud3_text.setToolTipText(words[dif][random]); 
      words[dif][random]="null";
      break;}
      }
      
      cloud4.setBounds(l+(dist*3), (int)(Math.random()*230), width, height);
      cloud4_text.setBounds(cloud4.getX()+10, cloud4.getY()+40, width_text, height_text);
      while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud4_text.setText(words[dif][random]);
      cloud4_text.setToolTipText(words[dif][random]); 
      words[dif][random]="null";
      break;}
      }
   }
   
   
   
   int wolf_speed=100;
   Timer wolf_run = new Timer(wolf_speed, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
       pic  = new ImageIcon(getClass().getResource("/wolf"+i+".png"));
       wolf.setIcon(pic);
       repaint();
       i=i+1;
       if(i>9)
          i=1;
    }    
});
   
   Timer caps = new Timer(10,new ActionListener(){
      public void actionPerformed(ActionEvent evt) {
         try{
         answer.setText(answer.getText().toUpperCase());
            
         if(answer.getText().equals((cloud1_text.getToolTipText()).substring(0, (answer.getText()).length()))){ 
            cloud1_text.setText("<html><font color=GREEN>"+(cloud1_text.getToolTipText()).substring(0, (answer.getText()).length())+"</font><font color=black>"+ (cloud1_text.getToolTipText()).substring((answer.getText()).length())+"</font></html>");
         }
         if(answer.getText().equals((cloud2_text.getToolTipText()).substring(0, (answer.getText()).length()))){ 
            cloud2_text.setText("<html><font color=GREEN>"+(cloud2_text.getToolTipText()).substring(0, (answer.getText()).length())+"</font><font color=black>"+ (cloud2_text.getToolTipText()).substring((answer.getText()).length())+"</font></html>");
         }
         if(answer.getText().equals((cloud3_text.getToolTipText()).substring(0, (answer.getText()).length()))){ 
            cloud3_text.setText("<html><font color=GREEN>"+(cloud3_text.getToolTipText()).substring(0, (answer.getText()).length())+"</font><font color=black>"+ (cloud3_text.getToolTipText()).substring((answer.getText()).length())+"</font></html>");
         }
         if(answer.getText().equals((cloud4_text.getToolTipText()).substring(0, (answer.getText()).length()))){ 
            cloud4_text.setText("<html><font color=GREEN>"+(cloud4_text.getToolTipText()).substring(0, (answer.getText()).length())+"</font><font color=black>"+ (cloud4_text.getToolTipText()).substring((answer.getText()).length())+"</font></html>");
         }
          
         if(answer.getText().equals(cloud1_text.getToolTipText())){
         cloud1.setBounds(cloud4.getX()+dist, (int)(Math.random()*230), width, height);
       cloud1_text.setBounds(cloud1.getX()+10, cloud1.getY()+40, width_text, height_text);
       Main.points=Main.points+(3+dif);
       while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud1_text.setText(words[dif][random]);
      cloud1_text.setToolTipText(words[dif][random]);
      words[dif][random]="null";
      break;}
      }
       answer.setText("");correct=correct+1;}
         
         if(answer.getText().equals(cloud2_text.getToolTipText())){
       cloud2.setBounds(cloud1.getX()+dist, (int)(Math.random()*230), width, height); 
       cloud2_text.setBounds(cloud2.getX()+10, cloud2.getY()+40, width_text, height_text);
       Main.points=Main.points+(3+dif);
       while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud2_text.setText(words[dif][random]);
      cloud2_text.setToolTipText(words[dif][random]);
      words[dif][random]="null";
      break;}
      }
         answer.setText("");correct=correct+1;} 
         
       if(answer.getText().equals(cloud3_text.getToolTipText())){
       cloud3.setBounds(cloud2.getX()+dist, (int)(Math.random()*230), width, height); 
       cloud3_text.setBounds(cloud3.getX()+10, cloud3.getY()+40, width_text, height_text);
       Main.points=Main.points+(3+dif);
      while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud3_text.setText(words[dif][random]);
      cloud3_text.setToolTipText(words[dif][random]);
      words[dif][random]="null";
      break;}
      }
       answer.setText("");correct=correct+1;} 
       
       if(answer.getText().equals(cloud4_text.getToolTipText())){
       cloud4.setBounds(cloud3.getX()+dist, (int)(Math.random()*230), width, height); 
       cloud4_text.setBounds(cloud4.getX()+10, cloud4.getY()+40, width_text, height_text);
       Main.points=Main.points+(3+dif);
       while(true)
      {
      random=(int)(Math.random()*50);
      if((words[dif][random].equals("null"))==false){   
      cloud4_text.setText(words[dif][random]);
      cloud4_text.setToolTipText(words[dif][random]);
      words[dif][random]="null";
      break;}
      }
       answer.setText("");correct=correct+1;} 
      }
      
      catch(StringIndexOutOfBoundsException sob){
         answer.setText(answer.getText().substring(0, 3+dif));
      }
   }
   });
   
   
    int time = 10;
    int spd =1;
   Timer cloud = new Timer(time, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
       cloud1.setBounds(cloud1.getX()-spd, cloud1.getY(), width, height);
       cloud1_text.setBounds(cloud1_text.getX()-spd, cloud1_text.getY(), width_text, height_text);
       cloud2.setBounds(cloud2.getX()-spd, cloud2.getY(),  width, height);
       cloud2_text.setBounds(cloud2_text.getX()-spd, cloud2_text.getY(), width_text, height_text);
       cloud3.setBounds(cloud3.getX()-spd, cloud3.getY(), width, height);
       cloud3_text.setBounds(cloud3_text.getX()-spd, cloud3_text.getY(), width_text, height_text);
       cloud4.setBounds(cloud4.getX()-spd, cloud4.getY(), width, height);
       cloud4_text.setBounds(cloud4_text.getX()-spd, cloud4_text.getY(), width_text, height_text);
       if(cloud1.getX()<0)game_over();
       if(cloud2.getX()<0)game_over();
       if(cloud3.getX()<0)game_over();
       if(cloud4.getX()<0)game_over();
       
       if(correct>=6)
       {spd=2; wolf_speed=96;}
       if(correct>=12)
       {spd=3; wolf_speed=94;}
       if(correct>=16)
       {dif=1;dist=255;wolf_speed=90;spd=2;}
       if(correct>=35)
       {dif=2;dist=260;wolf_speed=85;}
       if(correct>=50)
       {dif=3;dist=265;wolf_speed=80;}
       if(correct>=65)
       {dif=4;dist=270;wolf_speed=75;}
       if(correct>=80)
       {dif=5;dist=275;wolf_speed=70;}
       if(correct>=95)
       {dif=6;dist=285;wolf_speed=65;}
       if(correct>=110)
       {dif=7;dist=300;wolf_speed=60;}
       if(correct==120)
       game_over();
    }
});
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        start_button = new javax.swing.JButton();
        answer = new javax.swing.JTextField();
        wolf = new javax.swing.JLabel();
        cloud1_text = new javax.swing.JLabel();
        cloud2_text = new javax.swing.JLabel();
        cloud3_text = new javax.swing.JLabel();
        cloud4_text = new javax.swing.JLabel();
        cloud2 = new javax.swing.JLabel();
        cloud1 = new javax.swing.JLabel();
        cloud3 = new javax.swing.JLabel();
        cloud4 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(849, 499));
        getContentPane().setLayout(null);

        start_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button start.png"))); // NOI18N
        start_button.setToolTipText("press this button to start the game");
        start_button.setBorder(null);
        start_button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/button_start_go.png"))); // NOI18N
        start_button.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/button_start_go.png"))); // NOI18N
        start_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
        });
        start_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                start_buttonKeyPressed(evt);
            }
        });
        getContentPane().add(start_button);
        start_button.setBounds(270, 80, 340, 310);

        answer.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        answer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answer.setToolTipText("Type in your answer here");
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });
        getContentPane().add(answer);
        answer.setBounds(400, 370, 420, 80);

        wolf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wolf1.png"))); // NOI18N
        getContentPane().add(wolf);
        wolf.setBounds(10, 310, 388, 165);

        cloud1_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cloud1_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cloud1_text.setText("LABEL1");
        cloud1_text.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(cloud1_text);
        cloud1_text.setBounds(870, 50, 130, 30);

        cloud2_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cloud2_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cloud2_text.setText("LABEL2");
        getContentPane().add(cloud2_text);
        cloud2_text.setBounds(870, 140, 130, 30);

        cloud3_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cloud3_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cloud3_text.setText("LABEL3");
        getContentPane().add(cloud3_text);
        cloud3_text.setBounds(870, 230, 130, 30);

        cloud4_text.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cloud4_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cloud4_text.setText("LABEL4");
        getContentPane().add(cloud4_text);
        cloud4_text.setBounds(870, 320, 130, 30);

        cloud2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloud.png"))); // NOI18N
        getContentPane().add(cloud2);
        cloud2.setBounds(860, 100, 150, 90);

        cloud1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloud.png"))); // NOI18N
        cloud1.setToolTipText("");
        getContentPane().add(cloud1);
        cloud1.setBounds(860, 10, 150, 100);

        cloud3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloud.png"))); // NOI18N
        getContentPane().add(cloud3);
        cloud3.setBounds(860, 190, 150, 90);

        cloud4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cloud.png"))); // NOI18N
        getContentPane().add(cloud4);
        cloud4.setBounds(860, 280, 150, 90);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroung2.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 850, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_answerActionPerformed

   private void start_buttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_start_buttonKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         Calendar now1 = Calendar.getInstance();
         long s1 = now1.getTimeInMillis();
         while (true) {
            Calendar now2 = Calendar.getInstance();
            long s2 = now2.getTimeInMillis();
            if (s2 >= s1 + 500) {
               break;
            }
         }
         Calendar start = Calendar.getInstance();
         start_time = (int)start.getTimeInMillis();
         start_button.setVisible(false);
         wolf.setVisible(true);
         answer.setVisible(true);
         cloud1.setVisible(true);
         cloud1_text.setVisible(true);
         cloud2.setVisible(true);
         cloud2_text.setVisible(true);
         cloud3.setVisible(true);
         cloud3_text.setVisible(true);
         cloud4.setVisible(true);
         cloud4_text.setVisible(true);
         answer.requestFocus();
         wolf_run.start();
         caps.start();
         cloud.start();
      }
   }//GEN-LAST:event_start_buttonKeyPressed

   private void start_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_buttonActionPerformed
      Calendar now1 = Calendar.getInstance();
      long s1 = now1.getTimeInMillis();
      while (true) {
         Calendar now2 = Calendar.getInstance();
         long s2 = now2.getTimeInMillis();
         if (s2 >= s1 + 500) {
            break;
         }
      }
      Calendar start = Calendar.getInstance();
      start_time = (int)start.getTimeInMillis();
      start_button.setVisible(false);
      wolf.setVisible(true);
      answer.setVisible(true);
      cloud1.setVisible(true);
      cloud1_text.setVisible(true);
      cloud2.setVisible(true);
      cloud2_text.setVisible(true);
      cloud3.setVisible(true);
      cloud3_text.setVisible(true);
      cloud4.setVisible(true);
      cloud4_text.setVisible(true);
      answer.requestFocus();
      wolf_run.start();
      caps.start();
      cloud.start();
      System.out.println("executed");
   }//GEN-LAST:event_start_buttonActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /*
       * Set the Nimbus look and feel
       */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the
       * default look and feel. For details see
       * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(page2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(page2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(page2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(page2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /*
       * Create and display the form
       */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new page2().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JLabel background;
    private javax.swing.JLabel cloud1;
    private javax.swing.JLabel cloud1_text;
    private javax.swing.JLabel cloud2;
    private javax.swing.JLabel cloud2_text;
    private javax.swing.JLabel cloud3;
    private javax.swing.JLabel cloud3_text;
    private javax.swing.JLabel cloud4;
    private javax.swing.JLabel cloud4_text;
    private javax.swing.JButton start_button;
    private javax.swing.JLabel wolf;
    // End of variables declaration//GEN-END:variables
}
