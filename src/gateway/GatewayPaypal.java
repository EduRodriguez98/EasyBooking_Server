package gateway;

import java.rmi.RemoteException;
import server.IPayPal;

public class GatewayPaypal implements IGatewayPayment {
	
	private String serverIP = "127.0.0.1";
	private int serverPort = 1099;
	private String serverName = "PayPal";

	public GatewayPaypal (String serverIP, int serverPort, String serverName) throws RemoteException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.serverName = serverName;
	}
	
	public GatewayPaypal() throws RemoteException {

	}
	
	public boolean validatePayment(String username, String password)  throws RemoteException {
		boolean validated = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String serverR = "//" + serverIP + ":" + serverPort + "/" + serverName;
			
			IPayPal server = (IPayPal) java.rmi.Naming.lookup(serverR);
			
			try {
				validated = server.validatePayment(username, password);
				if (validated) {
					System.out.println("Payment successful.");
				}
				else {
					System.out.println("Payment rejected.");
				}
			} catch (Exception e) {
				System.err.println("- Exception: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validated;
	}
}
