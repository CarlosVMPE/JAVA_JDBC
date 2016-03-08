
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> readForCriteria(Cliente bean) {
        List<Cliente> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT chr_cliecodigo, vch_cliepaterno, "
                    +"vch_cliematerno, vch_clienombre, vch_cliedni, "
                    +"vch_clieciudad, vch_cliedireccion, vch_clietelefono, "
                    +"vch_clieemail "
                    +"from cliente "
                    +"where vch_cliepaterno like ? "
                    +"and vch_cliematerno like ? "
                    +"and vch_clienombre like ?";
            
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getPaterno() +"%");
            pstm.setString(2, bean.getMaterno()+"%");
            pstm.setString(3, bean.getNombre()+"%");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Cliente cliente = getBean(rs);
                lista.add(cliente);
            }
            
            rs.close();
            pstm.close();
            
        } catch (Exception e) {
        }
    }

    @Override
    public void insert(Cliente bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Cliente getBean(ResultSet rs) throws SQLException {
        Cliente bean = new Cliente();
        bean.setCodigo(rs.getString("chr_cliecodigo"));
        bean.setCodigo(rs.getString("vch_cliepaterno"));
        bean.setCodigo(rs.getString("vch_cliematerno"));
        bean.setCodigo(rs.getString("vch_clienombre"));
        bean.setCodigo(rs.getString("vch_cliedni"));
        bean.setCodigo(rs.getString("vch_clieciudad"));
        bean.setCodigo(rs.getString("vch_cliedireccion"));
        bean.setCodigo(rs.getString("vch_clietelefono"));
        bean.setCodigo(rs.getString("vch_clieemail"));
        return bean;
    }
    
   
    
}
