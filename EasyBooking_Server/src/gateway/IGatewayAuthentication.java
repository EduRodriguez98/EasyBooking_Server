package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGatewayAuthentication extends Remote {
	public boolean validateUser(String username, String password) throws RemoteException;
	public boolean registerUser(String username, String password) throws RemoteException;
}
