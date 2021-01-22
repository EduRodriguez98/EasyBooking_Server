package elements;

public class Airport {

	public String airport_ID;
	public String name;
	
	public Airport(String airport_ID, String name) {
		super();
		this.airport_ID = airport_ID;
		this.name = name;
	}
	
	public String getAirport_ID() {
		return airport_ID;
	}
	
	public void setAirport_ID(String airport_ID) {
		this.airport_ID = airport_ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
}
