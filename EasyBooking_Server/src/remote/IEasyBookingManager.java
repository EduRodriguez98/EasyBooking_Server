package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.EBFlightDTO;

public interface IEasyBookingManager extends Remote {
	public boolean validateUser(String username, String password) throws RemoteException;
	public boolean registerUser(String username, String password) throws RemoteException;
	public ArrayList<EBFlightDTO> searchFlights(String origin, String destination, String date) throws RemoteException;
	//public void searchFlights(String airCode, String airName) throws RemoteException;
	//public boolean bookFlight(String username, FlightDTO flight, int numSeats, ArrayList<String> passengers, String date) throws RemoteException;
	//public void bookPayFlight(String username, String password, int flightNum, int numSeats) throws RemoteException;

}
