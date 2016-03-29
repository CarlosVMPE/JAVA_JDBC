
package pe.crvm.eurekacs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import pe.crvm.eurekacs.dao.espec.DaoCuentaEspec;
import pe.crvm.eurekacs.db.AccesoDB;

/**
 *
 * @author Alumno
 */
public class DaoCuentaImpl implements DaoCuentaEspec{

    @Override
    public List<Map<String, ?>> conMovimientos(String cuenta) {
        List<Map<String,?>> lista;
        Connection cn = null;
            try {
                cn = AccesoDB.getConnection();
                String sql = "select CUENCODIGO, " 
                        +"MONENOMBRE, CUENSALDO, "
                        +"CUENESTADO, MOVINUMERO, " 
                        +"MOVIFECHA, MOVIIMPORTE, " 
                        +"TIPOCODIGO, TIPONOMBRE "
                        +"from v_movimiento "
                        +"where cuencodigo = ?";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, cuenta);
                ResultSet rs = pstm.executeQuery();
                lista = JdbcUtil.rsToList(rs);
                rs.close();
                pstm.close();
  
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            } catch (Exception e) {
               String mensaje = "Se ha producido un error, intentelo mas tarde.";
            if(e.getMessage() != null && !e.getMessage().isEmpty()){
                mensaje += (" " + e.getMessage());
            }
                throw new RuntimeException(mensaje);
            } finally {
                try {
                cn.close();
                } catch (Exception e) {
                    }
            }
            
          return lista;  
    }
    
}
