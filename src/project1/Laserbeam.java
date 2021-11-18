package project1;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.net.URL;

public class Laserbeam extends JPanel{
    public ImageIcon[] laser =new ImageIcon[2];
    public int y;
    public int x;
    public int count=0;
    Laserbeam(int x,int y){
        for(int i=0;i<laser.length;i++){
           String imageLocation="laser"+(i+i)+".png";
           laser[i]=new ImageIcon(this.getClass().getResource(imageLocation)); 
        }
            this.x=x;
            this.y=y;
    } 
    public void move(){
        this.x=+1;
    }
    public Rectangle2D getbound(){
        return(new Rectangle2D.Double(x,y,25,25));
    }
}