package Control;
import interfaces.IUsuario;
import persistence.Usuario;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Usuario_Control {
	private Usuario u=null;;
	private IUsuario ir=null;
	
	public Usuario_Control() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IUsuario) r.lookup("Usuario");
		
        }
	
	public Usuario searchUsuario(int codigo_usuario){
		try{
			u=ir.searchUsuario(codigo_usuario);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
	public boolean updateUsuario(int id, String nombre, String apellido, int telefono,String email, String tipo){
		boolean update=true;
		try{
			if(!ir.updateUsuario(id,nombre,  apellido,  telefono, email,  tipo))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delUsuario(int codigo_usuario){
		boolean del=true;
		try{
			if(!ir.delUsuario(codigo_usuario))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	public boolean addUsuario(int codigo_usuario,  int id, String nombre, String apellido,int telefono, String email, String tipo){
		boolean add=true;
		try{
			if(!ir.addUsuario(codigo_usuario,  id,  nombre,  apellido, telefono,  email, tipo))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}


}
