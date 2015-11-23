package ClientPkg;

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

	@Override
	public void visit(Economique econo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(EconomiquePremium econoP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Premiere premiere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Famille famille) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FamilyDeluxe famDeluxe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Interieur interieur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Ocean ocean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Suite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TrainEconomique econo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TrainPremiere premiere) {
		// TODO Auto-generated method stub
		
	}

}
