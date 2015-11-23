package AdminPkg;

import TransportationPkg.TransportationHub;

public class AddTransportationHub implements ICommand {
	private TransportationManager _receiver;
	private TransportationHub _th;

	public AddTransportationHub(TransportationHub aTh) {
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