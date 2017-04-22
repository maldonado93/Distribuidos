package interfaces;

import java.rmi.RemoteException;

import persistence.Practica;


public interface IPractica {
	Practica searchUser(int codigo_practica)throws RemoteException;
	boolean updateUser(int codigo_practica,String serie,String titulo,String descripcion)throws RemoteException;
	boolean delUser(int codigo_practica)throws RemoteException;
	boolean addUser(int codigo_practica,String serie,String titulo,String descripcion)throws RemoteException;

}
