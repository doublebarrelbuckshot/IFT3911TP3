package ReservationPkg;

import java.util.Vector;
import ReservationPkg.Order;

public class Client {
	private int _clientId;
	public Entity _clientInfo;
	public Vector<Order> _listOrders = new Vector<Order>();
	public IClientUI _clientSystem;

	public void addOrder(Order aOrder) {
		throw new UnsupportedOperationException();
	}

	public Order findOrder(int aOrderNum) {
		throw new UnsupportedOperationException();
	}

	public void deleteOrder(Order aOrder) {
		throw new UnsupportedOperationException();
	}

	public void removeOrder(Order aR) {
		throw new UnsupportedOperationException();
	}
}