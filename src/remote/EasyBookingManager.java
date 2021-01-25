package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.IReservationDAO;
import dao.ReservationDAO;
import data.Reservation;
import dto.EBFlightAssembler;
import dto.EBFlightDTO;
import dto.FlightDTO;
import gateway.IGatewayAuthentication;
import gateway.IGatewayPayment;
import gateway.GatewayAirline2;
import gateway.GatewayAuthentication;
import gateway.GatewayPaypal;
import gateway.IGatewayAirline;

public class EasyBookingManager extends UnicastRemoteObject implements IEasyBookingManager {

	private static final long serialVersionUID = 1L;
	private IGatewayAuthentication gatewayAuthentication;
	private IGatewayAirline gatewayAirline2;
	private IReservationDAO reservationDAO;
	private IGatewayPayment gatewayPayment;
	private String serverName;

	EBFlightAssembler assembler = new EBFlightAssembler();
	
	public EasyBookingManager(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}

	public boolean validateUser(String username, String password) throws RemoteException {
		gatewayAuthentication = new GatewayAuthentication(); 
		return gatewayAuthentication.validateUser(username, password);
	}
	
	public boolean registerUser(String username, String password) throws RemoteException { 
		gatewayAuthentication = new GatewayAuthentication(); 
		return gatewayAuthentication.registerUser(username, password); 
	}
	
	 
	public ArrayList<EBFlightDTO> searchFlights(String origin, String destination, String date) throws RemoteException {
		ArrayList<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
		ArrayList<EBFlightDTO> flights = new ArrayList<EBFlightDTO>();
		
		gatewayAirline2 = new GatewayAirline2();
		flightsDTO = gatewayAirline2.getFlights(origin, destination, date);
		flights = assembler.disassemble(flightsDTO);
		
		return flights;
	}
	
	
	public void bookFlight(String username, EBFlightDTO flight, int numSeats, ArrayList<String> passengers) {
		float price = flight.getPrice() * numSeats;
		Reservation reservation = new Reservation(flight.getFlightCode(), numSeats, username, passengers, price);
		reservationDAO = new ReservationDAO();
		reservationDAO.storeReservation(reservation);
	}
	
	public boolean validatePayment(String username, String password) throws RemoteException {
		gatewayPayment = new GatewayPaypal(); 
		return gatewayPayment.validatePayment(username, password);
	}
	
	
	public String getName() {
		return serverName;
	}

}
