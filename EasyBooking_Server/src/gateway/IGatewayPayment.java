package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGatewayPayment extends Remote {
	
	public void bookPayFlight(String username, String password, int flightNum, int numSeats) throws RemoteException;
}
