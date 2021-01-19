package gateway;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.Remote;

import data.FlightDTO;

public interface IGatewayAirline extends Remote {
	
	public ArrayList <FlightDTO> getFlights(String origin, String destination, String date) throws RemoteException;
}
