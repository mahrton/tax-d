package org.taxd.server;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.taxd.interfaces.Calculator;
import org.taxd.interfaces.Product;

public class Server implements Calculator {

	private Server() {
		super();
	}
	
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "/home/marton/dev/workspace/tax-d/tax-d-server/src/main/resources/server.policy");
		System.out.println("java.security.policy - " + System.getProperty("java.security.policy"));
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "TaxCalc";
            Server engine = new Server();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("TaxCalc bound");
        } catch (Exception e) {
            System.err.println("TaxCalc exception, couldn't initialize server:");
            e.printStackTrace();
        }
	}
	
	public long calcVat(List<Product> products) throws RemoteException {
		return 0;
	}

}
