package org.taxd.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

import org.taxd.remote.Calculator;
import org.taxd.remote.Product;
import org.taxd.remote.Product.ProductType;

public class Client {
	public static void main(String args[]) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			Registry registry = LocateRegistry.getRegistry(args[0]);
			Calculator calc = (Calculator) registry.lookup(name);
			Product p = new Product(ProductType.OTHER, 100);
			long vat = calc.calcVat(Arrays.asList(p));
			System.out.println(vat);
		} catch (Exception e) {
			System.err.println("CalcVat exception:");
			e.printStackTrace();
		}
	}
}
