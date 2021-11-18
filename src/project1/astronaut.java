package project1;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class astronaut {
   public ImageIcon[] im = new ImageIcon[1];
    public int x;
    public int count = 0;
    astronaut(){
        for(int i=0;i<im.length;i++){
           im[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
	}
    }
} 