import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class ClockRunner {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		final int fWidth = 450;
		final int fHeight= 250;
		frame.setSize(fWidth,fHeight);
		ClockPanel panel = new ClockPanel();
		frame.add(panel);
		frame.setTitle("Clock Time Setter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Clock {
	private int minute;
	private int hour;

	public Clock (int m, int h){
		this.minute = m;
		this.hour = h;
	}

	public int getMinute(){
		return minute;
	}

	public int getHour(){
		return hour;
	}

	public void setMinute(int m){
		minute = m;
	}

	public void setHour(int h){
		hour = h;
	}

	public int calcMinuteTotal(){
		return (hour*60) + minute;
	}

	public double calculateAngleMinute(){
		return minute*(Math.PI/30);
	}

	public double calculateAngleHour(){
		return calcMinuteTotal() * (Math.PI/360);
	}

	public void drawClock(Graphics page){
		Graphics2D g2 = (Graphics2D) page;
		g2.setColor(Color.BLACK);
		g2.draw(new Ellipse2D.Double(0,0,100,100));
		g2.setColor(Color.RED);
		g2.draw(new Line2D.Double(50,50,50+40*Math.sin(calculateAngleMinute()),50-40*Math.cos(calculateAngleMinute())));
		g2.setColor(Color.BLUE);
		g2.draw(new Line2D.Double(50,50,50+25*Math.sin(calculateAngleHour()),50-25*Math.cos(calculateAngleHour())));
	}
}

class ClockPanel extends JPanel {
	private Clock clock;
	private JButton timeSet;
	private JTextField hourIn;
	private JTextField minuteIn;

	public ClockPanel(){
		clock = new Clock(0,0);
		JLabel hoursBox = new JLabel("Hour:");
		hourIn = new JTextField(2);
		JLabel minsBox = new JLabel("Minute:");
		minuteIn = new JTextField(2);
		setPreferredSize(new Dimension(400,200));
		setFont(new Font("Arial", Font.BOLD,12));
		timeSet = new JButton("Set Time");
		ButtonListener bl = new ButtonListener();
		timeSet.addActionListener(bl);
		hourIn.addActionListener(bl);
		minuteIn.addActionListener(bl);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(100,100));

		buttonPanel.add(timeSet);
		buttonPanel.add(hoursBox);
		buttonPanel.add(hourIn);
		buttonPanel.add(minsBox);
		buttonPanel.add(minuteIn);
		add(buttonPanel);
	}

	public void paintComponent(Graphics page){
		super.paintComponent(page);
		clock.drawClock(page);
	}


	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if (event.getSource() == timeSet){
				clock.setMinute(Integer.parseInt(minuteIn.getText()));
				clock.setHour(Integer.parseInt(hourIn.getText()));
				repaint();
			}
		}
	}
}