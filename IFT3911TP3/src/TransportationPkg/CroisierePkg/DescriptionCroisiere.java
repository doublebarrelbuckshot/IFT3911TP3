package TransportationPkg.CroisierePkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;

public class DescriptionCroisiere extends TripInstance {

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}
	
	public void assignLayoutToClass(VehicleLayout vl) {
		ComfortClass cc = null;
		if(vl instanceof LayoutFamille )
		{
			cc = new Famille();
			cc.layout = vl;
			this._comfortClasses.add(cc);
		}
		else if(vl instanceof LayoutDeluxe )
		{
			cc = new FamilyDeluxe();
		}
		else if(vl instanceof LayoutInterior )
		{
			cc = new Interieur();
		}
		else if(vl instanceof LayoutOcean )
		{
			cc = new Ocean();
		}
		else if(vl instanceof LayoutSuite)
		{
			cc = new Suite();
		}

		cc.layout = vl;
		this._comfortClasses.add(cc);
		
		cc.createPhysicalSeats(vl);
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}