package ClientPkg;

import TransportationPkg.AviationPkg.Vol;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.TrainPkg.Trajet;
import AdminPkg.ITripVisitor;

public class ClientTripVisitor implements ITripVisitor{

	@Override
	public void visit(Vol vol) {
		System.out.println(vol._hubDeparture + "-"+ vol._hubArrival);
		
	}

	@Override
	public void visit(Trajet trajet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Croisiere croisiere) {
		// TODO Auto-generated method stub
		
	}

}
