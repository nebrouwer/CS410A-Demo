import java.awt.Color;

import sensor.TemperatureSensor;


public class TemperatureAdapter implements Sensor {
	private TemperatureSensor adaptee;
	public int MAX_VALUE = 500;
	
	public TemperatureAdapter(TemperatureSensor sensor) {
		adaptee = sensor;
	}
	
	@Override
	public double getValue() {
		return adaptee.senseTemperature();
	}

	@Override
	public String getStatus() {
		return adaptee.getTempReport();
	}

	@Override
	public String getType() {
		return adaptee.getSensorType();
	}

	@Override
	public int getMaxValue() {
		return 500;
	}

	@Override
	public Color calculateColor(double value) {
		if (value <= 235.0) {
			return Color.green;
		} else if (value <= 300.0) {
			return Color.yellow;
		} else {
			return Color.red;
		}
	}	
}
