package AdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TripGeneral;
import TransportationPkg.TripInstance;

public class AddTripInstance  implements ICommand {
	private TripGeneral _receiver;
	private TripInstance _ti;

	public AddTripInstance(TripInstance ti) {
		this._ti = ti;
		this._receiver = _ti.get_tripDescription();
		
	}

	@Override
	public void execute() {
		_receiver.addTripInstance(_ti);
	}

	@Override
	public void unexecute() {
		if(canDeleteTripGeneral())
		{
			_receiver.removeTripInstance(_ti);
		}	
		
	}
	
	public boolean canDeleteTripGeneral()
	{
		TransportationManager tm = TransportationManager.getInstance();

		return true;
		
	}
	public String getMessage(boolean isExecute) {
		if(isExecute)
			return "TripInstance: " + _ti.get_tripDescription().get_hubDeparture().get_name() + " to " + _ti.get_tripDescription().get_hubArrival().get_name() + " added!";
		else{
			return "TripInstance: " +  _ti.get_tripDescription().get_hubDeparture().get_name() + " to " + _ti.get_tripDescription().get_hubArrival().get_name() + " removed from system!";
		}
		
	}
}