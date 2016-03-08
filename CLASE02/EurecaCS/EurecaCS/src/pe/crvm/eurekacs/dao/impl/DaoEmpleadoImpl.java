
package pe.crvm.eurekacs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.crvm.eurekacs.dao.espec.DaoEmpleadoEspec;
import pe.crvm.eurekacs.db.AccesoDB;
import pe.crvm.eurekacs.domain.Empleado;


public class DaoEmpleadoImpl implements DaoEmpleadoEspec{

    @Override
    public Empleado validar(String usuario, String clave) {
        Empleado empleado = null;
        Connection cn = null;
       try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT chr_emplcodigo, vch_emplpaterno, "
                    +"vch_emplmaterno, vch_emplnombre, vch_emplciudad, "
                    +"vch_empldireccion, vch_emplusuario, vch_emplclave "
                    +"from empleado "
                    +"where vch_emplusuario = ? "
                    +"and vch_emplclave = ?";
            
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                empleado = getBean(rs);
            }
            
            rs.close();
            pstm.close();
            
  
       } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
       } catch(Exception e1){
            String mensaje = "Se ha producido un error, intentalo mas tarde";
            if(e1.getMessage() != null && !e1.getMessage().isEmpty()){
                mensaje += (" "+ e1.getMessage());
        }
        throw new RuntimeException(mensaje);
        } 
        finally {
            try {
                cn.close();
            } catch (Exception e) {
        } 
        }
  
       return empleado;
}
    @Override
    public Empleado readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> readForCriteria(Empleado bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Empleado bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Empleado bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Empleado getBean(ResultSet rs) throws SQLException {
         Empleado bean = new Empleado();
         bean.setCodigo(rs.getString("chr_emplcodigo"));
         bean.setPaterno(rs.getString("vch_emplpaterno"));
         bean.setMaterno(rs.getString("vch_emplmaterno"));
         bean.setNombre(rs.getString("vch_emplnombre"));
         bean.setCiudad(rs.getString("vch_emplciudad"));
         bean.setDireccion(rs.getString("vch_empldireccion"));
         bean.setUsuario(rs.getString("vch_emplusuario"));
         
         return bean;
    }
    
    
    
}
