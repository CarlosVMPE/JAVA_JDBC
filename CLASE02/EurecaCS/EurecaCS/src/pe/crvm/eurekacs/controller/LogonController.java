
package pe.crvm.eurekacs.controller;

import pe.crvm.eurekacs.domain.Empleado;
import pe.crvm.eurekacs.service.LogonService;
import pe.crvm.eurekacs.util.Memoria;

public class LogonController {
    public void valirdar(String usuario, String clave){
        LogonService service = new LogonService();
        Empleado empleado = service.validar(usuario, clave);
            if(empleado == null){
                throw new RuntimeException("Datos incorrectos");
            } else{
                Memoria.put("usuario", empleado);
            }
    }
}
