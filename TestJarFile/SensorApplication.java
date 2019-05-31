import sensor.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
		Sensor[] sensors = {new PressureAdapter(new PressureSensor()),
							new RadiationAdapter(new RadiationSensor()),
							new TemperatureAdapter(new TemperatureSensor())}; 
		
		for (Sensor sensor : sensors) {
			JPanel newPanel = new JPanel();
			newPanel.setLayout(new GridLayout(2, 0));
			newPanel.setBorder(new TitledBorder(sensor.getType()));
		
			Double value = sensor.getValue();
			int displayValue = (int) Math.floor(value);
			System.out.println(displayValue);
			System.out.println();
			
			JProgressBar progressBar = new JProgressBar(0, sensor.getMaxValue());
			progressBar.setValue(displayValue);
			progressBar.setForeground(sensor.calculateColor(value));
			
			newPanel.add(progressBar);
			
			JLabel text = new JLabel(sensor.getStatus() + " --> " + value);
			
			newPanel.add(text);
			
			add(newPanel);
		}
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
