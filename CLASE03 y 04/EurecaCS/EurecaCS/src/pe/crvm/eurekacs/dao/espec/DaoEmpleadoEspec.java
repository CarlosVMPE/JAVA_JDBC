
package pe.crvm.eurekacs.dao.espec;

import pe.crvm.eurekacs.domain.Empleado;


public interface DaoEmpleadoEspec extends DaoCrudEspec<Empleado>{
    
    
    Empleado validar(String usuario, String clave);
}
