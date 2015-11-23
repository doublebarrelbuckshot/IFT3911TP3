package AdminPkg;

import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
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

public interface ITripVisitor {
	
	public void visit(DescriptionVol vol);
	public void visit(DescriptionTrajet trajet);
	public void visit(DescriptionCroisiere croisiere);
	public void visit(Affaire affaire);
	public void visit(Economique econo);
	public void visit(EconomiquePremium econoP);
	public void visit(Premiere premiere);
	public void visit(Famille famille);
	public void visit(FamilyDeluxe famDeluxe);
	public void visit(Interieur interieur);
	public void visit(Ocean ocean);
	public void visit(Suite suite);
	public void visit(TrainEconomique econo);
	public void visit(TrainPremiere premiere);
	public void visit(InstanceSeat seat);
	
}
