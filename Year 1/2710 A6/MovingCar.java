import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.Timer;

public class MovingCar {
	private int x;
	private int y;
public MovingCar(int xPos, int yPos){
	x = xPos;
	y = yPos;
}
	
	
public void paintComponent(Graphics g){
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.RED);
	g2.fill(new Rectangle2D.Double(x+20,y+20,60,40));
	g2.fill(new Rectangle2D.Double(x+70,y+30,30,30));		
	g2.setColor(Color.BLACK);
	g2.fill(new Ellipse2D.Double(x+30,y+45,20,20));		
	g2.fill(new Ellipse2D.Double(x+65,y+45,20,20));		
	}
	
	public void moveCarBy(int dx){
		x+= dx;
	}
}
	class CarRunner{
		public static void main(String[] args){
		JFrame frame = new JFrame();
		final int fWidth = 450;
		final int fHeight= 250;
		frame.setSize(fWidth,fHeight);
		CarPanel panel = new CarPanel();
		frame.add(panel);
		frame.setTitle("Moving Car");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	}
	

	class CarPanel extends JPanel{
		private MovingCar Chevy;
		public CarPanel(){
			Chevy = new MovingCar(0, 35);
			TimerListener q = new TimerListener();
			Timer t = new Timer(15,q);
			t.start();
		}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Chevy.paintComponent(g);
		}
	class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Chevy.moveCarBy(1);
			repaint();
		}
	}
	
	}
