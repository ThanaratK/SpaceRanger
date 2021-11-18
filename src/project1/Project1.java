package project1;
import java.awt.*;
//import java.awt.Font;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
//import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Project1 {
    /*public static void main(String[] args) {
        JFrame jf = new Play();
        jf.setSize(1000,800);
        jf.setTitle("Animation Example");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);*/

    public static void main(String[] args) {
        // TODO code application logic here
        GUI jframe= new GUI();
        jframe.setTitle("space ranger");
        jframe.setSize(1500,900);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        
    }    
}

class GUI extends JFrame{
    GUI(){
        add(new Draw());
    }
    class Draw extends JPanel{
        URL imageURL=this.getClass().getResource("astro.png");
        Image image=new ImageIcon(imageURL).getImage();
        URL imageURL1=this.getClass().getResource("pirate.png");
        Image image1=new ImageIcon(imageURL1).getImage();
        URL imageURL2=this.getClass().getResource("pirate.png");
        Image image2=new ImageIcon(imageURL2).getImage();
        URL BackgroundURL=this.getClass().getResource("Background.png");
        Image bg=new ImageIcon(BackgroundURL).getImage();
        private Timer time = new Timer(50,new Listener());
        char keyChar = 'A';
        int x=40;
        int y=600;
        int a=170;
        int b=170;
        int c=1050;
        int d=400;
        
        Draw(){
            setFocusable(true);
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    
                }

                @Override
                public void mousePressed(MouseEvent me) {
                    time.stop();
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                    time.start();
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    
                }
            });
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent ke) {
                    
                }

                @Override
                public void keyPressed(KeyEvent ke) {
                   switch(ke.getKeyCode()){
                       case KeyEvent.VK_DOWN:y+=10;break;
                       case KeyEvent.VK_UP:y-=10;break;
                       case KeyEvent.VK_LEFT:x-=10;break;
                       case KeyEvent.VK_RIGHT:y+=10;break;
                       default:keyChar=ke.getKeyChar();
                   }
                   repaint();
                }

                @Override
                public void keyReleased(KeyEvent ke) {
                   
                }
            });
            time.start();
        }
            public void paintComponent(Graphics g){
            super.paintComponents(g);  
            g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
            if(x>0){
                x=x+1;
            }
            g.drawImage(image, x, y,135,135,this);
            g.drawImage(image1, a, b,125,125,this);
            g.drawImage(image2, c, d,125,125,this);
            g.setColor(Color.white);
            g.setFont(new Font("TimeRoman",Font.BOLD,40));
            g.drawString("score", 50,50);
            
        } 
        class Listener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                repaint();
            }
        }
    }   
}