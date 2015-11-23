package ClientPkg;

import TransportationPkg.AvailableSeat;
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
import AdminPkg.ITripVisitor;

public class ClientTripVisitor implements ITripVisitor{

	private int count=0;
	private String result = "";
	
	public String getResult()
	{
		return result;
	}
	
	public int get_count(){return count;}
	
	@Override
	public void visit(DescriptionVol vol) {
		result +="\n";
		result += vol.get_tripDescription().get_hubDeparture().get_id()+"-"+vol.get_tripDescription().get_hubArrival().get_id();
		result +=":["+vol.get_tripDescription().getTptCompany().get_id()+"]";
		result +=vol.get_tripInstanceID();
		result +="("+vol.get_dateDepartStr()+":"+vol.get_tripDescription().get_heureDepartStr();
		result +="-"+vol.get_dateArriveStr()+":"+vol.get_tripDescription().get_heureArriveStr()+")";
		
	}

	@Override
	public void visit(DescriptionTrajet trajet) {
		result +="\n";
		result += trajet.get_tripDescription().get_hubDeparture().get_id()+"-"+trajet.get_tripDescription().get_hubArrival().get_id();
		result += ":["+trajet.get_tripDescription().getTptCompany().get_id()+"]";
		result += trajet.get_tripInstanceID();
		result += "("+trajet.get_dateDepartStr()+":"+trajet.get_tripDescription().get_heureDepartStr();
		result += "-"+trajet.get_dateArriveStr()+":"+trajet.get_tripDescription().get_heureArriveStr()+")";
		
	}

	@Override
	public void visit(DescriptionCroisiere croisiere) {
		result += "\n";
		result += croisiere.get_tripDescription().get_hubDeparture().get_id()+"-"+croisiere.get_tripDescription().get_hubArrival().get_id();
		result += ":["+croisiere.get_tripDescription().getTptCompany().get_id()+"]";
		result += croisiere.get_tripInstanceID();
		result += "("+croisiere.get_dateDepartStr()+":"+croisiere.get_tripDescription().get_heureDepartStr();
		result += "-"+croisiere.get_dateArriveStr()+":"+croisiere.get_tripDescription().get_heureArriveStr()+")";
	
	}
	@Override
	public void visit(InstanceSeat seat) {
		if(seat.get_state() instanceof AvailableSeat)
			count++;
	}
	
	@Override
	public void visit(Affaire affaire) {
		result += "|"+affaire.getPricePercentage()*affaire.getFullPrice();
		result += "|"+affaire.getComfortClassType().name();
		for(ITripVisitable seat : affaire.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}


	@Override
	public void visit(Economique econo) {
		result += "|"+econo.getPricePercentage()*econo.getFullPrice();
		result += "|"+econo.getComfortClassType().name();
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
		
	}

	@Override
	public void visit(EconomiquePremium econoP) {
		result += "|"+econoP.getPricePercentage()*econoP.getFullPrice();
		result += "|"+econoP.getComfortClassType().name();
		for(ITripVisitable seat : econoP.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(Premiere premiere) {
		result += "|"+premiere.getPricePercentage()*premiere.getFullPrice();
		result += "|"+premiere.getComfortClassType().name();
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
		
	}

	@Override
	public void visit(Famille famille) {
		result += "|"+famille.getPricePercentage()*famille.getFullPrice();
		result += "|"+famille.getComfortClassType().name();
		for(ITripVisitable seat : famille.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(FamilyDeluxe famDeluxe) {
		result += "|"+famDeluxe.getPricePercentage()*famDeluxe.getFullPrice();
		result += "|"+famDeluxe.getComfortClassType().name();
		for(ITripVisitable seat : famDeluxe.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(Interieur interieur) {
		result += "|"+interieur.getPricePercentage()*interieur.getFullPrice();
		result += "|"+interieur.getComfortClassType().name();
		for(ITripVisitable seat : interieur.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
		
	}

	@Override
	public void visit(Ocean ocean) {
		result += "|"+ocean.getPricePercentage()*ocean.getFullPrice();
		result += "|"+ocean.getComfortClassType().name();
		for(ITripVisitable seat : ocean.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(Suite suite) {
		result += "|"+suite.getPricePercentage()*suite.getFullPrice();
		result += "|"+suite.getComfortClassType().name();
		for(ITripVisitable seat : suite.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(TrainEconomique econo) {
		result += "|"+econo.getPricePercentage()*econo.getFullPrice();
		result += "|"+econo.getComfortClassType().name();
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

	@Override
	public void visit(TrainPremiere premiere) {
		result += "|"+premiere.getPricePercentage()*premiere.getFullPrice();
		result += "|"+premiere.getComfortClassType().name();
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		result += this.get_count();
	}

}
