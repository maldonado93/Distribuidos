package Control;

import interfaces.IMaterial;
import persistence.Material;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Material_Control {
	private Material u=null;;
	private IMaterial ir=null;
	
	public Material_Control() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IMaterial) r.lookup("Material");
		
        }
	
	public Material searchMaterial(int codigo_material){
		try{
			u=ir.searchMaterial(codigo_material);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
	public boolean updateMaterial(int codigo_material, String tipo, String descripcion){
		boolean update=true;
		try{
			if(!ir.updateMaterial(codigo_material,tipo,  descripcion))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delMaterial(int codigo_material){
		boolean del=true;
		try{
			if(!ir.delMaterial(codigo_material))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	public boolean addMaterial(int codigo_material,  String tipo, String descripcion){
		boolean add=true;
		try{
			if(!ir.addMaterial(codigo_material,  tipo,  descripcion))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}


}
