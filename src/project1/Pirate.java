package project1;
import java.awt.geom.Rectangle2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.net.URL;

public class Pirate {
    Image img;
    public int x=170;
    public int y=170;
    public int count=0;
    Pirate(){
        String imageLocation="pirate.png";
        URL imageURL=this.getClass().getResource("pirate.png");
        img=Toolkit.getDefaultToolkit().getImage(imageURL);
        //runner.start();
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
        return(new Rectangle2D.Double(x,y,125,125));
    }
}
