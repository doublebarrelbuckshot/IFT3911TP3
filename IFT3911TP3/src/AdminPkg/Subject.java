package AdminPkg;

import java.util.Vector;

public class Subject {
	public Vector<Observer> _observers = new Vector<Observer>();

	public void attach(Observer aO) {
		this._observers.add(aO);
	}

	public void detach(Observer aO) {
		this._observers.remove(aO);
	}

	public void notifyObservers(String message) {
		for(Observer o : _observers)
		{
			o.update(message);
		}
	}
}