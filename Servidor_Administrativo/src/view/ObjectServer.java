package view;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.Imp_Material;
import logic.Imp_Practica;
import logic.Imp_Robot;
import logic.Imp_Usar;



public class ObjectServer {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		
		Imp_Usar impl3 = new Imp_Usar();
		Registry r3 = LocateRegistry.createRegistry(10000);
		r3.rebind("Usuario",impl3);
		    System.out.println("Objeto Publicado");
		
		Imp_Practica impl2 = new Imp_Practica();
		Registry r2 = LocateRegistry.createRegistry(10000);
		r2.rebind("Usuario",impl2);
		    System.out.println("Objeto Publicado");
		
		Imp_Robot impl1 = new Imp_Robot();
		Registry r1 = LocateRegistry.createRegistry(10000);
		r1.rebind("Usuario",impl1);
		    System.out.println("Objeto Publicado");
		
		
		Imp_Material impl = new Imp_Material();
		Registry r = LocateRegistry.createRegistry(10000);
		r.rebind("Usuario",impl);
		    System.out.println("Objeto Publicado");
		    
		    
	}

}
