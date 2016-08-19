
package Services;

import Beans.Sucursal;
import Models.ControlException;
import Models.SucursalImpl;
import java.util.ArrayList;

public class sucursalService {

    
    SucursalImpl s = new SucursalImpl();
    
    public int insert(Sucursal suc)throws ControlException{
        return s.insert(suc);
    }
    
    public Sucursal searchById(int id)throws ControlException{
        return s.read(id);
    }
    
    public ArrayList<Sucursal> getAllSucursal()throws ControlException{
        return s.readAll();
    }
       
}
