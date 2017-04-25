package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import interfaces.IRobot;
import persistence.NotFoundException;
import persistence.Robot;
import persistence.RobotDao;

public class Imp_Robot extends UnicastRemoteObject implements IRobot {
	


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Imp_Robot() throws RemoteException {
	super();
	// TODO Auto-generated constructor stub
}

public Robot searchRobot(int serie) throws RemoteException {
	//crear el value object a retornar
	Robot u=new Robot(serie);	
	//crear los DAO a manipular
	RobotDao Robot= new RobotDao();
	 /* private int serie;
	    private String base;
	    private String hombro;
	    private String codo;
	    private String muneca;
	    private String pinza;*/
    try{
    	Robot.load(getConnection(),u);
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

public List searchRobots() throws RemoteException {
	List l=null;	
	//crear los DAO a manipular
	RobotDao Robot= new RobotDao();
        
    try{
    	l=Robot.loadAll(getConnection());
    	
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
    return l;
}

public boolean updateRobot(int serie, String base, String hombro, String codo,String muneca, String pinza)
		throws RemoteException {
	boolean update=true;
	//crear el value object a actualizar
	Robot u=new Robot();
	u.setAll( serie,  base,  hombro,  codo, muneca,  pinza);
	//crear los DAO a manipular
	RobotDao Robot= new RobotDao();
        
    try{
    	Robot.save(getConnection(),u);
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

public boolean delRobot(int serie) throws RemoteException {
	boolean del=true;
	//crear el value object a eliminar
	Robot u=new Robot(serie);
	//crear los DAO a manipular
	RobotDao Robot= new RobotDao();
        
    try{
    	Robot.delete(getConnection(),u);
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

public boolean addRobot(int serie, String base, String hombro, String codo,String muneca, String pinza)
		throws RemoteException {
	boolean add = true;

	// crear el value object de user
	Robot u = new Robot(serie);
	u.setBase(base);
	u.setCodo(codo);
	u.setHombro(hombro);
	u.setMuneca(muneca);
	u.setPinza(pinza);


	// crear el DAO a manipular
	RobotDao Robot = new RobotDao();
	
	try {
		Robot.create(getConnection(),u);
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
