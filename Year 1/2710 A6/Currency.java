import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Currency{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		final int fWidth = 450;
		final int fHeight= 350;
		frame.setSize(fWidth,fHeight);
		CurrencyPanel panel = new CurrencyPanel();
		frame.add(panel);
		frame.setTitle("Currency Conversion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class CurrencyData{
	private double amtMoney;
	private double convertedAmt;
	
	public CurrencyData(double m){
		amtMoney = m;
		convertedAmt = 0;
	}
	
	public double getMoney(){
		return amtMoney;
	}
	
	public void setMoney(double x){
		this.amtMoney = x;		
	}
	
	public double getConvAmt(){
		return convertedAmt;
	}
	
	public void setConvAmt(double c){
		this.convertedAmt = c;
	}
	
	public double convertCurrency(double rate){
		return amtMoney * rate;
	}
}

class CurrencyPanel extends JPanel{
	private CurrencyData cd;
	private TextField input;
	private JComboBox inType;
	private JComboBox outType;
	private JButton convert;
	private JLabel results;
	private JLabel sameEr;
	
	public CurrencyPanel(){
		cd = new CurrencyData(1.00);
		input = new TextField(Double.toString(cd.getMoney()));
		
		inType = new JComboBox();
		inType.addItem("EUR");
		inType.addItem("GBP");
		inType.addItem("USD");
		
		outType = new JComboBox();
		outType.addItem("EUR");
		outType.addItem("GBP");
		outType.addItem("USD");
		
		convert = new JButton("Convert");
		ButtonListener bl = new ButtonListener();
		convert.addActionListener(bl);
		results = new JLabel("Result: ");
		add(input);
		add(inType);
		add(outType);
		add(convert);
		add(results);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double rate = 0;
			cd.setMoney(Double.parseDouble(input.getText()));
			if 		(inType.getSelectedItem().equals("EUR") && outType.getSelectedItem().equals("USD")) rate = 1.42;
			else if (inType.getSelectedItem().equals("EUR") && outType.getSelectedItem().equals("GBP")) rate = 1/1.13;
			else if (inType.getSelectedItem().equals("GBP") && outType.getSelectedItem().equals("EUR")) rate = 1.13;
			else if (inType.getSelectedItem().equals("GBP") && outType.getSelectedItem().equals("USD")) rate = 1.64;
			else if (inType.getSelectedItem().equals("USD") && outType.getSelectedItem().equals("EUR")) rate = 1/1.42;
			else if (inType.getSelectedItem().equals("USD") && outType.getSelectedItem().equals("GBP")) rate = 1/1.64;
			cd.setConvAmt(cd.convertCurrency(rate));
			results.setText("Converted amount: " + (double)Math.round(cd.getConvAmt()*100)/100);
			
			if (inType.getSelectedItem().equals(outType.getSelectedItem())) results.setText("You have selected the same currency.");			
		}
	}
}
