package gateway;

import java.rmi.RemoteException;

public class GatewayPaypal implements IGatewayPayment{
	
	private String serverIP;
	private int serverPort;
	private String serverName;

	public GatewayPaypal (String serverIP, int serverPort, String serverName) throws RemoteException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.serverName = serverName;
	}
	
	public GatewayPaypal() throws RemoteException {
	}

	@Override
	public void bookPayFlight(String username, String password, int flightNum, int numSeats) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
