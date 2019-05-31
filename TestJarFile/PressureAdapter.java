import java.awt.Color;

import sensor.PressureSensor;

public class PressureAdapter implements Sensor {
	private PressureSensor adaptee;
	public static final int MAX_VALUE = 10;
	
	public PressureAdapter(PressureSensor sensor) {
		adaptee = sensor;
	}
	@Override
	public double getValue() {
		return adaptee.readValue();
	}

	@Override
	public String getStatus() {
		return adaptee.getReport();
	}

	@Override
	public String getType() {
		return adaptee.getSensorName();
	}
	@Override
	public int getMaxValue() {
		return 10;
	}
	
	public Color calculateColor(double value) {
		if (value <= 5.0) {
			return Color.green;
		} else if (value <= 6.58) {
			return Color.yellow;
		} else {
			return Color.red;
		}
	}
}
