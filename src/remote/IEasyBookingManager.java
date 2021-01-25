package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.EBFlightDTO;

public interface IEasyBookingManager extends Remote {
	public boolean validateUser(String username, String password) throws RemoteException;
	public boolean registerUser(String username, String password) throws RemoteException;
	public ArrayList<EBFlightDTO> searchFlights(String origin, String destination, String date) throws RemoteException;
	public void bookFlight(String username, EBFlightDTO flight, int numSeats, ArrayList<String> passengers) throws RemoteException;
	public boolean validatePayment(String username, String password) throws RemoteException;
}
