package Models;

import Beans.Sucursal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalImpl implements MethodsCrud<Sucursal>{
    
    private static final String SQL_INSERT = "INSERT INTO sucursal VALUES(null,?,?,?,?);";
    private static final String SQL_DELETE = "DELETE FROM sucursal WHERE idSucursal = ?;";
    private static final String SQL_UPDATE = "UPDATE sucursal SET RFC = ?, unbicacion = ?, nombreDelGerente = ?,  telefono = ? where idSucursal = ?;";       
    private static final String SQl_READ = "SELECT * FROM sucursal WHERE idSucursal = ?;";
    private static final String SQL_READALL = "SELECT * FROM sucursal;";
                                
    Conexion con = Conexion.getInstanceConexion();

    @Override
    public int insert(Sucursal suc) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, suc.getRFC());
            ps.setString(2, suc.getUbicacion());
            ps.setString(3, suc.getNombreDelGerente());
            ps.setString(4, suc.getTelefono());

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
            
            ps = con.getCnn().prepareCall(SQL_DELETE);
            ps.setObject(1, key);
            
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        
        return result;
    }

    @Override
    public int update(Sucursal suc) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, suc.getRFC());
            ps.setString(2, suc.getUbicacion());
            ps.setString(3, suc.getNombreDelGerente());
            ps.setString(4, suc.getTelefono());
            ps.setInt(5, suc.getIdSucursal());

            result = ps.executeUpdate();          

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        return result;
    }

    @Override
    public Sucursal read(Object key) throws ControlException {
        PreparedStatement ps;
        ResultSet rs;
         Sucursal suc = null;
        try {
            ps = con.getCnn().prepareStatement(SQl_READ);        
            ps.setObject(1, key);
            rs = ps.executeQuery();            
            
            while (rs.next()) {                
                suc = new Sucursal(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
            }
            
            return suc;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        return suc;
    }

    @Override
    public ArrayList<Sucursal> readAll() throws ControlException {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Sucursal> lista = new ArrayList();
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_READALL);                
            rs = ps.executeQuery();            
            
            while (rs.next()) {                
               Sucursal suc = new Sucursal(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
               lista.add(suc);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            con.closeConexion();
        }
        return lista;
    }
    
    
}
