package ReservationPkg;

import java.util.Date;

public class PassagerReal extends Passager {
	private Date dateNaissance;
	private String numPassport;
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getNumPassport() {
		return numPassport;
	}
	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}
	
	public int count(){
		return 1;
	}
}
