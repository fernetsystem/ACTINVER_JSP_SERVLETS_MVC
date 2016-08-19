package Models;

import Beans.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteImpl implements MethodsCrud<Cliente>{

    private static final String SQL_INSERT = "INSERT INTO cliente VALUES(null,?,?,?,?,?);";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idCliente = ?;";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, paterno = ?, materno = ?, sexo = ?, estado = ? where idCliente = ?;";       
    private static final String SQl_READ = "SELECT * FROM cliente WHERE idCliente = ?;";
    private static final String SQL_READALL = "SELECT * FROM cliente;";
                                
    
    Conexion con = Conexion.getInstanceConexion();
    
    @Override
    public int insert(Cliente cli) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getPaterno());
            ps.setString(3, cli.getMaterno());
            ps.setBoolean(4, cli.isSexo());
            ps.setString(5, cli.getEstado());
            result = ps.executeUpdate();          

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        return result;
    }

    @Override
    public int remove(Object key) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {

            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setObject(1, key);

            result = ps.executeUpdate();
            con.closeConexion();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        return result;
    }

    @Override
    public int update(Cliente cli) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getPaterno());
            ps.setString(3, cli.getMaterno());
            ps.setBoolean(4, cli.isSexo());
            ps.setString(5, cli.getEstado());
            ps.setInt(6, cli.getIdCliente());

            result = ps.executeUpdate();
            con.closeConexion();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.closeConexion();
        }
        return result;
    }

    @Override
    public Cliente read(Object key) throws ControlException {
        PreparedStatement ps;
        ResultSet rs;
        Cliente cli = null;
        
        try {
            ps = con.getCnn().prepareStatement(SQl_READ);
            ps.setObject(1, key);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                cli = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getString(6));
            }
            
            return cli;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.closeConexion();
        }
        return cli;
    }

    @Override
    public ArrayList<Cliente> readAll() throws ControlException {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        
        
        try {
            ps = con.getCnn().prepareStatement(SQL_READALL);                                                         
            rs = ps.executeQuery();
            
            while (rs.next()) {                
              Cliente  cli = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getString(6));
              clientes.add(cli);
            }                        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.closeConexion();
        }
        
        return clientes;
    }
    
}
