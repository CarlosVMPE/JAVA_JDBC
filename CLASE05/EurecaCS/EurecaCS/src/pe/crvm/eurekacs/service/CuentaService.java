
package pe.crvm.eurekacs.service;

import java.util.List;
import java.util.Map;
import pe.crvm.eurekacs.dao.espec.DaoCuentaEspec;
import pe.crvm.eurekacs.dao.impl.DaoCuentaImpl;

/**
 *
 * @author Alumno
 */
public class CuentaService {
    
    private DaoCuentaEspec daoCuenta;

    public CuentaService() {
        daoCuenta = new DaoCuentaImpl();
    }
    
    
    
    public List<Map<String,?>> traerMovimientos(String cuenta){
        return daoCuenta.conMovimientos(cuenta);
    }
}
