package data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Reservation {

	public int reservationID;
	public String flightCode;
	public int numSeats;
	public String username;
	public ArrayList<String> passengers;
	public float price;
	
	public Reservation(String flightCode, int numSeats, String username,
			ArrayList<String> passengers, float price) {
		super();
		//this.reservationID = reservationID;
		this.flightCode = flightCode;
		this.numSeats = numSeats;
		this.username = username;
		this.passengers = passengers;
		this.price = price;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<String> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<String> passengers) {
		this.passengers = passengers;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
