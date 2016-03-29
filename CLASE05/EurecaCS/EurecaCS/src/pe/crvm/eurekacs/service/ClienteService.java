
package pe.crvm.eurekacs.service;

import java.util.List;
import pe.crvm.eurekacs.dao.espec.DaoClienteEspec;
import pe.crvm.eurekacs.dao.impl.DaoClienteImpl;
import pe.crvm.eurekacs.domain.Cliente;
import pe.crvm.eurekacs.util.Dialogo;

public class ClienteService {
    
    private DaoClienteEspec dao;
    
    public ClienteService(){
        dao = new DaoClienteImpl();
    }
    
    public List<Cliente> getClientes(Cliente bean){
        return dao.readForCriteria(bean);
    }
    
    public List<Cliente> getClientes(){
        return dao.readAll();
    } 
    
    public void insert(Cliente bean){
        dao.insert(bean);
    }
    
    public void update(Cliente bean) {
     dao.update(bean);
      Dialogo.info(null, "Cliente actualizado correctamente!");
  }

  public void delete(Cliente bean) {
    dao.delete(bean.getCodigo());
      Dialogo.info(null, "Cliente eliminado correctamente!");
  }
}
