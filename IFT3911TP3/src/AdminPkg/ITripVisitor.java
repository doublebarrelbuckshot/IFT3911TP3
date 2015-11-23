package AdminPkg;

import TransportationPkg.GenericSeat;
import TransportationPkg.InstanceSeat;
import TransportationPkg.AviationPkg.Affaire;
import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.TrainPkg.DescriptionTrajet;

public interface ITripVisitor {
	
	public void visit(DescriptionVol vol);
	public void visit(DescriptionTrajet trajet);
	public void visit(DescriptionCroisiere croisiere);
	public void visit(Affaire affaire);
	public void visit(InstanceSeat seat);
	
}
