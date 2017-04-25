package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Material;



public interface IMaterial extends Remote {
	Material searchMaterial(int codigo_material)throws RemoteException;
	boolean updateMaterial(int codigo_material,String descripcion,String tipo)throws RemoteException;
	boolean delMaterial(int codigo_material)throws RemoteException;
	boolean addMaterial(int codigo_material,String descripcion,String tipo)throws RemoteException;

    
}
