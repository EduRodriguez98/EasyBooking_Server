package elements;

public class Flight {
	
	/*
	 * public Airport originA; public Airport destinationA; public Airline airline;
	 * public ArrayList<Seat> seats; public int flightNum; public String
	 * departure_date; public String departure_hour; public String arrival_date;
	 * public String arrival_hour;
	 * 
	 * public Flight(Airport originA, Airport destinationA, Airline airline, int
	 * flightNum, String departure_date, String departure_hour, String arrival_date,
	 * String arrival_hour) { super(); this.originA = originA; this.destinationA =
	 * destinationA; this.airline = airline; this.flightNum = flightNum;
	 * this.departure_date = departure_date; this.departure_hour = departure_hour;
	 * this.arrival_date = arrival_date; this.arrival_hour = arrival_hour; }
	 * 
	 * public Airport getOriginA() { return originA; }
	 * 
	 * public void setOriginA(Airport originA) { this.originA = originA; }
	 * 
	 * public Airport getDestinationA() { return destinationA; }
	 * 
	 * public void setDestinationA(Airport destinationA) { this.destinationA =
	 * destinationA; }
	 * 
	 * public Airline getAirline() { return airline; }
	 * 
	 * public void setAirline(Airline airline) { this.airline = airline; }
	 * 
	 * public int getFlightNum() { return flightNum; }
	 * 
	 * public void setFlightNum(int flightNum) { this.flightNum = flightNum; }
	 * 
	 * public String getDeparture_date() { return departure_date; }
	 * 
	 * public void setDeparture_date(String departure_date) { this.departure_date =
	 * departure_date; }
	 * 
	 * public String getDeparture_hour() { return departure_hour; }
	 * 
	 * public void setDeparture_hour(String departure_hour) { this.departure_hour =
	 * departure_hour; }
	 * 
	 * public String getArrival_date() { return arrival_date; }
	 * 
	 * public void setArrival_date(String arrival_date) { this.arrival_date =
	 * arrival_date; }
	 * 
	 * public String getArrival_hour() { return arrival_hour; }
	 * 
	 * public void setArrival_hour(String arrival_hour) { this.arrival_hour =
	 * arrival_hour; }
	 */
	
	private String origin;
	private String destination;
	private String date;
	
	public Flight(String origin, String destination, String date) {
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
