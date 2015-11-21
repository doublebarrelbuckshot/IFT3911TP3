package TransportationPkg;

import AdminPkg.TransportationManager;

public abstract class ConfigValues implements ISearchable {
	protected int _orderChangeDeadline;
	public TransportationManager _unnamed_TransportationManager_;

	public int getOrderChangeDeadline() {
		return this._orderChangeDeadline;
	}
}