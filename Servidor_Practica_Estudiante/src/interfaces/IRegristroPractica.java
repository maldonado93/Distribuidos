package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Registro_practica;



public interface IRegristroPractica extends Remote {
	Registro_practica searchRegistro_practica(int codigo_registro)throws RemoteException;
	boolean updateRegistro_practica(int codigo_registro, String codigo_practica, String codigo_usuario, String fecha,String hora_inicio, String hora_fin)throws RemoteException;
	boolean delRegistro_practica(int codigo_registro)throws RemoteException;
	boolean addRegistro_practica(int codigo_registro, String codigo_practica, String codigo_usuario, String fecha,String hora_inicio, String hora_fin)throws RemoteException;
}
