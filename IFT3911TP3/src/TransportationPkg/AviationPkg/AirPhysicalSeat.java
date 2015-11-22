package TransportationPkg.AviationPkg;

import TransportationPkg.PermanentSeat;

public class AirPhysicalSeat extends PermanentSeat {
	private int _rowNumber;
	private String _columnLetter;
	public int get_rowNumber() {
		return _rowNumber;
	}
	public void set_rowNumber(int _rowNumber) {
		this._rowNumber = _rowNumber;
	}
	public String get_columnLetter() {
		return _columnLetter;
	}
	public void set_columnLetter(String _columnLetter) {
		this._columnLetter = _columnLetter;
	}
	
	
}