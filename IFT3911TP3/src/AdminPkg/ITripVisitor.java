package AdminPkg;

import TransportationPkg.AviationPkg.Vol;
import TransportationPkg.CroisierePkg.Croisiere;
import TransportationPkg.TrainPkg.Trajet;

public interface ITripVisitor {
	
	public void visit(Vol vol);
	public void visit(Trajet trajet);
	public void visit(Croisiere croisiere);
}
