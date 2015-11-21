package TransportationPkg;

import CommonComponentsPkg.Adresse;
import AdminPkg.TransportationManager;
import java.util.Vector;
import TransportationPkg.TripGeneral;

public abstract class TransportationHub implements ISearchable {
	protected int _id;
	protected Adresse _adresse;
	protected String _name;
	protected boolean _isActive;
	public TransportationManager _unnamed_TransportationManager_;
	public Vector<TripGeneral> _unnamed_TripGeneral_ = new Vector<TripGeneral>();
	public Vector<TripGeneral> _unnamed_TripGeneral_2 = new Vector<TripGeneral>();

	public String rename(String aN) {
		throw new UnsupportedOperationException();
	}
}