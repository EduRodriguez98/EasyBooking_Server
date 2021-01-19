package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import data.FlightDTO;

public class TCPSocketClient {
	
	private Socket tcpSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public TCPSocketClient(String serverIP, int serverPort) {
		try {
			this.tcpSocket = new Socket(serverIP, serverPort);
			out = new ObjectOutputStream(this.tcpSocket.getOutputStream());
			in = new ObjectInputStream(this.tcpSocket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<FlightDTO> receiveFlights(String origin, String destination, String date) {
		ArrayList<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();
		
		String sendMessage = "" + origin + "#" + destination + "?" + date;
		
		try {
			out.writeObject(sendMessage);
			System.out.println(" - TCPSocketClient: Sent the request to obtain flights with the origin " + origin + ", destination " + destination + " and date " + date + " to '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort());
			flightsDTO = (ArrayList<FlightDTO>) in.readObject();
			System.out.println(" - TCPSocketClient: Received flights from '" 
					+ tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flightsDTO;
	}

}
