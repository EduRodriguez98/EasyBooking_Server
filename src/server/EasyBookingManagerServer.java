package server;

import java.rmi.Naming;

import remote.IEasyBookingManager;
import remote.EasyBookingManager;

public class EasyBookingManagerServer {
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IEasyBookingManager EasyBookingServer = new EasyBookingManager(args[2]);
			Naming.rebind(name, EasyBookingServer);
			System.out.println("- EasyBookingManager '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
