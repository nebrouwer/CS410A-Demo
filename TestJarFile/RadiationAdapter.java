import java.awt.Color;

import sensor.RadiationSensor;

public class RadiationAdapter implements Sensor {
	private RadiationSensor adaptee;
	
	public RadiationAdapter(RadiationSensor sensor) {
		adaptee = sensor;
	}
	@Override
	public double getValue() {
		return adaptee.getRadiationValue();
	}

	@Override
	public String getStatus() {
		return adaptee.getStatusInfo();
	}

	@Override
	public String getType() {
		return adaptee.getName();
	}

	@Override
	public int getMaxValue() {
		return 10;
	}
	
	@Override
	public Color calculateColor(double value) {
		if (value <=  3.0) {
			return Color.green;
		} else if (value <=  4.0) {
			return Color.yellow;
		} else {
			return Color.red;
		}
	}
}
