
package pe.crvm.eurekacs.controller;

import java.util.List;
import pe.crvm.eurekacs.domain.Cliente;
import pe.crvm.eurekacs.service.ClienteService;
import pe.crvm.eurekacs.util.Eureka;


public class ClienteController {
    private ClienteService service;
    public ClienteController(){
        service = new ClienteService();
    }
    
    public List<Cliente> getClientes(Cliente bean){
        return service.getClientes(bean);
    }
    
    public List<Cliente> getClientes(){
        return service.getClientes();
    }

    public void grabar(Cliente bean, String accion) {
        switch(accion){
            case Eureka.CRUD_NUEVO:
                service.insert(bean);
                break;
                
            case Eureka.CRUD_EDITAR:
                service.update(bean);
                break;
        
            case Eureka.CRUD_ELIMINAR:
                service.delete(bean);
                break;
        }
    }
    
    
}
