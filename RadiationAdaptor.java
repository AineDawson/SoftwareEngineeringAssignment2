import sensor.RadiationSensor;
//Adaptor for the RadiationSensor
public class RadiationAdaptor implements Sensors{
	RadiationSensor rS;
	public RadiationAdaptor(RadiationSensor rS) {
		this.rS=rS;
	}
	@Override
	public double getReading() {
		return rS.getRadiationValue();
	}

	@Override
	public String getReport() {
		return rS.getStatusInfo();
	}

	@Override
	public String getName() {
		return rS.getName();
	}
}
