package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Usar;

public interface IUsar extends Remote {
	Usar searchUsar(int codigo_practica)throws RemoteException;
	boolean addUsar(int codigo_practica,String codigo_material)throws RemoteException;

	   
}
