

package prociencia2.views.frames;

import javax.swing.JToggleButton;
import prociencia2.controllers.listenerLogic.ChangedOperacionListener;
import prociencia2.views.componets.PJToolBar;
import prociencia2.controllers.listeners.MouseMoveListener;
import prociencia2.logic.core.daos.WriteWorkConnection;
import prociencia2.logic.model.ControlModel;
import prociencia2.logic.model.User;
import prociencia2.views.componets.alerts.FactoryMessage;
import prociencia2.views.dialogs.DialogChangeModoUser;
import prociencia2.views.dialogs.DialogChangedTutor;
import prociencia2.views.panels.PanelExtratorStudent;
/**
 *
 * @author Klac
 */
public class MainFrame extends javax.swing.JFrame {

    private final ControlModel logica;
    private final ChangedOperacionListener CHANGED_LISTENER = new ChangedOperacionListener(this);
    public MainFrame(ControlModel logica) {
        super("Test de Intereses Profesionales y Aptitudes - TestLine");
        this.logica = logica;
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("iconTest64.png")));
        initComponents();
        logica.setPanelWork(jPanelWork);
    }

    public void updateViewTest(boolean isViewTest){
        jPanelOperation.setVisible(!isViewTest);
        jToggleButtonRealizaTest.setEnabled(isViewTest);
        jToggleButtonRegistro.setEnabled(!isViewTest);
    }

    public JToggleButton getjToggleButtonRealizaTest() {
        return jToggleButtonRealizaTest;
    }

    public JToggleButton getjToggleButtonRegistro() {
        return jToggleButtonRegistro;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jToolBarHerra = new PJToolBar(this);
        jPanelOperation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButtonRegistro = new javax.swing.JToggleButton();
        jToggleButtonRealizaTest = new javax.swing.JToggleButton();
        jPanelWork = new javax.swing.JPanel();
        aBarMenu = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemModoConexion = new javax.swing.JMenuItem();
        jMenuItemOpenFolder = new javax.swing.JMenuItem();
        jMenuItemModoNormal = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemImportar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jToolBarHerra, java.awt.BorderLayout.PAGE_START);

        jPanelOperation.setBackground(new java.awt.Color(255, 255, 255));
        jPanelOperation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelOperation.setMaximumSize(new java.awt.Dimension(230, 32767));
        jPanelOperation.setMinimumSize(new java.awt.Dimension(230, 0));
        jPanelOperation.setPreferredSize(new java.awt.Dimension(230, 447));

        jLabel1.setBackground(jPanelOperation.getBackground());
        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   Test");

        jToggleButtonRegistro.setBackground(new java.awt.Color(255, 255, 255));
        grupo.add(jToggleButtonRegistro);
        jToggleButtonRegistro.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jToggleButtonRegistro.setForeground(new java.awt.Color(153, 153, 153));
        jToggleButtonRegistro.setText("  Formulario de Registro");
        jToggleButtonRegistro.setBorder(null);
        jToggleButtonRegistro.setBorderPainted(false);
        jToggleButtonRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonRegistro.setFocusPainted(false);
        jToggleButtonRegistro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButtonRegistro.addItemListener(CHANGED_LISTENER);

        jToggleButtonRealizaTest.setBackground(jPanelOperation.getBackground());
        grupo.add(jToggleButtonRealizaTest);
        jToggleButtonRealizaTest.setFont(jToggleButtonRegistro.getFont());
        jToggleButtonRealizaTest.setForeground(jToggleButtonRegistro.getForeground());
        jToggleButtonRealizaTest.setText("  Realizar Test");
        jToggleButtonRealizaTest.setBorder(null);
        jToggleButtonRealizaTest.setBorderPainted(false);
        jToggleButtonRealizaTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonRealizaTest.setEnabled(false);
        jToggleButtonRealizaTest.setFocusPainted(false);
        jToggleButtonRealizaTest.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButtonRealizaTest.addItemListener(CHANGED_LISTENER);

        javax.swing.GroupLayout jPanelOperationLayout = new javax.swing.GroupLayout(jPanelOperation);
        jPanelOperation.setLayout(jPanelOperationLayout);
        jPanelOperationLayout.setHorizontalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonRealizaTest, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelOperationLayout.setVerticalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jToggleButtonRealizaTest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jToggleButtonRegistro.addMouseListener(new MouseMoveListener());
        jToggleButtonRealizaTest.addMouseListener(new MouseMoveListener());

        getContentPane().add(jPanelOperation, java.awt.BorderLayout.WEST);

        jPanelWork.setBackground(new java.awt.Color(255, 255, 255));
        jPanelWork.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelWork, java.awt.BorderLayout.CENTER);

        aBarMenu.setBackground(new java.awt.Color(255, 255, 255));
        aBarMenu.setBorder(null);
        aBarMenu.setForeground(new java.awt.Color(102, 102, 102));

        jMenuArchivo.setBackground(new java.awt.Color(255, 255, 255));
        jMenuArchivo.setForeground(new java.awt.Color(51, 51, 51));
        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItemModoConexion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemModoConexion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItemModoConexion.setText("Trabajar sin conexion");
        jMenuItemModoConexion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItemModoConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModoConexionActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemModoConexion);

        jMenuItemOpenFolder.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItemOpenFolder.setFont(jMenuItemModoConexion.getFont());
        jMenuItemOpenFolder.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItemOpenFolder.setText("Abrir Carpeta");
        jMenuItemOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFolderActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemOpenFolder);

        jMenuItemModoNormal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemModoNormal.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItemModoNormal.setFont(jMenuItemModoConexion.getFont());
        jMenuItemModoNormal.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItemModoNormal.setText("Cerrar modo administrador");
        jMenuItemModoNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModoNormalActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemModoNormal);
        jMenuArchivo.add(jSeparator1);

        jMenuItemImportar.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItemImportar.setFont(jMenuItemModoConexion.getFont());
        jMenuItemImportar.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItemImportar.setText("Importar Estudiantes...");
        jMenuItemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemImportar);
        jMenuArchivo.add(jSeparator2);

        jMenuItemSalir.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItemSalir.setFont(jMenuItemModoConexion.getFont());
        jMenuItemSalir.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        aBarMenu.add(jMenuArchivo);

        jMenuConfiguracion.setBackground(jMenuArchivo.getBackground());
        jMenuConfiguracion.setForeground(jMenuArchivo.getForeground());
        jMenuConfiguracion.setText("Configuración");
        jMenuConfiguracion.setFont(jMenuArchivo.getFont());

        jMenuItem1.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem1.setFont(jMenuItemModoConexion.getFont());
        jMenuItem1.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem1.setText("Configuración de Administrador...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuItem1);

        jMenuItem3.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem3.setFont(jMenuItemModoConexion.getFont());
        jMenuItem3.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem3.setText("Configuración de Tutor...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuItem3);

        aBarMenu.add(jMenuConfiguracion);

        jMenuAyuda.setBackground(jMenuArchivo.getBackground());
        jMenuAyuda.setForeground(jMenuArchivo.getForeground());
        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setFont(jMenuArchivo.getFont());
        jMenuAyuda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem2.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem2.setFont(jMenuItemModoConexion.getFont());
        jMenuItem2.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem2.setText("Acerca de...");
        jMenuAyuda.add(jMenuItem2);

        aBarMenu.add(jMenuAyuda);

        setJMenuBar(aBarMenu);
        updateModoUser();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemModoConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModoConexionActionPerformed
        jMenuItemModoConexion.setEnabled(false);
        ControlModel.setWorkConnection(true);
        java.io.File carpeta = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba Aptitudes & Intereses");
        if(!carpeta.exists()){
            if(carpeta.mkdirs())
            FactoryMessage.createMessageInformation(MainFrame.class, "information1");
            else
            FactoryMessage.createMessageAlert(MainFrame.class,"alert1");
        }else{
            FactoryMessage.createMessageInformation(MainFrame.class, "information1");
        }
    }//GEN-LAST:event_jMenuItemModoConexionActionPerformed

    private void jMenuItemOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFolderActionPerformed
        java.io.File carpeta = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba Aptitudes & Intereses");
        try {
            if(!carpeta.exists())
            carpeta.mkdirs();
            Runtime.getRuntime().exec("explorer.exe "+carpeta.getAbsolutePath());
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            FactoryMessage.createMessageAlert(ex);
        }
    }//GEN-LAST:event_jMenuItemOpenFolderActionPerformed

    private void jMenuItemModoNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModoNormalActionPerformed
        ControlModel.setSesion(User.ESTUDIANTE);
        logica.closeSessionAdministrador(this);
        updateModoUser();
    }//GEN-LAST:event_jMenuItemModoNormalActionPerformed

    private void jMenuItemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarActionPerformed
        final Runnable run = new Runnable(){
            @Override
            public void run(){
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Estudiantes","stud"));
                if(fileChooser.showOpenDialog(MainFrame.this) == javax.swing.JFileChooser.OPEN_DIALOG){
                    PanelExtratorStudent panel;
                    try{
                        panel = new PanelExtratorStudent(WriteWorkConnection.ReaderWorkConnection.getListEstudiante(fileChooser.getSelectedFiles()),fileChooser.getSelectedFiles());
                        logica.establacerPanelActual(panel);
                    }catch(Exception ex){
                        javax.swing.JOptionPane.showMessageDialog(MainFrame.this, ""
                            + "Ooops! ha ocurrido un error al tratar de leer\n"
                            + "el archivo seleccionado","Error de Lectura",javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        javax.swing.SwingUtilities.invokeLater(run);
    }//GEN-LAST:event_jMenuItemImportarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
//        deleteFilePass();
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                DialogChangeModoUser dialogo = new DialogChangeModoUser(MainFrame.this);
                dialogo.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                DialogChangedTutor dialog = new DialogChangedTutor();
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    public void updateModoUser(){
        switch(ControlModel.getSesion()){
            case ESTUDIANTE:{
                jMenuItemModoConexion.setVisible(false);
                jMenuItemOpenFolder.setVisible(false);
                jMenuItemModoNormal.setVisible(false);
                jMenuItemImportar.setVisible(false);
                jMenuConfiguracion.setVisible(false);
                ((PJToolBar)jToolBarHerra).getStartSesion().setEnabled(true);
                break;
            }
            case ADMINISTRADOR:{
                jMenuItemModoConexion.setVisible(false);
                jMenuItemOpenFolder.setVisible(false);
                jMenuItemModoNormal.setVisible(true);
                jMenuItemImportar.setVisible(true);
                jMenuConfiguracion.setVisible(true);
                ((PJToolBar)jToolBarHerra).getStartSesion().setEnabled(false);
                break;
            }
            case TUTOR:{
                jMenuItemModoConexion.setVisible(true);
                jMenuItemOpenFolder.setVisible(true);
                jMenuItemModoNormal.setVisible(false);
                jMenuItemImportar.setVisible(false);
                jMenuConfiguracion.setVisible(false);
                ((PJToolBar)jToolBarHerra).getStartSesion().setEnabled(true);
                break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar aBarMenu;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemImportar;
    private javax.swing.JMenuItem jMenuItemModoConexion;
    private javax.swing.JMenuItem jMenuItemModoNormal;
    private javax.swing.JMenuItem jMenuItemOpenFolder;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JPanel jPanelWork;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToggleButton jToggleButtonRealizaTest;
    private javax.swing.JToggleButton jToggleButtonRegistro;
    private javax.swing.JToolBar jToolBarHerra;
    // End of variables declaration//GEN-END:variables
}
