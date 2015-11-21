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
	public Vector<TripInstance> tripInstances = new Vector<TripInstance>();
	public Vector<VehicleLayout> _layoutSections = new Vector<VehicleLayout>();
	public TransportationCompany tptCompany;

	
	public String get_modele() {
		return _modele;
	}

	public void set_modele(String _modele) {
		this._modele = _modele;
	}

	public int get_capaciteMax() {
		return _capaciteMax;
	}

	public void set_capaciteMax(int _capaciteMax) {
		this._capaciteMax = _capaciteMax;
	}

	public String get_vehicleIdentifier() {
		return _vehicleIdentifier;
	}

	public void set_vehicleIdentifier(String _vehicleIdentifier) {
		this._vehicleIdentifier = _vehicleIdentifier;
	}

	public String get_manufacturer() {
		return _manufacturer;
	}

	public void set_manufacturer(String _manufacturer) {
		this._manufacturer = _manufacturer;
	}

	public int get_yearFab() {
		return _yearFab;
	}

	public void set_yearFab(int _yearFab) {
		this._yearFab = _yearFab;
	}

	public Vector<TripInstance> getTripInstances() {
		return tripInstances;
	}

	public void setTripInstances(Vector<TripInstance> tripInstances) {
		this.tripInstances = tripInstances;
	}

	public Vector<VehicleLayout> get_layoutSections() {
		return _layoutSections;
	}

	public void set_layoutSections(Vector<VehicleLayout> _layoutSections) {
		this._layoutSections = _layoutSections;
	}

	public TransportationCompany getTptCompany() {
		return tptCompany;
	}

	public void setTptCompany(TransportationCompany tptCompany) {
		this.tptCompany = tptCompany;
	}

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