package ReservationPkg;

import java.util.Date;

import TransportationPkg.InstanceSeat;
import TransportationPkg.IPassenger;

public abstract class Passager extends Person implements IPassenger {
	
	private Booking booking;
	private InstanceSeat assignedSeat;



	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public InstanceSeat getAssignedSeat() {
		return assignedSeat;
	}

	public void setAssignedSeat(InstanceSeat assignedSeat) {
		this.assignedSeat = assignedSeat;
	}
	
	public abstract int count();
	
}