package AdminPkg;

import TransportationPkg.TransportationCompany;

public class RemoveTransportatonCompany implements ICommand {
	private TransportationManager _receiver;
	private TransportationCompany _oldTC;

	public void RemoveTransportationCompany(TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public void execute() {
		throw new UnsupportedOperationException();
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

	public String getMessage() {
		throw new UnsupportedOperationException();
		
	}
}