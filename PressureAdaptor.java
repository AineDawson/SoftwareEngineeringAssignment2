import sensor.PressureSensor;
//Adaptor for the PressureSensor
public class PressureAdaptor implements Sensors{
	PressureSensor pS;
	
	public PressureAdaptor(PressureSensor pS) {
		this.pS=pS;
	}
	@Override
	public double getReading() {
		return pS.readValue();
	}

	@Override
	public String getReport() {
		return pS.getReport();
	}

	@Override
	public String getName() {
		return pS.getSensorName();
	}

}
