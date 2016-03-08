
package pe.crvm.prueba;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import pe.crvm.prueba.db.AccesoDB;


public class Prueba02 {
    
    public static void main(String[] args) throws SQLException {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            System.out.println("Conexion Ok");
            String sql = "insert into parametro(CHR_PARACODIGO,"+
                    "VCH_PARADESCRIPCION, VCH_PARAVALOR,"+
                    "VCH_PARAESTADO) values('777','ALUMNO',"+
                    "'CARLOS VILCHEZ M.','ACTIVO')";
                 Statement stm = cn.createStatement();
                 stm.executeUpdate(sql);
                 System.out.println("Parámetro registrado!");
           
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally{
            try {
                
            } catch (Exception e) {
                cn.close();
                System.out.println("Conexion Cerrada");
            }
        }
    }
}
