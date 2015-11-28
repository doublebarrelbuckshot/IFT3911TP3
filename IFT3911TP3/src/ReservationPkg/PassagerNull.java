package ReservationPkg;

import TransportationPkg.IPassenger;

public class PassagerNull extends Passager {
private static PassagerNull instance;

public static PassagerNull getInstance()
{
	if(instance == null)
		instance = new PassagerNull();
	return instance;
}
private PassagerNull()
{
	
}
	public int count(){return 0;}
	
	
}
