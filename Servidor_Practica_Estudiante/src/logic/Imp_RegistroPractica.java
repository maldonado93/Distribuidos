package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IRegristroPractica;
import interfaces.IRobot;
import persistence.NotFoundException;
import persistence.Registro_practica;
import persistence.Registro_practicaDao;
import persistence.Robot;
import persistence.RobotDao;

public class Imp_RegistroPractica extends UnicastRemoteObject implements IRegristroPractica {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_RegistroPractica() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Registro_practica searchRegistro_practica(int codigo_registro) throws RemoteException {
	//crear el value object a retornar
	Registro_practica u=new Registro_practica(codigo_registro);	
	//crear los DAO a manipular
	Registro_practicaDao Registro_practica= new Registro_practicaDao();
	 /*  private int codigo_registro;
    private String codigo_practica;
    private String codigo_usuario;
    private String fecha;
    private String hora_inicio;
    private String hora_fin;
*/
    try{
    	Registro_practica.load(getConnection(),u);
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

public List searchRegistro_practicas() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	Registro_practicaDao Registro_practica= new Registro_practicaDao();
        
    try{
    	l=Registro_practica.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}



public boolean updateRegistro_practica(int codigo_registro, String codigo_practica, String codigo_usuario, String fecha,String hora_inicio, String hora_fin)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Registro_practica u=new Registro_practica();
	u.setAll( codigo_registro,  codigo_practica,  codigo_usuario,  fecha, hora_inicio,  hora_fin);
	//crear los DAO a manipular
	Registro_practicaDao Registro_practica= new Registro_practicaDao();
        
    try{
    	Registro_practica.save(getConnection(),u);
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

public boolean delRegistro_practica(int codigo_registro) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Registro_practica u=new Registro_practica(codigo_registro);
	//crear los DAO a manipular
	Registro_practicaDao Registro_practica= new Registro_practicaDao();
        
    try{
    	Registro_practica.delete(getConnection(),u);
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

public boolean addRegistro_practica(int codigo_registro, String codigo_practica, String codigo_usuario, String fecha,String hora_inicio, String hora_fin)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Registro_practica u = new Registro_practica(codigo_registro);
	u.setCodigo_practica(codigo_practica);
	u.setCodigo_usuario(codigo_usuario);
	u.setFecha(fecha);
	u.setHora_inicio(hora_inicio);
	u.setHora_fin(hora_fin);
	


	// crear el DAO a manipular
	Registro_practicaDao Registro_practica = new Registro_practicaDao();
	
	try {
		Registro_practica.create(getConnection(),u);
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
