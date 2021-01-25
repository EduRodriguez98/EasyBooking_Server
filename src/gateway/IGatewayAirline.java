package gateway;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.FlightDTO;

import java.rmi.Remote;

public interface IGatewayAirline extends Remote {
	
	public ArrayList <FlightDTO> getFlights(String origin, String destination, String date) throws RemoteException;
}
