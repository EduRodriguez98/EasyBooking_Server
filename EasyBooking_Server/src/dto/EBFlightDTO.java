package dto;

import java.io.Serializable;

public class EBFlightDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String origin;
	private String destination;
	private String date;
	
	public EBFlightDTO(String origin, String destination, String date) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.date = date;
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
}
