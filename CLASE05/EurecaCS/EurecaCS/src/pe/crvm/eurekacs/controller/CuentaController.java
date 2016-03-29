
package pe.crvm.eurekacs.controller;

import java.util.List;
import java.util.Map;
import pe.crvm.eurekacs.service.CuentaService;

/**
 *
 * @author Alumno
 */
public class CuentaController {
    private CuentaService cuentaService;

    public CuentaController() {
        cuentaService = new CuentaService();
    }
    
    public List<Map<String,?>> traerMovimientos(String cuenta){
        return cuentaService.traerMovimientos(cuenta);
    }
    
}
