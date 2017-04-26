package Control;

import interfaces.IPractica;
import persistence.Practica;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Practica_Control {
	private Practica u=null;;
	private IPractica ir=null;
	
	public Practica_Control() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IPractica) r.lookup("Practica");
		
        }
	
	public Practica searchPractica(int codigo_Practica){
		try{
			u=ir.searchPractica(codigo_Practica);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
	public boolean updatePractica(int codigo_practica, int serie, String titulo, String descripcion){
		boolean update=true;
		try{
			if(!ir.updatePractica(codigo_Practica,serie,  titulo, descripcion))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delPractica(int codigo_practica){
		boolean del=true;
		try{
			if(!ir.delPractica(codigo_practica))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	public boolean addPractica(int codigo_practica,  int serie, String titulo, String descripcion){
		boolean add=true;
		try{
			if(!ir.addPractica(codigo_practica,  serie,  titulo, descripcion))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}


}
