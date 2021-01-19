package data;

import java.util.List;

//imports datanucleus

public interface IFlightDAO {
	public void storeProduct(Flight flight);
	public List<Flight> getProducts();
}
