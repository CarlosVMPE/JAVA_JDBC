
package pe.crvm.eurekacs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.crvm.eurekacs.dao.espec.DaoClienteEspec;
import pe.crvm.eurekacs.db.AccesoDB;
import pe.crvm.eurekacs.domain.Cliente;


public class DaoClienteImpl implements DaoClienteEspec{

    @Override
    public Cliente readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, vch_clieemail "
              + "from cliente ";
             
            
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente cliente = getBean(rs);
                lista.add(cliente);
            }
            
            rs.close();
            pstm.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            String mensaje = " Se ha producito un error, intentelo mas tarde.";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
            mensaje += (" " + e.getMessage());
            }
            throw new RuntimeException(mensaje);
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
              }
          }
        
        return lista;
    }

    @Override
    public List<Cliente> readForCriteria(Cliente bean) {
        List<Cliente> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, vch_clieemail "
              + "from cliente "
              + "where vch_cliepaterno like ? "
              + "and vch_cliematerno like ? "
              + "and vch_clienombre like ?";
            
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getPaterno() +"%");
            pstm.setString(2, bean.getMaterno()+"%");
            pstm.setString(3, bean.getNombre()+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente cliente = getBean(rs);
                lista.add(cliente);
            }
            
            rs.close();
            pstm.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            String mensaje = " Se ha producito un error, intentelo mas tarde.";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
            mensaje += (" " + e.getMessage());
            }
            throw new RuntimeException(mensaje);
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
              }
          }
        
        return lista;
    }

    @Override
    public void insert(Cliente bean) {
        Connection cn = null;
        try{
            //Acceso al objecto Connection
            cn = AccesoDB.getConnection();
            //Inicia Tx
            cn.setAutoCommit(false);
            // Incrementar el contador
            String sql = "update contador " +
                        "set int_contitem  = int_contitem + 1 " +
                        "where vch_conttabla  = 'Cliente' ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            int filas = pstm.executeUpdate();
            pstm.close();
            if (filas == 0){
                throw new Exception("Contador no existe.");
            }
            
            // Leer contador
            sql =   "select int_contitem, int_contlongitud "
                    + "from contador "
                    + "where vch_conttabla = 'Cliente' ";
            pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int cont = rs.getInt("int_contitem");
            int size = rs.getInt("int_contlongitud");
            
            // Crear Codigo
            
            String formato = "%1$0" + size + "d";
            String codigo = String.format(formato,cont);
            
            // Insertar Cliente
            sql = "insert into cliente(chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, vch_clieemail) "
              + "values(?,?,?,?,?,?,?,?,?)";
            
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, codigo);
            pstm.setString(2, bean.getPaterno());
            pstm.setString(3, bean.getMaterno());
            pstm.setString(4, bean.getNombre());
            pstm.setString(5, bean.getDni());
            pstm.setString(6, bean.getCiudad());
            pstm.setString(7, bean.getDireccion());
            pstm.setString(8, bean.getTelefono());
            pstm.setString(9, bean.getEmail());
            pstm.executeUpdate();
            pstm.close();
            
            bean.setCodigo(codigo);
            ////////////////////////////////
            
            //Confirma Tx
            cn.commit();
            
        }catch(Exception e){
            try{
                cn.rollback();
            }catch(Exception e1){
                
            }
            String mensaje = "Error en el Proceso.";
            if(e.getMessage() !=  null && !e.getMessage().isEmpty() ){
                mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        }finally{
            try {
                cn.close();
            } catch (Exception e) {
              }
          }
    }

    @Override
    public void update(Cliente bean) {
        Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false); // Inicia la Tx
      String sql = "update cliente set  vch_cliepaterno = ?, "
              + "vch_cliematerno = ?, vch_clienombre = ?, "
              + "chr_cliedni = ?, vch_clieciudad = ?, "
              + "vch_cliedireccion = ?, vch_clietelefono = ?, "
              + "vch_clieemail = ? "
              + "where chr_cliecodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getPaterno());
      pstm.setString(2, bean.getMaterno());
      pstm.setString(3, bean.getNombre());
      pstm.setString(4, bean.getDni());
      pstm.setString(5, bean.getCiudad());
      pstm.setString(6, bean.getDireccion());
      pstm.setString(7, bean.getTelefono());
      pstm.setString(8, bean.getEmail());
      pstm.setString(9, bean.getCodigo());
      pstm.executeUpdate();
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    }

    @Override
    public void delete(String codigo) {
        Connection cn = null;
        try {
                cn = AccesoDB.getConnection();
                cn.setAutoCommit(false); // Inicia la Tx
                String sql = "DELETE FROM cliente WHERE chr_cliecodigo= ?";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, codigo);
                pstm.executeQuery();
      
                cn.commit();
        } catch (SQLException e) {
            try {
                    cn.rollback();
            } catch (Exception e1) {
              }
        throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
            cn.rollback();
        } catch (Exception e1) {
        }
      throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    private Cliente getBean(ResultSet rs) throws SQLException {
    Cliente bean = new Cliente();
    bean.setCodigo(rs.getString("chr_cliecodigo"));
    bean.setPaterno(rs.getString("vch_cliepaterno"));
    bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("vch_clienombre"));
    bean.setDni(rs.getString("chr_cliedni"));
    bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("vch_cliedireccion"));
    bean.setTelefono(rs.getString("vch_clietelefono"));
    bean.setEmail(rs.getString("vch_clieemail"));
    return bean;
  }
    
    
    
   
    
}
