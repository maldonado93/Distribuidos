package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IPractica;
import interfaces.IUsar;
import persistence.NotFoundException;
import persistence.Practica;
import persistence.PracticaDao;
import persistence.Robot;
import persistence.RobotDao;
import persistence.Usar;
import persistence.UsarDao;

public class Imp_Usar extends UnicastRemoteObject implements IUsar {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Usar() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Usar searchUsar(int codigo_practica) throws RemoteException {
	//crear el value object a retornar
	Usar u=new Usar(codigo_practica);	
	//crear los DAO a manipular
	UsarDao Usar= new UsarDao();
	 /* private int codigo_practica;
    private String codigo_material;*/
	 try{
		 Usar.load(getConnection(),u);
	    }
	 catch(SQLException e){
		 u=null;
		 e.printStackTrace();
		 
	    }catch (NotFoundException e) {
	    	u=null;
			e.printStackTrace();
		}
	 return u;
}

public List searchUsar() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	UsarDao Usar= new UsarDao();
        
    try{
    	l=Usar.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}



public boolean addUsar(int codigo_practica, String codigo_material)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Usar u = new Usar(codigo_practica);
	u.setCodigo_practica(codigo_practica);


	// crear el DAO a manipular
	UsarDao Usar = new UsarDao();
	
	try {
		Usar.create(getConnection(),u);
	} catch (SQLException e) {
		add = false;
		e.printStackTrace();
	}
	return add;
}

private Connection getConnection(){
	Connection conn=null;
	try{
        //registrar la clase del driver
        Class.forName("org.postgresql.Driver");
        //obtener el objeto de conexion
        conn=DriverManager.getConnection("jdbc:postgresql://localhost/Proyecto_Brazo","postgres","root");// login=postgres , contraseña=postgres
    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return conn;

}





}
