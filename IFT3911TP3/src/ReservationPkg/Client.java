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
	
	public Reservation findReservation(int reservationNumber){
		for(Order order: _listOrders){
			if(order instanceof Reservation){
				if(order.get_number() == reservationNumber){
					return (Reservation)order;
				}
			}
		}
		return null;
	}

	public void deleteOrder(Order aOrder) {
		
	}

	public void removeOrder(Order aR) {
		_listOrders.remove(aR);
	}
}