
package Services;

import Beans.Cuenta;
import Models.ControlException;
import Models.CuentaImpl;
import java.util.ArrayList;

public class cuentaService {

    CuentaImpl cuentaImpl = new CuentaImpl();
    
    public int insert(Cuenta cuenta) throws ControlException{
        return cuentaImpl.insert(cuenta);
    }
    
    public ArrayList<Cuenta> getAllCuentas() throws ControlException{
        return cuentaImpl.readAll();
    }
}
