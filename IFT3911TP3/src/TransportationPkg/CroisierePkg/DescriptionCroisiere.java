package TransportationPkg.CroisierePkg;

import AdminPkg.ITripVisitor;
import CommonComponentsPkg.ComfortClassEnum;
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
			ComfortClassEnum f = ComfortClassEnum.F;
			cc.setComfortClassType(f);
		}
		else if(vl instanceof LayoutDeluxe )
		{
			cc = new FamilyDeluxe();
			ComfortClassEnum d = ComfortClassEnum.D;
			cc.setComfortClassType(d);
		}
		else if(vl instanceof LayoutInterior )
		{
			cc = new Interieur();
			ComfortClassEnum i = ComfortClassEnum.I;
			cc.setComfortClassType(i);
		}
		else if(vl instanceof LayoutOcean )
		{
			cc = new Ocean();
			ComfortClassEnum o = ComfortClassEnum.O;
			cc.setComfortClassType(o);
		}
		else if(vl instanceof LayoutSuite)
		{
			cc = new Suite();
			ComfortClassEnum s = ComfortClassEnum.S;
			cc.setComfortClassType(s);
		}

		cc.layout = vl;
		this._comfortClasses.add(cc);
		
		cc.createPhysicalSeats(vl);
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}