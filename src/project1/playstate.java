package project1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import static javax.management.Query.times;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class playstate extends JPanel implements ActionListener {
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("background.jpg"));
	private final ImageIcon imgast = new ImageIcon(this.getClass().getResource("astronaut1.png"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("pause.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("resume.png"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
	astronaut m = new astronaut();
        
	Home hg = new Home();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("space.jpg"));
	ImageIcon img_paralyze = new ImageIcon(this.getClass().getResource("astronaut1.png"));
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("start.jpg"));
        JButton BStartover = new JButton(restart);
	JButton BExitover  = new JButton(exitover);
	
	private JLabel score = new JLabel(); 
        public JButton BPause  = new JButton(pause);
	public JButton BExithome  = new JButton(back); 
	public JButton Bresum  = new JButton(resum);
	public ArrayList<Laserbeam> fireball = new ArrayList<Laserbeam>();
	public ArrayList<laserbeam1> ba1 = new ArrayList<laserbeam1>();
	public ArrayList<laserbeam2> ba2 = new ArrayList<laserbeam2>();
        
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startbeam = false;
	
	private Gameover gover = new Gameover();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
        Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	Thread laser1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startbeam == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startbeam == false){
                            ba1.add(new laserbeam1());
			}
		}
            }
	});
	Thread laser2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startbeam==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startbeam == false){
                            ba2.add(new laserbeam2());
			}
		}
            }
	});
        Thread paralyze = new Thread(new Runnable(){
            public void run(){
		while (true){
			if(time_paralyze < 1){
                            paralyze1 = false;
                            time_paralyze = 5;
			}
			try{
                            Thread.sleep(5000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
	
	playstate(){
		this.setFocusable(true);
		this.setLayout(null);
		BPause.setBounds(850,100,40,40);
		BExithome.setBounds(850,30,40,40);
		Bresum.setBounds(850, 170, 40,40);
		BPause.addActionListener(this);
		BExithome.addActionListener(this);
		Bresum.addActionListener(this);
		BExithome.addActionListener(this);
		this.add(BPause);
		this.add(BExithome);
		this.add(score);
		this.add(Bresum);
		
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			if(!paralyze1){
			    if(a==KeyEvent.VK_A){
			     	m.x-=10;
                                m.count++;
                            }
                            else if(a == KeyEvent.VK_D){
                               m.x+=10;
                               m.count++;
			   }
                            if(m.count>3){
                                m.count=0;
                            }
                            else if(a == KeyEvent.VK_UP){
                               m.count=5;
			       fireball.add(new Laserbeam(m.x,550));
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		m.x = 400;
		time.start();
		actor.start();
		t.start();
		laser1.start();
		laser2.start();
		paralyze.start();
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(times <= 0 || HP<=0){
                this.remove(BPause);
                this.remove(Bresum);
                this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE   "+scor,380,200);	     
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
                g.drawString("GAME OVER",290,150);
                g.drawImage(imgast.getImage(), 580, 360, 400, 400, this);
                }
 		//===========ball1================
		for(int i=0 ; i<ba1.size();i++){
                    g.drawImage( ba1.get(i).getImage() ,ba1.get(i).getX(),ba1.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<ba1.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),ba1.get(j).getbound())){
                            ba1.remove(j);
			    fireball.remove(i);
                            scor += 10;
			    g.drawString("+10",m.x+100,650);
                        } 
		    }
		}
		//===========ball2================
		for(int i=0 ; i<ba2.size();i++){
                    g.drawImage(ba2.get(i).getImage(),ba2.get(i).getX(),ba2.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<ba2.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),ba2.get(j).getbound())){
			    ba2.remove(j);
			    fireball.remove(i);
			    scor += 20;
			    g.drawString("+20",m.x+100,650);
   			} 
		    }
		}
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,80, 100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("STATE "+rs2,350,80);    
		g.drawString("Time "+times,335,150);
		g.drawString("HP  "+HP,100,200);  
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource()== BStartover){
            this.setSize(1500,900);
            this.add(hg);
            this.setLocation(null);
            timestart=true;
            startbeam=true;
        }else if(ae.getSource()==BExitover){
            System.exit(0);
        }
    }
    public boolean Intersect(Rectangle2D a,Rectangle2D b){
        return (a.intersects(b));
    }
}  