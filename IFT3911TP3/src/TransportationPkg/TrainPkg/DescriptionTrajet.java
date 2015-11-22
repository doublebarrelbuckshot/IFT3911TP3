package TransportationPkg.TrainPkg;

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
		if(vl instanceof TrainEtroit )
		{
			TrainPremiere f = new TrainPremiere();
			f.layout = vl;
			this._comfortClasses.add(f);
		}		
	}
}