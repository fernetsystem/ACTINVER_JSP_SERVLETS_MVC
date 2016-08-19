package Models;

import java.util.ArrayList;

public interface MethodsCrud <Anything>{
    
    public int insert(Anything a) throws ControlException;
    public int remove(Object key) throws ControlException;      //el id puede ser un int o String
    public int update(Anything a) throws ControlException;
    public Anything read(Object key) throws ControlException;
    public ArrayList<Anything> readAll() throws ControlException;
    
}
