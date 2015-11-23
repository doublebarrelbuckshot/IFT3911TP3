package AdminPkg;

import java.util.Vector;

import TransportationPkg.GenericSeat;
import TransportationPkg.ITripVisitable;
import TransportationPkg.InstanceSeat;
import TransportationPkg.ReservedState;
import TransportationPkg.AviationPkg.Affaire;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.AviationPkg.Economique;
import TransportationPkg.AviationPkg.EconomiquePremium;
import TransportationPkg.AviationPkg.Premiere;
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.CroisierePkg.Famille;
import TransportationPkg.CroisierePkg.FamilyDeluxe;
import TransportationPkg.CroisierePkg.Interieur;
import TransportationPkg.CroisierePkg.Ocean;
import TransportationPkg.CroisierePkg.Suite;
import TransportationPkg.TrainPkg.DescriptionTrajet;
import TransportationPkg.TrainPkg.TrainEconomique;
import TransportationPkg.TrainPkg.TrainPremiere;



public class AdminTripVisitor implements ITripVisitor{

	private int count=0;
	
	public int get_count(){return count;}
	
	@Override
	public void visit(DescriptionVol vol) {
		System.out.println();
		System.out.print(vol.get_tripDescription().get_hubDeparture().get_id()+"-"+vol.get_tripDescription().get_hubArrival().get_id());
		System.out.print(":["+vol.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(vol.get_tripInstanceID());
		System.out.print("("+vol.get_dateDepartStr()+":"+vol.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+vol.get_dateArriveStr()+":"+vol.get_tripDescription().get_heureArriveStr()+")");
		for(ITripVisitable section : vol.get_comfortClasses()){
			section.accept(this);
		}
	}

	@Override
	public void visit(DescriptionTrajet trajet) {
		System.out.println();
		System.out.print(trajet.get_tripDescription().get_hubDeparture().get_id()+"-"+trajet.get_tripDescription().get_hubArrival().get_id());
		System.out.print(":["+trajet.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(trajet.get_tripInstanceID());
		System.out.print("("+trajet.get_dateDepartStr()+":"+trajet.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+trajet.get_dateArriveStr()+":"+trajet.get_tripDescription().get_heureArriveStr()+")");
		for(ITripVisitable section : trajet.get_comfortClasses()){
			section.accept(this);
		}
	}

	@Override
	public void visit(DescriptionCroisiere croisiere) {
		System.out.println();
		System.out.print(croisiere.get_tripDescription().get_hubDeparture().get_id()+"-"+croisiere.get_tripDescription().get_hubArrival().get_id());
		System.out.print(":["+croisiere.get_tripDescription().getTptCompany().get_id()+"]");
		System.out.print(croisiere.get_tripInstanceID());
		System.out.print("("+croisiere.get_dateDepartStr()+":"+croisiere.get_tripDescription().get_heureDepartStr());
		System.out.print("-"+croisiere.get_dateArriveStr()+":"+croisiere.get_tripDescription().get_heureArriveStr()+")");
		for(ITripVisitable section : croisiere.get_comfortClasses()){
			section.accept(this);
		}
	}
	/*Vol*/
	public void visit(Affaire affaire){
		System.out.print("|"+affaire.getComfortClassType().name());
		System.out.print(affaire.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : affaire.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+affaire.get_seating().size()+")");
		System.out.print(affaire.getPricePercentage()*affaire.getFullPrice());
	}
	
	public void visit(Economique econo){
		System.out.print("|"+econo.getComfortClassType().name());
		System.out.print(econo.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+econo.get_seating().size()+")");
		System.out.print(econo.getPricePercentage()*econo.getFullPrice());
	}
	public void visit(EconomiquePremium econoP){
		System.out.print("|"+econoP.getComfortClassType().name());
		System.out.print(econoP.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : econoP.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+econoP.get_seating().size()+")");
		System.out.print(econoP.getPricePercentage()*econoP.getFullPrice());
	}
	public void visit(Premiere premiere){
		System.out.print("|"+premiere.getComfortClassType().name());
		System.out.print(premiere.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+premiere.get_seating().size()+")");
		System.out.print(premiere.getPricePercentage()*premiere.getFullPrice());
	}
	
	/*CROISIERE*/
	public void visit(Famille famille){
		System.out.print("|"+famille.getComfortClassType().name());
		for(ITripVisitable seat : famille.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+famille.get_seating().size()+")");
		System.out.print(famille.getPricePercentage()*famille.getFullPrice());
	}
	public void visit(FamilyDeluxe familleLuxe){
		System.out.print("|"+familleLuxe.getComfortClassType().name());
		for(ITripVisitable seat : familleLuxe.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+familleLuxe.get_seating().size()+")");
		System.out.print(familleLuxe.getPricePercentage()*familleLuxe.getFullPrice());
	}
	public void visit(Interieur interieur){
		System.out.print("|"+interieur.getComfortClassType().name());
		for(ITripVisitable seat : interieur.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+interieur.get_seating().size()+")");
		System.out.print(interieur.getPricePercentage()*interieur.getFullPrice());
	}
	public void visit(Suite suite){
		System.out.print("|"+suite.getComfortClassType().name());
		for(ITripVisitable seat : suite.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+suite.get_seating().size()+")");
		System.out.print(suite.getPricePercentage()*suite.getFullPrice());
	}
	public void visit(Ocean ocean){
		System.out.print("|"+ocean.getComfortClassType().name());
		for(ITripVisitable seat : ocean.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+ocean.get_seating().size()+")");
		System.out.print(ocean.getPricePercentage()*ocean.getFullPrice());
	}
	
	/*Train*/
	public void visit(TrainEconomique econo) {
		System.out.print("|"+econo.getComfortClassType().name());
		System.out.print(econo.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+econo.get_seating().size()+")");
		System.out.print(econo.getPricePercentage()*econo.getFullPrice());
		
	}

	public void visit(TrainPremiere premiere) {
		System.out.print("|"+premiere.getComfortClassType().name());
		System.out.print(premiere.get_layout().getVehiculeLayoutType().name());
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		System.out.print("("+this.get_count()+"/"+premiere.get_seating().size()+")");
		System.out.print(premiere.getPricePercentage()*premiere.getFullPrice());
		
	}
	
	@Override
	public void visit(InstanceSeat seat) {
		if(seat.get_state() instanceof ReservedState)
			count++;
	}

	
}
