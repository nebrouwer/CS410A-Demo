import java.awt.Color;

// Adapters for different sensors 
public interface Sensor {
	
	// Returns the reading/value from the sensor
	public double getValue();

	// Returns the status of the sensor
	// (Ok, Critical, or Danger)
	public String getStatus();

	// Returns the sensor type/name
	public String getType();

	// Gets a maximum value for the sensor
	public int getMaxValue();

	// Returns the status color of the input value for the sensor
	// Green for status OK
	// Yellow for status Critical
	// Red for status Danger
	public Color calculateColor(double value);

}
