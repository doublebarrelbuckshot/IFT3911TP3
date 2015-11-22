package TransportationPkg;

import AdminPkg.ITripVisitor;


public interface ITripVisitable {

	public void accept(ITripVisitor visitor);
}
