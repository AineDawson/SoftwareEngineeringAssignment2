import sensor.TemperatureSensor;
//Adaptor for the TemperatureSensor
public class TemperatureAdaptor implements Sensors{
	TemperatureSensor tS=new TemperatureSensor();
	public TemperatureAdaptor(TemperatureSensor tS) {
		this.tS=tS;
	}
	@Override
	public double getReading() {
		return tS.senseTemperature();
	}

	@Override
	public String getReport() {
		return tS.getTempReport();
	}

	@Override
	public String getName() {
		return tS.getSensorType();
	}

}
