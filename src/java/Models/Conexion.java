package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public static Conexion instance;
    private Connection cnn;
    
    private Conexion(){       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.gjt.mm.mysql.Driver");            
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/actinver","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //FORZOCZAMENTE TIENE QUE SER ESTATICO EL METODO, SYN ES POR SI VARIOS USUARIOS SE CONECTAN AL MIMO
    //TIEMPO CREA UNA LISTA DE ESPERA HASTE, EL USUARIO PODRA REALIZAR SU OPERACIO CUNAO OTRO ACABE
    public synchronized static Conexion getInstanceConexion(){
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getCnn(){
        return cnn;
    }
    
    public void closeConexion(){
        instance = null;
    }
}
