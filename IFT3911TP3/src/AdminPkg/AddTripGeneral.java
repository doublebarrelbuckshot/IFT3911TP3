package AdminPkg;

import TransportationPkg.TransportationHub;
import TransportationPkg.TripGeneral;

public class AddTripGeneral  implements ICommand {
	private TransportationManager _receiver;
	private TripGeneral _tg;

	public AddTripGeneral(TripGeneral tg) {
		this._tg = tg;
		this._receiver = TransportationManager.getInstance();
		
	}

	@Override
	public void execute() {
		_receiver.addTripGeneral(_tg);
		for(int i=0; i<_receiver.get_listTripGenerals().size(); i++)
		{
			TripGeneral tg = _receiver.get_listTripGenerals().get(i);
			System.out.println(tg.get_hubDeparture().get_name() + "  " + tg.get_hubArrival().get_name() + tg.get_heureDepart().getHours());
		}
		
	}

	@Override
	public void unexecute() {
		if(canDeleteTripGeneral())
		{
			_receiver.removeTripGeneral(_tg);
		}	
		
	}
	
	public boolean canDeleteTripGeneral()
	{
		TransportationManager tm = TransportationManager.getInstance();

		return true;
		
	}
	public String getMessage(boolean isExecute) {
		if(isExecute)
			return "TripGeneral from" + _tg.get_hubDeparture().get_name() + " to " + _tg.get_hubArrival().get_name() + "     TripGeneralID:" +  _tg.get_tripID() + " + added!";
		else{
			return "TripGeneral: " +  _tg.get_hubDeparture().get_name() + " to " + _tg.get_hubArrival().get_name() + " removed from system!";
		}
		
	}
}