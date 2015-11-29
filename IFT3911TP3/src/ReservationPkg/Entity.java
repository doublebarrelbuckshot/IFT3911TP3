package ReservationPkg;

import CommonComponentsPkg.Adresse;

public class Entity {
	private String _numTel;
	private Adresse _adresse;
	private String _courriel;
	public Entity(){}
	
	
	public Entity(String _numTel, Adresse _adresse, String _courriel) {
		super();
		this._numTel = _numTel;
		this._adresse = _adresse;
		this._courriel = _courriel;
	}


	public String get_numTel() {
		return _numTel;
	}
	public void set_numTel(String _numTel) {
		this._numTel = _numTel;
	}
	public Adresse get_adresse() {
		return _adresse;
	}
	public void set_adresse(Adresse _adresse) {
		this._adresse = _adresse;
	}
	public String get_courriel() {
		return _courriel;
	}
	public void set_courriel(String _courriel) {
		this._courriel = _courriel;
	};
	
}