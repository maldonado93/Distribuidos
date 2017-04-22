package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Material;



public interface IMaterial extends Remote {
	Material searchUser(int codigo_material)throws RemoteException;
	boolean updateUser(int codigo_material,String descripcion,String tipo)throws RemoteException;
	boolean delUser(int codigo_material)throws RemoteException;
	boolean addUser(int codigo_material,String descripcion,String tipo)throws RemoteException;

    
}
