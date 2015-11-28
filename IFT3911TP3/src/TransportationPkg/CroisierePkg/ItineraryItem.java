package TransportationPkg.CroisierePkg;

import java.util.Date;

import TransportationPkg.TransportationHub;

public class ItineraryItem {
	private Port _port;
	private Date _dateArrive;
	private Date _dateLeave;
	public Croisiere _unnamed_Croisiere_;
	
	public ItineraryItem(){
		
	}
	public Port get_port() {
		return _port;
	}
	public void set_port(TransportationHub port) {
		this._port = (Port)port;
	}
	public Date get_dateArrive() {
		return _dateArrive;
	}
	public void set_dateArrive(Date _dateArrive) {
		this._dateArrive = _dateArrive;
	}
	public Date get_dateLeave() {
		return _dateLeave;
	}
	public void set_dateLeave(Date _dateLeave) {
		this._dateLeave = _dateLeave;
	}
	public Croisiere get_unnamed_Croisiere_() {
		return _unnamed_Croisiere_;
	}
	public void set_unnamed_Croisiere_(Croisiere _unnamed_Croisiere_) {
		this._unnamed_Croisiere_ = _unnamed_Croisiere_;
	}
	
	
}