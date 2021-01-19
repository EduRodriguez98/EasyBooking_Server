package data;

import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Shelf;

public interface IFlightDAO {
	public void storeProduct(Flight flight);
	public List<Flight> getProducts();
