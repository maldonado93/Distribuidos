package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Usuario;



public interface IUsario extends Remote {
	Usuario searchUsuario(int codigo_usuario)throws RemoteException;
	boolean updateUsuario(int codigo_usuario, String id, String nombre, String apellido,String telefono, String email,String tipo)throws RemoteException;
	boolean delUsuario(int codigo_usuario)throws RemoteException;
	boolean addUsuario(int codigo_usuario, String id, String nombre, String apellido,String telefono, String email,String tipo)throws RemoteException;

}
