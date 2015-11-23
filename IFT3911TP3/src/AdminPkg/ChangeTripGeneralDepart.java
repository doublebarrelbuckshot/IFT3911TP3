package AdminPkg;

import java.util.Date;

import TransportationPkg.TripGeneral;

public class ChangeTripGeneralDepart implements ICommand {
	private TripGeneral _receiver;
	private Date _oldD;
	private Date _newD;

	public ChangeTripGeneralDepart(Date aD) {
		throw new UnsupportedOperationException();
	}

	public void execute() {
		throw new UnsupportedOperationException();
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

	public String getMessage(boolean isExecute) {
		throw new UnsupportedOperationException();
		
	}
}