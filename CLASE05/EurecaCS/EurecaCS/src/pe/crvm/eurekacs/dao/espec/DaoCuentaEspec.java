
package pe.crvm.eurekacs.dao.espec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Alumno
 */
public interface DaoCuentaEspec {
    
    List<Map<String,?>> conMovimientos(String cuenta);
}
