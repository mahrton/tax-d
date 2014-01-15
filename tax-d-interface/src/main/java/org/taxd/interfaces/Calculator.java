package org.taxd.interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	long calcVat(List<Product> products) throws RemoteException;
}
