package ReservationPkg;

import CommonComponentsPkg.Adresse;

public class Person extends Entity {
	private String _firstName;
	private Sexe _sexe;
	private String _lastName;
	public Person(){}
	
	public Person(int _numTel, Adresse _adresse, String _courriel,
			String _firstName, Sexe _sexe, String _lastName) {
		super(_numTel, _adresse, _courriel);
		this._firstName = _firstName;
		this._sexe = _sexe;
		this._lastName = _lastName;
	}

	public Person(String _firstName, Sexe _sexe, String _lastName) {
		this._firstName = _firstName;
		this._sexe = _sexe;
		this._lastName = _lastName;
	}

	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	public Sexe get_sexe() {
		return _sexe;
	}
	public void set_sexe(Sexe _sexe) {
		this._sexe = _sexe;
	}
	public String get_lastName() {
		return _lastName;
	}
	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
	
}