
package pe.crvm.eurekacs.service;

// Siempre quien te resuelve los problemas es la clase Service

import pe.crvm.eurekacs.dao.espec.DaoEmpleadoEspec;
import pe.crvm.eurekacs.dao.impl.DaoEmpleadoImpl;
import pe.crvm.eurekacs.domain.Empleado;


public class LogonService {
    
    public Empleado validar(String usuario, String clave){
        Empleado bean = null;
        DaoEmpleadoEspec dao = new DaoEmpleadoImpl();
        bean = dao.validar(usuario, clave);
        return bean;    
    }
    
}
