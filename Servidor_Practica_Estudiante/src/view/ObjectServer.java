package view;


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import logic.Imp_Material;
import logic.Imp_Practica;
import logic.Imp_Robot;
import logic.Imp_Usar;







public class ObjectServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		// TODO Auto-generated method stub
		
		//Imp_Usar ImpUsar = new Imp_Usar();
		//Imp_Practica ImpPractica = new Imp_Practica();
		Imp_Robot ImpRobot = new Imp_Robot();
	//	Imp_Material ImpMaterial = new Imp_Material();
		
		Registry r = LocateRegistry.createRegistry(10000);
		//r.rebind("Usar",ImpUsar);
		System.out.println("Objeto Usar Publicado");
		
		//r.rebind("Practica",ImpPractica);
		System.out.println("Objeto PracticaPublicado");
		
		r.rebind("Robot",ImpRobot);	
		System.out.println("Objeto Robot Publicado");
		
		//r.rebind("Material",ImpMaterial);
		System.out.println("Objeto Material Publicado");
		
		
		
		
		
		    
		    
	}

}
