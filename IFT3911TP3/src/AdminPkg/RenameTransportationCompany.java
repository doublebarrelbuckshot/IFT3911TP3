package AdminPkg;

import TransportationPkg.TransportationCompany;

public class RenameTransportationCompany implements ICommand {
	private TransportationCompany _receiver;
	private String _newName;
	private String _oldName;

	public RenameTransportationCompany(TransportationCompany tptco, String aS) {
		this._receiver = tptco;
		this._oldName = tptco.get_name();
		this._newName = aS;
	}

	public void execute() {
		this._receiver.set_name(_newName);
	}
}