
package pe.crvm.eurekacs.service;

import java.util.List;
import pe.crvm.eurekacs.dao.espec.DaoClienteEspec;
import pe.crvm.eurekacs.dao.impl.DaoClienteImpl;
import pe.crvm.eurekacs.domain.Cliente;

public class ClienteService {
    
    private DaoClienteEspec dao;
    
    public ClienteService(){
        dao = new DaoClienteImpl();
    }
    
    public List<Cliente> getClientes(Cliente bean){
        
    } 
}
