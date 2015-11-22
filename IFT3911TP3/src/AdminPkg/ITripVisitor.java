package AdminPkg;

import TransportationPkg.AviationPkg.DescriptionVol;
import TransportationPkg.CroisierePkg.DescriptionCroisiere;
import TransportationPkg.TrainPkg.DescriptionTrajet;

public interface ITripVisitor {
	
	public void visit(DescriptionVol vol);
	public void visit(DescriptionTrajet trajet);
	public void visit(DescriptionCroisiere croisiere);
}
