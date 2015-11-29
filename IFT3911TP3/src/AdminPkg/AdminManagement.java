package AdminPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Vector;

import TransportationPkg.TripGeneral;
import AdminPkg.AirAdminPkg.AirFactory;
import AdminPkg.CruiseAdminPkg.CruiseFactory;
import AdminPkg.TrainAdminPkg.TrainFactory;
import ClientPkg.ClientUI;
import CommonComponentsPkg.SearchCriteria;
import TransportationPkg.GenericSeat;
import TransportationPkg.ITripVisitable;
import TransportationPkg.TransportationVehicle;
import TransportationPkg.TransportationHub;
import TransportationPkg.TransportationCompany;
import TransportationPkg.TripInstance;

public class AdminManagement extends Subject {
	protected Administrator _listAdmins;
	public UIAdmin _interacts;
	public TransportationFactory _unnamed_TransportationFactory_;
	Deque<ICommand> _commands = new ArrayDeque<ICommand>();
	private static AdminManagement instance;
	

	public static AdminManagement getInstance()
	{
		if(instance == null)
			instance = new AdminManagement();
		return instance;
	}
	private AdminManagement() {
		this.attach(ClientUI.getInstance());
		this.attach(UIAdmin.getInstance());
		
	}


	public void addICommand(ICommand ic)
	{
		ic.execute();
		this._commands.push(ic);
		this.notifyObservers(ic.getMessage(true));
	}

	public void undo()
	{
		if(!this._commands.isEmpty())
		{
			ICommand ic = this._commands.pop();
			ic.unexecute();
			this.notifyObservers(ic.getMessage(false));

		}
		else
			UIAdmin.getInstance().updateOutput("Cannot Undo, no Undo-able commands available");
		
	}
	public String findTripGeneral(SearchCriteria aSc) {
		
		String result="";
		TransportationManager tm = TransportationManager.getInstance();
		Vector<TripGeneral> listTrip = tm.get_listTripGenerals();
		
		for(TripGeneral trip : listTrip){
			for(ITripVisitable instance : trip.get_tripInstances()){
				AdminTripVisitor visitor = new AdminTripVisitor();
				instance.accept(visitor);
				result += visitor.getResult();
			}
		}
		
		return result;
	}

	public GenericSeat findGenericSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public GenericSeat findSeat(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void addTransportCompany(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationHub(String aName) {
		throw new UnsupportedOperationException();
	}

	public void addTransportationVehicle(String aId) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationHub(int aId) {
		throw new UnsupportedOperationException();
	}

	public TransportationVehicle findTransportationVehicle(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportationVehicle(String aVehID) {
		throw new UnsupportedOperationException();
	}

	public void removeTransportCompany(int aId) {
		throw new UnsupportedOperationException();
	}

	public void addTripGeneral(String aTripID, TransportationHub aDepart, TransportationHub aArrive, TransportationCompany aTc) {
		throw new UnsupportedOperationException();
	}

	public TransportationHub findTransportationHub(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public TransportationCompany findTransportationCompany(SearchCriteria aSc) {
		throw new UnsupportedOperationException();
	}

	public void removeTripGeneral(TripGeneral aTg) {
		throw new UnsupportedOperationException();
	}
}
