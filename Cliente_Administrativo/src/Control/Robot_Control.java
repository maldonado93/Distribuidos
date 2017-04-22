package Control;
import interfaces.IRobot;
import persistence.Robot;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Robot_Control {
	private Robot u=null;;
	private IRobot ir=null;
	
	public Robot_Control() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IRobot) r.lookup("Robot");
		
        }
	
	public Robot searchRobot(int id){
		try{
			u=ir.searchRobot(id);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
	public boolean updateRobot(int serie, String base, String hombro, String codo,String muneca, String pinza){
		boolean update=true;
		try{
			if(!ir.updateRobot(serie,base,  hombro,  codo, muneca,  pinza))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delRobot(int serie){
		boolean del=true;
		try{
			if(!ir.delRobot(serie))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	public boolean addRobot(int serie,  String base, String hombro, String codo,String muneca, String pinza){
		boolean add=true;
		try{
			if(!ir.addRobot(serie,  base,  hombro,  codo, muneca,  pinza))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}


}
