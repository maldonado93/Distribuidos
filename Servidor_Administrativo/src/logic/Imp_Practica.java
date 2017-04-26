package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IPractica;
import persistence.NotFoundException;
import persistence.Practica;
import persistence.PracticaDao;



public class Imp_Practica extends UnicastRemoteObject implements IPractica {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Practica() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Practica searchPractica(int codigo_practica) throws RemoteException {
	//crear el value object a retornar
	Practica u=new Practica(codigo_practica);	
	//crear los DAO a manipular
	PracticaDao Practica= new PracticaDao();
	 /* private int codigo_practica;
    private String serie;
    private String titulo;
    private String descripcion;*/
    try{
    	Practica.load(getConnection(),u);
    }
    catch(SQLException e){
    	u=null;
    	e.printStackTrace();
    } catch (NotFoundException e) {
		u=null;
		e.printStackTrace();
	}
    return u;
}

public List searchPracticas() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	PracticaDao Practica= new PracticaDao();
        
    try{
    	l=Practica.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}

public boolean updatePractica(int codigo_practica, String serie, String titulo, String descripcion)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Practica u=new Practica();
	u.setAll( codigo_practica,  serie,  titulo,  descripcion);
	//crear los DAO a manipular
	PracticaDao Practica= new PracticaDao();
        
    try{
    	Practica.save(getConnection(),u);
    }
    catch(SQLException e){
    	update=false;
    	e.printStackTrace();	
    } catch (NotFoundException e) {
		// TODO Auto-generated catch block
    	update=false;
    	e.printStackTrace();
		
	}
    return update;
}

public boolean delPractica(int codigo_practica) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Practica u=new Practica(codigo_practica);
	//crear los DAO a manipular
	PracticaDao Practica= new PracticaDao();
        
    try{
    	Practica.delete(getConnection(),u);
    }
    catch(SQLException e){
    	del=false;
    	e.printStackTrace();
    } catch (NotFoundException e) {
		// TODO Auto-generated catch block
    	del=false;
    	e.printStackTrace();
	}
    return del;
}

public boolean addPractica(int codigo_practica, String serie, String titulo, String descripcion)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Practica u = new Practica(codigo_practica);
	u.setSerie(serie);
	u.setTitulo(titulo);
	u.setDescripcion(descripcion);
	


	// crear el DAO a manipular
	PracticaDao Practica = new PracticaDao();
	
	try {
		Practica.create(getConnection(),u);
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
