package gateway;

public class GatewayFactory {
	
	private static GatewayFactory instance = new GatewayFactory();
	
	private static IGatewayAirline airline1; // IBERIA
	private static IGatewayAirline airline2; // VUELING
	
	public static synchronized GatewayFactory getInstance() {
		if (instance == null) {
			instance = new GatewayFactory();
		}
		return instance;
	}
	
	public static IGatewayAirline createGateway(String airline) {
		if(airline == "IBE") {
			airline1 = new GatewayAirline1();
			return airline1;
			
		} else {
			airline2 = new GatewayAirline2();
			return airline2;
		}
	}

}
