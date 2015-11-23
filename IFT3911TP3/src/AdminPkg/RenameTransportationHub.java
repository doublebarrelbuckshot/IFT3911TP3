package AdminPkg;

import TransportationPkg.TransportationHub;

public class RenameTransportationHub implements ICommand {
	private TransportationHub _receiver;
	private String _newName;
	private String _oldName;

	public RenameTransportationHub(String aS) {
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