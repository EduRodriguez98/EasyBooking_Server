package gateway;

import java.rmi.RemoteException;
import server.IGoogle;

public class GatewayAuthentication implements IGatewayAuthentication {
	
	private String serverIP = "127.0.0.1";
	private int serverPort = 1099;
	private String serverName = "Google";

	public GatewayAuthentication (String serverIP, int serverPort, String serverName) throws RemoteException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.serverName = serverName;
	}
	
	public GatewayAuthentication() throws RemoteException {

	}
	
	public boolean validateUser(String username, String password)  throws RemoteException {
		boolean validated = false;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String serverR = "//" + serverIP + ":" + serverPort + "/" + serverName;
			
			IGoogle server = (IGoogle) java.rmi.Naming.lookup(serverR);
			
			try {
				validated = server.validateUser(username, password);
				if (validated) {
					System.out.println("User and password correct.");
				}
				else {
					System.out.println("Error. Non-existent or wrong user.");
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
	
	
	 public boolean registerUser(String username, String password) throws RemoteException { 
		 boolean registered = false;
	  
		 if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager()); 
		 }
	 
		 try {
			 String serverR = "//" + serverIP + ":" + serverPort + "/" + serverName;
			 
			 IGoogle server = (IGoogle) java.rmi.Naming.lookup(serverR);
	  
			 try { 
				 registered = server.registerUser(username, password); 
				 if (registered) {
					 System.out.println("User successfully registered."); 
				 } else {
					 System.out.println("Error. User already registered."); 
				 } 
			 } catch (Exception e) {
				 System.err.println("- Exception: " + e.getMessage()); e.printStackTrace(); 
			 }
		 } catch (Exception e) { 
			 e.printStackTrace(); 
		 }
		 return registered; 
	 }
	 

}
