package ReservationPkg;

import java.util.Date;

import TransportationPkg.InstanceSeat;
import TransportationPkg.IPassenger;

public class Passager extends Person implements IPassenger {
	private Date dateNaissance;
	private String numPassport;
	private Booking booking;
	private InstanceSeat assignedSeat;

	public IPassenger getPassenger() {
		throw new UnsupportedOperationException();
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumPassport() {
		return numPassport;
	}

	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}

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
	
	
}