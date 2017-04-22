package interfaces;

import java.rmi.RemoteException;

import persistence.Usar;

public interface IUsar {
	Usar searchUser(int codigo_practica)throws RemoteException;
	boolean updateUser(int codigo_practica,String codigo_material)throws RemoteException;
	boolean delUser(int codigo_practica)throws RemoteException;
	boolean addUser(int codigo_practica,String codigo_material)throws RemoteException;

	   
}
