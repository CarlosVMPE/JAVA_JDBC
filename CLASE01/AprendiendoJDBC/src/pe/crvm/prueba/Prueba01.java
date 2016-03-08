
package pe.crvm.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Prueba01 {
        public static void main(String[] args) throws SQLException {
        
        Connection cn = null;
        try {
            // --------------------------------------------------
            // Paso 1: Cargar el driver a memoria
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            // Paso 2: Obtener el objeto Connection
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            cn = DriverManager.getConnection(url, "eureka", "admin");
            // --------------------------------------------------
            System.out.println("Conexion ok");
            cn.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
           // throw e;
            System.out.println("Error: "+e.getMessage());
        } catch(ClassNotFoundException e){
            System.out.println("No se encontró el driver de la base de datos.");
        } catch(Exception e){
            System.out.println("No se puede establecer la conexión con la base de datos.");
        }
        
    
}
}
