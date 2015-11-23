package ClientPkg;

import TransportationPkg.InstanceSeat;
import TransportationPkg.AviationPkg.Affaire;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.TrainPkg.DescriptionTrajet;
import AdminPkg.ITripVisitor;

public class ClientTripVisitor implements ITripVisitor{

	@Override
	public void visit(DescriptionVol vol) {
		
	}

	@Override
	public void visit(DescriptionTrajet trajet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DescriptionCroisiere croisiere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Affaire affaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(InstanceSeat seat) {
		// TODO Auto-generated method stub
		
	}

}
