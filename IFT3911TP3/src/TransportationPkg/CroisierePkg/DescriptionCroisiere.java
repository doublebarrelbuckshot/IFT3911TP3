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
		if(vl instanceof LayoutFamille )
		{
			Famille f = new Famille();
			f.layout = vl;
			this._comfortClasses.add(f);
		}
		else if(vl instanceof LayoutDeluxe )
		{
			FamilyDeluxe d = new FamilyDeluxe();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
		else if(vl instanceof LayoutInterior )
		{
			Interieur d = new Interieur();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
		else if(vl instanceof LayoutOcean )
		{
			Ocean d = new Ocean();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}