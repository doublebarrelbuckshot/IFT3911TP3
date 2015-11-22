package TransportationPkg.AviationPkg;

import AdminPkg.ITripVisitor;
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
		}
		else if(vl instanceof AirConfort )
		{
			cc = new Affaire();
		}
		else if(vl instanceof AirMoyen )
		{
			cc = new EconomiquePremium();
		}
		else if(vl instanceof AirEtroit )
		{
			cc = new Economique();
		}
		
		cc.layout = vl;
		this._comfortClasses.add(cc);
		
		cc.createPhysicalSeats(vl);
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
		for(ITripVisitable section : this.get_comfortClasses()){
			section.accept(visitor);
		}
	}
}