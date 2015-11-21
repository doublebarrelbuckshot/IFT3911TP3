package ReservationPkg;

import java.util.Date;

import TransportationPkg.InstanceSeat;
import TransportationPkg.IPassenger;

public class Passager extends Person implements IPassenger {
	private Date _dateNaissance;
	private String _numPassport;
	public Booking _unnamed_Booking_;
	public InstanceSeat _assignedSeat;

	public IPassenger getPassenger() {
		throw new UnsupportedOperationException();
	}
}