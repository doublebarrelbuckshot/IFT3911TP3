package AdminPkg;

import java.util.Vector;

import TransportationPkg.ComfortClass;
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
		result +=vol.get_tripDescription().get_tripID();
		result +="("+vol.get_dateDepartStr()+":"+vol.get_tripDescription().get_heureDepartStr();
		result +="-"+vol.get_dateArriveStr()+":"+vol.get_tripDescription().get_heureArriveStr()+")";
		for(ITripVisitable section : vol.get_comfortClasses()){
			count=0;
			section.accept(this);
		}
	}

	@Override
	public void visit(DescriptionTrajet trajet) {
		result +="\n";
		result += trajet.get_tripDescription().get_hubDeparture().get_id()+"-"+trajet.get_tripDescription().get_hubArrival().get_id();
		result += ":["+trajet.get_tripDescription().getTptCompany().get_id()+"]";
		result += trajet.get_tripInstanceID();
		result += "("+trajet.get_dateDepartStr()+":"+trajet.get_tripDescription().get_heureDepartStr();
		result += "-"+trajet.get_dateArriveStr()+":"+trajet.get_tripDescription().get_heureArriveStr()+")";
		for(ITripVisitable section : trajet.get_comfortClasses()){
			section.accept(this);
		}
	}

	@Override
	public void visit(DescriptionCroisiere croisiere) {
		result += "\n";
		result += croisiere.get_tripDescription().get_hubDeparture().get_id()+"-"+croisiere.get_tripDescription().get_hubArrival().get_id();
		result += ":["+croisiere.get_tripDescription().getTptCompany().get_id()+"]";
		result += croisiere.get_tripInstanceID();
		result += "("+croisiere.get_dateDepartStr()+":"+croisiere.get_tripDescription().get_heureDepartStr();
		result += "-"+croisiere.get_dateArriveStr()+":"+croisiere.get_tripDescription().get_heureArriveStr()+")";
		for(ITripVisitable section : croisiere.get_comfortClasses()){
			section.accept(this);
		}
	}
	/*Vol*/
	public void visit(Affaire affaire){
		result += "|"+affaire.getComfortClassType().name();
		result += affaire.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : affaire.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+affaire.get_seating().size()+")";
		result += affaire.getPricePercentage()*affaire.getFullPrice();
	}
	
	public void visit(Economique econo){
		result += "|"+econo.getComfortClassType().name();
		result += econo.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+econo.get_seating().size()+")";
		result += econo.getPricePercentage()*econo.getFullPrice();
	}
	public void visit(EconomiquePremium econoP){
		result += "|"+econoP.getComfortClassType().name();
		result += econoP.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : econoP.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+econoP.get_seating().size()+")";
		result += econoP.getPricePercentage()*econoP.getFullPrice();
	}
	public void visit(Premiere premiere){
		result += "|"+premiere.getComfortClassType().name();
		result += premiere.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+premiere.get_seating().size()+")";
		result += premiere.getPricePercentage()*premiere.getFullPrice();
	}
	
	/*CROISIERE*/
	public void visit(Famille famille){
		result += "|"+famille.getComfortClassType().name();
		for(ITripVisitable seat : famille.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+famille.get_seating().size()+")";
		result += famille.getPricePercentage()*famille.getFullPrice();
	}
	public void visit(FamilyDeluxe familleLuxe){
		result += "|"+familleLuxe.getComfortClassType().name();
		for(ITripVisitable seat : familleLuxe.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+familleLuxe.get_seating().size()+")";
		result += familleLuxe.getPricePercentage()*familleLuxe.getFullPrice();
	}
	public void visit(Interieur interieur){
		result += "|"+interieur.getComfortClassType().name();
		for(ITripVisitable seat : interieur.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+interieur.get_seating().size()+")";
		result += interieur.getPricePercentage()*interieur.getFullPrice();
	}
	public void visit(Suite suite){
		result += "|"+suite.getComfortClassType().name();
		for(ITripVisitable seat : suite.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+suite.get_seating().size()+")";
		result += suite.getPricePercentage()*suite.getFullPrice();
	}
	public void visit(Ocean ocean){
		result += "|"+ocean.getComfortClassType().name();
		for(ITripVisitable seat : ocean.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+ocean.get_seating().size()+")";
		result += ocean.getPricePercentage()*ocean.getFullPrice();
	}
	
	/*Train*/
	public void visit(TrainEconomique econo) {
		result += "|"+econo.getComfortClassType().name();
		result += econo.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : econo.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+econo.get_seating().size()+")";
		result += econo.getPricePercentage()*econo.getFullPrice();
		
	}

	public void visit(TrainPremiere premiere) {
		result += "|"+premiere.getComfortClassType().name();
		result += premiere.get_layout().getVehiculeLayoutType().name();
		for(ITripVisitable seat : premiere.get_seating()){
			seat.accept(this);
		}
		result += "("+this.get_count()+"/"+premiere.get_seating().size()+")";
		result += premiere.getPricePercentage()*premiere.getFullPrice();
		
	}
	
	@Override
	public void visit(InstanceSeat seat) {

		count += seat.get_Ipassenger().count(); 
	}

	
}
