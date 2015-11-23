package AdminPkg;

import TransportationPkg.TransportationVehicle;

public class AddTransportationVehicle implements ICommand {
	private TransportationManager _receiver;
	private TransportationVehicle _t;

	public AddTransportationVehicle(TransportationVehicle aTv) {
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