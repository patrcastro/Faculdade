
import java.applet.*;
import java.awt.*;
import java.lang.*;

public class FractalTree extends Applet{

	public void init() {
		setBackground(Color.WHITE);
		setSize(1200,600);
		
	}
	
	public void paint(Graphics g) {
		try {
			makeTree(100,0,600,550,g);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void makeTree(int length, int angle, int x, int y, Graphics g) throws InterruptedException{
		int xmove = (int) (Math.cos(Math.toRadians(angle+90))*length);
		int ymove = (int) (Math.sin(Math.toRadians(angle-90))*length);
		g.drawLine(x,y,x+xmove,y+ymove);
		Thread.sleep(50);
		if (length >= 1) {
			makeTree(length-10,angle+30,x+xmove,y+ymove,g);
			makeTree(length-10,angle-30,x+xmove,y+ymove,g);
		}
	}

}
