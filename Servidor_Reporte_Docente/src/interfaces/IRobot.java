package interfaces;

import java.rmi.RemoteException;

import persistence.Robot;



public interface IRobot {
	Robot searchRobot(int serie)throws RemoteException;
	boolean updateRobot(int serie,String base,String hombro,String codo, String muneca,String pinza)throws RemoteException;
	boolean delRobot(int serie)throws RemoteException;
	boolean addRobot(int serie,String base,String hombro,String codo,String muneca,String pinza)throws RemoteException;
	
}
