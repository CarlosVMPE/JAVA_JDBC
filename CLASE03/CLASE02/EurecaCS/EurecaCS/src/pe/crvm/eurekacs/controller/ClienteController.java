
package pe.crvm.eurekacs.controller;

import java.util.List;
import pe.crvm.eurekacs.domain.Cliente;
import pe.crvm.eurekacs.service.ClienteService;


public class ClienteController {
    private ClienteService service;
    public ClienteController(){
        service = new ClienteService();
    }
   /* 
    public List<Cliente> getClientes(Cliente bean){
        
    }*/
}
