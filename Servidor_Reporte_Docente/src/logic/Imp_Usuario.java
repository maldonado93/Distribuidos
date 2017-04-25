package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IRobot;
import interfaces.IUsario;
import persistence.NotFoundException;
import persistence.Robot;
import persistence.RobotDao;
import persistence.Usuario;
import persistence.UsuarioDao;

public class Imp_Usuario extends UnicastRemoteObject implements IUsario {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Usuario() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Usuario searchUsuario(int codigo_usuario) throws RemoteException {
	//crear el value object a retornar
	Usuario u=new Usuario(codigo_usuario);	
	//crear los DAO a manipular
	UsuarioDao Usuario= new UsuarioDao();
	 /* private int codigo_usuario;
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String tipo;*/
    try{
    	Usuario.load(getConnection(),u);
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

public List searchUsuarios() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	UsuarioDao Usuario= new UsuarioDao();
        
    try{
    	l=Usuario.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}


public boolean updateUsuario(int codigo_usuario, String id, String nombre, String apellido,String telefono, String email,String tipo)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Usuario u=new Usuario();
	u.setAll( codigo_usuario,  id,  nombre,  apellido, telefono, email,  tipo);
	//crear los DAO a manipular
	UsuarioDao Usuario= new UsuarioDao();
        
    try{
    	Usuario.save(getConnection(),u);
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

public boolean delUsuario(int codigo_usuario) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Usuario u=new Usuario(codigo_usuario);
	//crear los DAO a manipular
	UsuarioDao Usuario= new UsuarioDao();
        
    try{
    	Usuario.delete(getConnection(),u);
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

public boolean addUsuario(int codigo_usuario, String id, String nombre, String apellido,String telefono, String email,String tipo)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Usuario u = new Usuario(codigo_usuario);
	u.setId(id);
	u.setNombre(nombre);
	u.setApellido(apellido);
	u.setTelefono(telefono);
	u.setEmail(email);
	u.setTipo(tipo);
	


	// crear el DAO a manipular
	UsuarioDao Usuario = new UsuarioDao();
	
	try {
		Usuario.create(getConnection(),u);
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
