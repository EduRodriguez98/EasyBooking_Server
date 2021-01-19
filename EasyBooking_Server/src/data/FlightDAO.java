package data;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.Shelf;

public class FlightDAO implements IFlightDAO {

	private PersistenceManagerFactory pmf;
	
	public FlightDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public void storeProduct(Flight flight) {
		this.storeObject(flight);
	}
	
	private void storeFlight(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
	public List<Flight> getFlights() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Flight> flights = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Flight> extent = pm.getExtent(Flight.class, true);
			
			for (Flight flight : extent) {
				flights.add(flight);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return flights;
	}
}