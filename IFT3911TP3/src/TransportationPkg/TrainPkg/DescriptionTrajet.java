package TransportationPkg.TrainPkg;

import AdminPkg.ITripVisitor;
import TransportationPkg.ComfortClass;
import TransportationPkg.TripInstance;
import TransportationPkg.VehicleLayout;
import TransportationPkg.AviationPkg.Affaire;
import TransportationPkg.AviationPkg.AirConfort;
import TransportationPkg.AviationPkg.AirEtroit;
import TransportationPkg.AviationPkg.AirLarge;
import TransportationPkg.AviationPkg.AirMoyen;
import TransportationPkg.AviationPkg.Economique;
import TransportationPkg.AviationPkg.EconomiquePremium;
import TransportationPkg.AviationPkg.Premiere;

public class DescriptionTrajet extends TripInstance {

	public void addComfortClass() {
		throw new UnsupportedOperationException();
	}

	public void removeComfortClass(ComfortClass aCc) {
		throw new UnsupportedOperationException();
	}
	

	public void assignLayoutToClass( VehicleLayout vl) {
		ComfortClass cc = null;
		if(vl instanceof TrainEtroit )
		{
			cc = new TrainPremiere();

		}
		cc.layout = vl;
		this._comfortClasses.add(cc);
		
		cc.createPhysicalSeats(vl);
	}
	public void accept(ITripVisitor visitor){
		visitor.visit(this);
	}
}