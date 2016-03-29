
package pe.crvm.eurekacs.util;

import java.awt.Component;
import javax.swing.JOptionPane;


public final class Dialogo {
    private Dialogo(){
        
    }
    
   public static void error(Component parent, String message){
       JOptionPane.showMessageDialog(parent, message, 
               "EUREKA ERROR", JOptionPane.ERROR_MESSAGE);
   }
   
   public static void info(Component parent, String message){
       JOptionPane.showMessageDialog(parent, message, 
               "EUREKA INFO", JOptionPane.INFORMATION_MESSAGE);
   }
    
}
