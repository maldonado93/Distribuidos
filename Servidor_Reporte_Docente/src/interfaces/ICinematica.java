package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import persistence.Cinematicas;



public interface ICinematica extends Remote {
	Cinematicas searchCinematica(int codigo_cinematica)throws RemoteException;
	boolean updateCinematicas(int codigo_cinematica, String codigo_registro, String codigo_practica, String codigo_usuario,String base, String hombro,String codo,String muneca,String pinza)throws RemoteException;
	boolean delCinematicas(int codigo_cinematica)throws RemoteException;
	boolean addCinematicas(int codigo_cinematica, String codigo_registro, String codigo_practica, String codigo_usuario,String base, String hombro,String codo,String muneca,String pinza)throws RemoteException;

}
