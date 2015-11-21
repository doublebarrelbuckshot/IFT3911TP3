package TransportationPkg;

import java.util.Vector;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;

public abstract class TransportationVehicle {
	protected String _modele;
	protected int _capaciteMax;
	protected String _vehicleIdentifier;
	protected String _manufacturer;
	protected int _yearFab;
	public Vector<TripInstance> _unnamed_TripInstance_ = new Vector<TripInstance>();
	public Vector<VehicleLayout> _layoutSections = new Vector<VehicleLayout>();
	public TransportationCompany _unnamed_TransportationCompany_;

	public void addVehicleLayout(VehicleLayout aVl) {
		throw new UnsupportedOperationException();
	}

	public void removeVehicleLayout(VehicleLayout aD) {
		throw new UnsupportedOperationException();
	}

	public void changeCapacity(int aC) {
		throw new UnsupportedOperationException();
	}
}