package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IMaterial;
import persistence.Material;
import persistence.MaterialDao;
import persistence.NotFoundException;



public abstract class Imp_Material extends UnicastRemoteObject  implements IMaterial {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Material() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Material searchMaterial(int codigo_material) throws RemoteException {
	//crear el value object a retornar
	Material u=new Material(codigo_material);	
	//crear los DAO a manipular
	MaterialDao Material= new MaterialDao();
	
    try{
    	Material.load(getConnection(),u);
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

public List searchMaterials() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	MaterialDao Material= new MaterialDao();
        
    try{
    	l=Material.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}

public boolean updateMaterial(int codigo_material, String descripcion, String tipo)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Material u=new Material();
	u.setAll(codigo_material,descripcion,tipo);
	//crear los DAO a manipular
	MaterialDao Material= new MaterialDao();
        
    try{
    	Material.save(getConnection(),u);
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

public boolean delMaterial(int codigo_material) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Material u=new Material(codigo_material);
	//crear los DAO a manipular
	MaterialDao Material= new MaterialDao();
        
    try{
    	Material.delete(getConnection(),u);
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

public boolean addMaterial(int codigo_material, String descripcion, String tipo)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Material u = new Material(codigo_material);
	u.setDescripcion(descripcion);
	u.setTipo(tipo);

	// crear el DAO a manipular
	MaterialDao Material = new MaterialDao();
	
	try {
		Material.create(getConnection(),u);
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
