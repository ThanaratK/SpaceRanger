package project1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Home extends JPanel {
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("space.jpg"));
    private ImageIcon astronaut = new ImageIcon(this.getClass().getResource("astronaut1.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.jpg"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("Start-button.png"));
    public JButton BStart = new JButton(starts);
    public JButton BExit = new JButton(exit);
	Home(){
            setLayout(null);
            BExit.setBounds(500, 650, 150,90);
            add(BExit);
            add(BStart);
            BStart.setBounds(750,650,150,90);
            add(BStart);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            g.drawImage(astronaut.getImage(), 580, 380, 400, 400, this);
            g.setColor(Color.white);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            g.drawString("Space Ranger",70,200);	
	}
}