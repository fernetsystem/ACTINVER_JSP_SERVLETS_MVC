package Models;

import Beans.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuentaImpl implements MethodsCrud<Cuenta> {

    private final String SQL_INSERT = "INSERT INTO cuenta VALUES(NULL,?,?,?);";
    private final String SQL_REMOVE = "DELETE FROM cuenta WHERE idCuenta = ?;";
    private final String SQL_UPDATE = "UPDATE cuente SET idCliente = ?, idSucursal= ?, saldo = ? WHERE idCuenta = ?;";
    private final String SQL_READ = "SELECT * FROM cuenta WHERE idCuenta = ?;";
    private final String SQL_REALALL = "SELECT * FROM  cuenta;";
    private final String SQL_REALDETAIL = "SELECT t1.idCliente, nombre, paterno, materno, estado, t2.idCuenta, saldo, t3.idSucursal, rfc FROM cliente t1 INNER JOIN cuenta t2 ON t1.idCliente = t2.idCliente INNER JOIN sucursal t3 ON t2.idSucursal = t3.idSucursal;";

    Conexion con = Conexion.getInstanceConexion();

    @Override
    public int insert(Cuenta cuenta) throws ControlException {
        PreparedStatement ps;
        int result = 0;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, cuenta.getIdCliente());
            ps.setInt(2, cuenta.getIdSucursal());
            ps.setDouble(3, cuenta.getSaldo());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Cuenta a) throws ControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuenta read(Object key) throws ControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuenta> readAll() throws ControlException {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Cuenta> list = new ArrayList();
        try {
            ps = con.getCnn().prepareCall(SQL_REALALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cuenta c = new Cuenta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuentaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.closeConexion();
        }
        return list;
    }
    
    
}
