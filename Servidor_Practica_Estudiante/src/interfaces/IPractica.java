package interfaces;

import java.rmi.RemoteException;

import persistence.Practica;


public interface IPractica {
	Practica searchPractica(int codigo_practica)throws RemoteException;
	boolean updatePractica(int codigo_practica,String serie,String titulo,String descripcion)throws RemoteException;
	boolean delPractica(int codigo_practica)throws RemoteException;
	boolean addPractica(int codigo_practica,String serie,String titulo,String descripcion)throws RemoteException;

}
