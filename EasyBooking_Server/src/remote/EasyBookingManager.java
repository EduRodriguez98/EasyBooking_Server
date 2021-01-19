package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.FlightDTO;
import gateway.GatewayAuthentication;
import gateway.GatewayAirline1;
import gateway.GatewayAirline2;
import gateway.GatewayPaypal;
import gateway.IGatewayAuthentication;
import gateway.IGatewayAirline;
import gateway.IGatewayPayment;

public class EasyBookingManager extends UnicastRemoteObject implements IEasyBookingManager {
	
	private static final long serialVersionUID = 1L;
	private IGatewayAuthentication gateway;
	private IGatewayAirline gateway1;
	private IGatewayAirline gateway2;
	private IGatewayPayment gateway3;
	private String serverName;
	
	public EasyBookingManager(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}
	
	public boolean validateUser(String username, String password) throws RemoteException {
		// gateway
		gateway = new GatewayAuthentication(); // parameters ip, port, serverName
		return gateway.validateUser(username, password);
	}
	
	public boolean registerUser(String username, String password) throws RemoteException {
		// gateway
		gateway = new GatewayAuthentication(); // parameters ip, port, serverName
		return gateway.registerUser(username, password);
	}
	
	public ArrayList<FlightDTO> searchFlights(String origin, String destination, String date) throws RemoteException {
		ArrayList<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
		ArrayList<FlightDTO> flights1 = new ArrayList<FlightDTO>();
		ArrayList<FlightDTO> flights2 = new ArrayList<FlightDTO>();

		gateway1 = new GatewayAirline1();
		flights1 = gateway1.getFlights(origin, destination, date);
		
		for (int i = 0; i < flights1.size(); i++) {
			flightsDTO.add(flights1.get(i));
		}
		
		gateway2 = new GatewayAirline2();
		flights2 = gateway2.getFlights(origin, destination, date);
		
		for (int i = 0; i < flights2.size(); i++) {
			flightsDTO.add(flights2.get(i));
		}
		
		return flightsDTO;
	}
	

	// GORKA
	/*
	 * @Override public void bookPayFlight(String username, String password, int
	 * flightNum, int numSeats) throws RemoteException { // TODO Auto-generated
	 * method stub gateway3 = new GatewayPaypal(); gateway3.bookPayFlight(username,
	 * password, flightNum, numSeats); }
	 */

	public String getName() {
		return serverName;
	}
	
}
