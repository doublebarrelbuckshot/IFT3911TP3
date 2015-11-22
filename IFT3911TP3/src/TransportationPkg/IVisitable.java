package TransportationPkg;

import AdminPkg.ITripVisitor;


public interface IVisitable {

	public void accept(ITripVisitor visitor);
}
