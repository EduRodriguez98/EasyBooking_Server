package elements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class Reservation {

	public Flight flight;
	public ArrayList<String> pasajeros;
	public int precio;
	
	public Reservation(Flight flight, ArrayList<String> pasajeros, int precio) {
		super();
		this.flight = flight;
		this.pasajeros = pasajeros;
		this.precio = precio;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public ArrayList<String> getPasajeros() {
		return pasajeros;
	}
	
	public void setPasajeros(ArrayList<String> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
