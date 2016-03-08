
package pe.crvm.eurekacs.view;

import javax.swing.JInternalFrame;
import pe.crvm.eurekacs.domain.Empleado;
import pe.crvm.eurekacs.util.Memoria;


public class FormularioMDI extends javax.swing.JFrame {

    /**
     * Creates new form FormularioMDI
     */
    public FormularioMDI() {
        initComponents();
        establecerTitulo();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void establecerTitulo(){
        String titulo = "EUREKA APP ";
        Empleado emp = (Empleado) Memoria.get("usuario");
        titulo += "[Usuario: " + emp.getUsuario() + "]";
        // titulo += "[BD: " + nombreBD] // Nombre de la BD
        
        this.setTitle(titulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        menuArchivoSalir = new javax.swing.JMenuItem();
        menuProceso = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        menuTabla = new javax.swing.JMenu();
        menuTablaClientes = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        menuReporte = new javax.swing.JMenu();
        menuUtil = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuArchivo.setMnemonic('f');
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        menuArchivo.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        menuArchivo.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        menuArchivo.add(saveAsMenuItem);

        menuArchivoSalir.setMnemonic('x');
        menuArchivoSalir.setText("Salir");
        menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchivoSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuArchivoSalir);

        menuBar.add(menuArchivo);

        menuProceso.setMnemonic('e');
        menuProceso.setText("Proceso");
        menuProceso.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        menuProceso.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        menuProceso.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        menuProceso.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        menuProceso.add(deleteMenuItem);

        menuBar.add(menuProceso);

        menuTabla.setMnemonic('h');
        menuTabla.setText("Tabla");
        menuTabla.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        menuTablaClientes.setText("Clientes");
        menuTablaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablaClientesActionPerformed(evt);
            }
        });
        menuTabla.add(menuTablaClientes);

        menuBar.add(menuTabla);

        menuConsulta.setText("Consulta");
        menuConsulta.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuBar.add(menuConsulta);

        menuReporte.setText("Reporte");
        menuReporte.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuBar.add(menuReporte);

        menuUtil.setText("Util");
        menuUtil.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuBar.add(menuUtil);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuArchivoSalirActionPerformed

    private void menuTablaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablaClientesActionPerformed
        cargarFormulario(MantClientesView.class);
    }//GEN-LAST:event_menuTablaClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuArchivoSalir;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenu menuProceso;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JMenu menuTabla;
    private javax.swing.JMenuItem menuTablaClientes;
    private javax.swing.JMenu menuUtil;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private void cargarFormulario(Class<?> aClass) { // <?> para cargar varios tipos de clase
         try {
            // Variable
             JInternalFrame view = null; 
            // Concepto Divide y venceras
             // Buscar instancia
            view =  buscarInstancia(aClass);
            // Crear instancia, solo si no lo encuentra
            if(view == null){
                // Creara la instancia
                view = (JInternalFrame) Class.forName(aClass.getName()).newInstance(); 
                desktopPane.add(view); // agregando al panel
            }
            // Mostrar Formulario
            view.setVisible(true);
            view.setSelected(true);
             
        } catch (Exception e) {
        }
    }

    private JInternalFrame buscarInstancia(Class<?> aClass) {
        JInternalFrame view = null;
        for(JInternalFrame form: desktopPane.getAllFrames()){ // desktopPane.getAllFrames(): arreglo de objetos
            if(aClass.isInstance(form)){ // aClass == form, 
                view=form;
                break;
            }
        }
        return view; // si nunca lo encuentra
    }
    
}
