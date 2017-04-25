package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.ICinematica;
import interfaces.IRobot;
import persistence.Cinematicas;
import persistence.CinematicasDao;
import persistence.NotFoundException;
import persistence.Robot;
import persistence.RobotDao;

public class Imp_Cinematica extends UnicastRemoteObject implements ICinematica {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Cinematica() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Cinematicas searchCinematica(int codigo_cinematica) throws RemoteException {
	//crear el value object a retornar
	Cinematicas u=new Cinematicas(codigo_cinematica);	
	//crear los DAO a manipular
	CinematicasDao Cinematicas= new CinematicasDao();
	 /*   
	  * private int codigo_cinematica;
    private String codigo_registro;
    private String codigo_practica;
    private String codigo_usuario;
    private String base;
    private String hombro;
    private String codo;
    private String muneca;
    private String pinza;*/
    try{
    	Cinematicas.load(getConnection(),u);
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

public List searchCinematicas() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	CinematicasDao Cinematicas= new CinematicasDao();
        
    try{
    	l=Cinematicas.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}



public boolean updateCinematicas(int codigo_cinematica, String codigo_registro, String codigo_practica, String codigo_usuario,String base, String hombro,String codo,String muneca,String pinza)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Cinematicas u=new Cinematicas();
	u.setAll(  codigo_cinematica,  codigo_registro,  codigo_practica,  codigo_usuario, base,  hombro, codo, muneca, pinza);
	//crear los DAO a manipular
	CinematicasDao Cinematicas= new CinematicasDao();
        
    try{
    	Cinematicas.save(getConnection(),u);
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

public boolean delCinematicas(int codigo_cinematica) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Cinematicas u=new Cinematicas(codigo_cinematica);
	//crear los DAO a manipular
	CinematicasDao Cinematicas= new CinematicasDao();
        
    try{
    	Cinematicas.delete(getConnection(),u);
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

public boolean addCinematicas(int codigo_cinematica, String codigo_registro, String codigo_practica, String codigo_usuario,String base, String hombro,String codo,String muneca,String pinza)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Cinematicas u = new Cinematicas(codigo_cinematica);
	u.setCodigo_registro(codigo_registro);
	u.setCodigo_practica(codigo_practica);
	u.setCodigo_usuario(codigo_usuario);
	u.setHombro(hombro);
	u.setCodo(codo);
	u.setMuneca(muneca);
	u.setPinza(pinza);


	// crear el DAO a manipular
	CinematicasDao Cinematicas = new CinematicasDao();
	
	try {
		Cinematicas.create(getConnection(),u);
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
