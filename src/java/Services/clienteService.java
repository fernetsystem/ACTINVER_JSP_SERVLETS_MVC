
package Services;

import Beans.Cliente;
import Models.ClienteImpl;
import Models.ControlException;
import java.util.ArrayList;


public class clienteService {

    ClienteImpl c = new ClienteImpl();
    
    public int insert(Cliente cli)throws ControlException{
        return c.insert(cli);
    }
    
    public ArrayList<Cliente> getAllClients() throws ControlException{
        return c.readAll();
    }
}
