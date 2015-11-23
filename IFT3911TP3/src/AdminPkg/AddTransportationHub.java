package AdminPkg;

import TransportationPkg.TransportationHub;

public class AddTransportationHub implements ICommand {
	private TransportationManager _receiver;
	private TransportationHub _th;

	private boolean undoSuccess =  false;
	public AddTransportationHub(TransportationHub aTh) {
		this._th = aTh;
		_receiver = TransportationManager.getInstance();
	}

	public void execute() {
		_receiver.addTransportationHub(_th);
	}

	public void unexecute() {
		if(canDeleteTransportationHub())
		{
			_receiver.removeTransportationHub(_th);
			undoSuccess = true;
		}		
	}

	public boolean canDeleteTransportationHub()
	{
		TransportationManager tm = TransportationManager.getInstance();

		for(int i=0; i<tm.get_listTripGenerals().size(); i++)
		{
			if(tm.get_listTripGenerals().get(i)._hubArrival.get_id() == _th.get_id() ||
				tm.get_listTripGenerals().get(i)._hubDeparture.get_id() == _th.get_id()	)
			{
				undoSuccess = false;
				return false;
			}
		}
		undoSuccess = true;
		return true;
		
	}
	
	public String getMessage(boolean isExecute) {
		if(isExecute)
			return "Airport: " + _th.get_name() + " added!";
		else{
			if(undoSuccess)
				return "Airport: " + _th.get_name() + " removed from system!";
			else
			{
				return "Could not remove Airport " + _th.get_name()+ ". Ensure that it is not being referenced by another object.";
			}
		}
		
	}
}