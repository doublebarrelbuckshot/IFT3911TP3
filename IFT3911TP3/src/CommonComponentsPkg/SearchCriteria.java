package CommonComponentsPkg;

import java.util.Date;

public class SearchCriteria {
	private String _tripIDNumber;
	private String _transportationCompanyName;
	private String _transportationHubName;
	private String _transportationHubVille;
	private ComfortClassEnum _sectionType;
	private String _seatLocation;
	private String _layoutType;
	private String _transportationHubNameDeparture;
	private String _transportationHubNameArrival;
	private Date   _tripDepartureDate;
	
	private int _numberTravellers;
	private boolean _travelTogether;
	
	public String get_tripIDNumber() {
		return _tripIDNumber;
	}
	public void set_tripIDNumber(String _tripIDNumber) {
		this._tripIDNumber = _tripIDNumber;
	}
	public String get_transportationCompanyName() {
		return _transportationCompanyName;
	}
	public void set_transportationCompanyName(String _transportationCompanyName) {
		this._transportationCompanyName = _transportationCompanyName;
	}
	public String get_transportationHubName() {
		return _transportationHubName;
	}
	public void set_transportationHubName(String _transportationHubName) {
		this._transportationHubName = _transportationHubName;
	}
	public String get_transportationHubVille() {
		return _transportationHubVille;
	}
	public void set_transportationHubVille(String _transportationHubVille) {
		this._transportationHubVille = _transportationHubVille;
	}
	public ComfortClassEnum get_sectionType() {
		return _sectionType;
	}
	public void set_sectionType(ComfortClassEnum _sectionType) {
		this._sectionType = _sectionType;
	}
	public String get_seatLocation() {
		return _seatLocation;
	}
	public void set_seatLocation(String _seatLocation) {
		this._seatLocation = _seatLocation;
	}
	public String get_layoutType() {
		return _layoutType;
	}
	public void set_layoutType(String _layoutType) {
		this._layoutType = _layoutType;
	}
	public int get_numberTravellers() {
		return _numberTravellers;
	}
	public void set_numberTravellers(int _numberTravellers) {
		this._numberTravellers = _numberTravellers;
	}
	public boolean is_travelTogether() {
		return _travelTogether;
	}
	public void set_travelTogether(boolean _travelTogether) {
		this._travelTogether = _travelTogether;
	}
	public String get__transportationHubNameDeparture() {
		return _transportationHubNameDeparture;
	}
	public void set__transportationHubNameDeparture(String _transportationHubNameDeparture) {
		this._transportationHubNameDeparture = _transportationHubNameDeparture;
	}
	public String get__transportationHubNameArrival() {
		return _transportationHubNameArrival;
	}
	public void set_transportationHubNameArrival(String _transportationHubNameArrival) {
		this._transportationHubNameArrival = _transportationHubNameArrival;
	}
	public Date get_tripDepartureDate() {
		return _tripDepartureDate;
	}
	public void set_tripDepartureDate(Date _tripDepartureDate) {
		this._tripDepartureDate = _tripDepartureDate;
	}
}