package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGatewayPayment extends Remote {
	
	public boolean validatePayment(String username, String password) throws RemoteException;
}
