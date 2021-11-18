package project1;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gameover extends JPanel{
    private ImageIcon feildover = new ImageIcon("explosion.jpg");
    private ImageIcon exitover = new ImageIcon("exit.jpg");
    private ImageIcon restart = new ImageIcon("Start.jpg");
    public JButton BStartover = new JButton(restart);
    public JButton BExitover  = new JButton(exitover); 
    
    Gameover(){
        this.setLayout(null);
	BExitover.setBounds(500, 650, 150,90);
	add(BExitover);
        add(BStartover);
	BStartover.setBounds(750,650,150,90);
        add(BStartover);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(feildover.getImage(),0,0,1500,900,this);
    }		 
}
