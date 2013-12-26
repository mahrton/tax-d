package org.taxd.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.taxd.remote.Calculator;
import org.taxd.remote.Product;

public class Server implements Calculator {

	private Server() {
		super();
	}
	
	public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "TaxCalc";
            Server engine = new Server();
            Server stub = (Server) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("TaxCalc bound");
        } catch (Exception e) {
            System.err.println("TaxCalc exception, couldn't initialize server:");
            e.printStackTrace();
        }
	}
	
	@Override
	public double calcVat(List<Product> products) throws RemoteException {
		return 0;
	}

}
