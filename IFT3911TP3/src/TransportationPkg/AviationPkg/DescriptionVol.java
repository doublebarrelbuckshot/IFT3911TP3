package TransportationPkg.AviationPkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.ITripVisitable;
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
		if(vl instanceof AirLarge )
		{
			Premiere f = new Premiere();
			f.layout = vl;
			this._comfortClasses.add(f);
		}
		else if(vl instanceof AirConfort )
		{
			Affaire d = new Affaire();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
		else if(vl instanceof AirMoyen )
		{
			EconomiquePremium d = new EconomiquePremium();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
		else if(vl instanceof AirEtroit )
		{
			Economique d = new Economique();
			d.layout = vl;
			this._comfortClasses.add(d);
		}
	}
		

	public void accept(ITripVisitor visitor){
		visitor.visit(this);
		for(ITripVisitable section : this.get_comfortClasses()){
			section.accept(visitor);
		}
	}
}