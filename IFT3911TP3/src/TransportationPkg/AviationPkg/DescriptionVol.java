package TransportationPkg.AviationPkg;

import AdminPkg.ITripVisitor;
import CommonComponentsPkg.ComfortClassEnum;
import TransportationPkg.ComfortClass;
import TransportationPkg.GenericSeat;
import TransportationPkg.ITripVisitable;
import TransportationPkg.InstanceSeat;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;
import TransportationPkg.CroisierePkg.Famille;
import TransportationPkg.CroisierePkg.FamilyDeluxe;
import TransportationPkg.CroisierePkg.Interieur;
import TransportationPkg.CroisierePkg.LayoutDeluxe;
import TransportationPkg.CroisierePkg.LayoutFamille;
import TransportationPkg.CroisierePkg.LayoutInterior;
import TransportationPkg.CroisierePkg.LayoutOcean;
import TransportationPkg.CroisierePkg.Ocean;

public class DescriptionVol extends TripInstance {

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}

	public void assignLayoutToClass(VehicleLayout vl) {
		 
		ComfortClass cc = null;
		if(vl instanceof AirLarge )
		{
			cc = new Premiere();
			ComfortClassEnum ccEnum = ComfortClassEnum.F;
			cc.setComfortClassType(ccEnum);
		}
		else if(vl instanceof AirConfort )
		{
			cc = new Affaire();
			ComfortClassEnum ccEnum = ComfortClassEnum.A;
			cc.setComfortClassType(ccEnum);
		}
		else if(vl instanceof AirMoyen )
		{
			cc = new EconomiquePremium();
			ComfortClassEnum ccEnum = ComfortClassEnum.P;
			cc.setComfortClassType(ccEnum);
		}
		else if(vl instanceof AirEtroit )
		{
			cc = new Economique();
			ComfortClassEnum ccEnum = ComfortClassEnum.E;
			cc.setComfortClassType(ccEnum);
		}
		
		cc.layout = vl;
		this._comfortClasses.add(cc);
		
		cc.createPhysicalSeats(vl);
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}