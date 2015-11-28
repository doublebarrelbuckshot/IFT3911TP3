package ReservationPkg;

import java.util.Vector;
import ReservationPkg.Order;

public class Client {
	private int _clientId;
	public Entity _clientInfo;
	public Vector<Order> _listOrders = new Vector<Order>();
	public IClientUI _clientSystem;

	public void addOrder(Order aOrder) {
		_listOrders.add(aOrder);
	}

	public Order findOrder(int aOrderNum) {
		return _listOrders.get(aOrderNum);
	}

	public void deleteOrder(Order aOrder) {
		
	}

	public void removeOrder(Order aR) {
		_listOrders.remove(aR);
	}
}