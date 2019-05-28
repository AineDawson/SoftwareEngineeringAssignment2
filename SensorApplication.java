import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

public class SensorApplication extends JFrame {
	public SensorApplication() {
		//The sensor objects
		PressureSensor pS=new PressureSensor();
		RadiationSensor rS=new RadiationSensor();
		TemperatureSensor tS=new TemperatureSensor();
		Sensors pAdaptor=new PressureAdaptor(pS);
		Sensors rAdaptor=new RadiationAdaptor(rS);
		Sensors tAdaptor=new TemperatureAdaptor(tS);
		//Gets double value and sring value for each sensors status
		double pValue=pAdaptor.getReading();
		String pStatus=pAdaptor.getReport();
		double tValue=tAdaptor.getReading();
		String tStatus=tAdaptor.getReport();
		double rValue=rAdaptor.getReading();
		String rStatus=rAdaptor.getReport();
		
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
		//Information for the Temperature Panel
		JPanel  temperaturePnl = new JPanel();
		temperaturePnl.setLayout(null);
		temperaturePnl.setBorder(new TitledBorder(tAdaptor.getName()));
		add(temperaturePnl);
		JTextField tBar=displayBar(tValue,1);
		tBar.setBackground(barColor(tStatus));
		temperaturePnl.add(tBar);
		JTextField tInfo=displayStatus(tValue,tStatus);
		temperaturePnl.add(tInfo);
		
		//Information for the Pressure Panel
		JPanel  pressurePnl = new JPanel();
		pressurePnl.setLayout(null);
		pressurePnl.setBorder(new TitledBorder(pAdaptor.getName()));
		add(pressurePnl);
		JTextField pBar=displayBar(pValue,15);
		pBar.setBackground(barColor(pStatus));
		pressurePnl.add(pBar);
		JTextField pInfo=displayStatus(pValue,pStatus);
		pressurePnl.add(pInfo);
		
		//Information for the Radiation Panel
		JPanel  radiationPnl = new JPanel();
		radiationPnl.setLayout(null);
		radiationPnl.setBorder(new TitledBorder(rAdaptor.getName()));
		add(radiationPnl);
		JTextField rBar=displayBar(rValue,10);
		rBar.setBackground(barColor(rStatus));
		radiationPnl.add(rBar);
		JTextField rInfo=displayStatus(rValue,rStatus);
		radiationPnl.add(rInfo);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
	//Sets the color of the bar depending on the Sensors status
	public Color barColor(String s) {
		if(s.equals("OK"))
			return Color.green;
		if(s.equals("CRITICAL"))
			return Color.yellow;
		else
			return Color.red;
	}
	//Creates a text field to display text of sensor data
	public JTextField displayStatus(double d, String s) {
		JTextField sInfo=new JTextField();
		sInfo.setBounds(10, 120, 150, 20);
		sInfo.setEditable(false);
		sInfo.setText(s+"--->"+d);
		return sInfo;
	}
	//Creates a text field to show a visual representation of sensor data
	public JTextField displayBar(double d, int x) {
		JTextField bar=new JTextField();
		bar.setBounds(10, 50, (int)(d*x), 50);
		bar.setEditable(false);
		return bar;
	}
	
}
