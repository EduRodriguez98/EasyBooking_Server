package gateway;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.FlightDTO;
import server.IVueling;

public class GatewayAirline2 implements IGatewayAirline {
	// RMI
	
	private String serverIP = "127.0.0.1";
	private int serverPort = 1099;
	private String serverName = "Vueling";
	
	public GatewayAirline2 (String serverIP, int serverPort, String serverName) throws RemoteException {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.serverName = serverName;
	}
	
	public GatewayAirline2() throws RemoteException {

	}
	
	public ArrayList<FlightDTO> getFlights(String origin, String destination, String date) throws RemoteException {
		ArrayList<FlightDTO> flights = new ArrayList<FlightDTO>();
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			
			String serverR = "//" + serverIP + ":" + serverPort + "/" + serverName;
			IVueling server = (IVueling) java.rmi.Naming.lookup(serverR);
			
			try {
				flights = server.getFlights(origin, destination, date);
				if (flights != null) {
					System.out.println("Flights have been sent.");
				}
				else {
					System.out.println("Flights not retrieved.");
				}
			} catch (Exception e) {
				System.err.println("- Exception: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("- Exception running the server getting flights in the gateway: " + e.getMessage());
			e.printStackTrace();
		}
		
		return flights;
	}
}
