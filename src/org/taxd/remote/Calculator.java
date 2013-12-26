package org.taxd.remote;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	double calcVat(List<Product> products) throws RemoteException;
}
