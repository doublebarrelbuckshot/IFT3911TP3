package CommonComponentsPkg;

public class Adresse {
	
	private int _streetNumber;
	private String _streetName;
	private String _apartmentNumber;
	private String _city;
	private String _provinceState;
	private String _country;
	private String _postalZip;
	
	public Adresse(){
		
	}
	public Adresse(int _streetNumber, String _streetName,
			String _apartmentNumber, String _city, String _provinceState,
			String _country, String _postalZip) {

		this._streetNumber = _streetNumber;
		this._streetName = _streetName;
		this._apartmentNumber = _apartmentNumber;
		this._city = _city;
		this._provinceState = _provinceState;
		this._country = _country;
		this._postalZip = _postalZip;
	}
	public int get_streetNumber() {
		return _streetNumber;
	}
	public void set_streetNumber(int _streetNumber) {
		this._streetNumber = _streetNumber;
	}
	public String get_streetName() {
		return _streetName;
	}
	public void set_streetName(String _streetName) {
		this._streetName = _streetName;
	}
	public String get_apartmentNumber() {
		return _apartmentNumber;
	}
	public void set_apartmentNumber(String _apartmentNumber) {
		this._apartmentNumber = _apartmentNumber;
	}
	public String get_city() {
		return _city;
	}
	public void set_city(String _city) {
		this._city = _city;
	}
	public String get_provinceState() {
		return _provinceState;
	}
	public void set_provinceState(String _provinceState) {
		this._provinceState = _provinceState;
	}
	public String get_country() {
		return _country;
	}
	public void set_country(String _country) {
		this._country = _country;
	}
	public String get_postalZip() {
		return _postalZip;
	}
	public void set_postalZip(String _postalZip) {
		this._postalZip = _postalZip;
	}
	
}