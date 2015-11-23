package AdminPkg;

import java.util.Vector;

import TransportationPkg.GenericSeat;
import TransportationPkg.ITripVisitable;
import TransportationPkg.InstanceSeat;
import TransportationPkg.ReservedState;
import TransportationPkg.AviationPkg.Affaire;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.TrainPkg.DescriptionTrajet;



public class AdminTripVisitor implements ITripVisitor{

	private int count=0;
	
	public int get_count(){return count;}
	
	@Override
	public void visit(DescriptionVol vol) {
		System.out.println(vol.get_tripDescription().get_hubDeparture().get_id()+"-"+vol.get_tripDescription().get_hubArrival().get_id());
		System.out.print(":["+vol.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(vol.get_tripInstanceID());
		System.out.print("("+vol.get_dateDepart()+":"+vol.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+vol.get_dateArrive()+":"+vol.get_tripDescription().get_heureArriveStr()+")");
		for(ITripVisitable section : vol.get_comfortClasses()){
			section.accept(this);
		}
	}

	@Override
	public void visit(DescriptionTrajet trajet) {
		System.out.println(trajet.get_tripDescription().get_hubDeparture()+"-"+trajet.get_tripDescription().get_hubArrival());
		System.out.print(":["+trajet.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(trajet.get_tripInstanceID());
		System.out.print("("+trajet.get_dateDepart()+":"+trajet.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+trajet.get_dateArrive()+":"+trajet.get_tripDescription().get_heureArriveStr()+")");
		
	}

	@Override
	public void visit(DescriptionCroisiere croisiere) {
		System.out.println(croisiere.get_tripDescription().get_hubDeparture()+"-"+croisiere.get_tripDescription().get_hubArrival());
		System.out.print(":["+croisiere.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(croisiere.get_tripInstanceID());
		System.out.print("("+croisiere.get_dateDepart()+":"+croisiere.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+croisiere.get_dateArrive()+":"+croisiere.get_tripDescription().get_heureArriveStr()+")");
		
	}

	public void visit(Affaire affaire){
		System.out.print("|"+affaire.getComfortClassType().name());
		System.out.print(affaire.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : affaire.get_seating()){
			seat.accept(this);
			System.out.print("("+this.get_count()+"/"+affaire.get_seating().size()+")");
		}
		System.out.print(affaire.getFullPrice()*affaire.getPricePercentage());
	}

	@Override
	public void visit(InstanceSeat seat) {
		if(seat.get_state() instanceof ReservedState)
			count++;
	}
}
