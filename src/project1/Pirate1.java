package project1;
import java.awt.geom.Rectangle2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.net.URL;

public class Pirate1 {
    Image img;
    public int x=1050;
    public int y=400;
    public int count=0;
    Pirate1(){
        String imageLocation="pirate.png";
        URL imageURL=this.getClass().getResource("pirate.png");
        img=Toolkit.getDefaultToolkit().getImage(imageURL);
    }
    public Image getimage(){
        return img;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public Rectangle2D getbound(){
        return(new Rectangle2D.Double(x,y,1050,400));
    }
    
}
