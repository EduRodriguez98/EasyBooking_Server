package dto;

import java.io.Serializable;

public class EBFlightDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String flightCode;
	private String origin;
	private String destination;
	private String date;
	private float price;
	
	public EBFlightDTO(String flightCode, String origin, String destination, String date, float price) {
		super();
		this.flightCode = flightCode;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.price = price;
	}
	
	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
