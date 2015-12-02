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
	
	public Booking findBooking(int bookingNumber){
		for(Order order: _listOrders){
			if(order instanceof Booking){
				if(order.get_number() == bookingNumber){
					return (Booking)order;
				}
			}
		}
		return null;
	}
	public Reservation findReservation(int numeroR){
		for(Order order: _listOrders){
			if(order instanceof Reservation){
				if(order.get_number() == numeroR){
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