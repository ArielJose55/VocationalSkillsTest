
package prociencia2.views.panels;
import prociencia2.logic.core.entities.OcupacionEnum;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.model.ControlModel;
import prociencia2.views.componets.PJTextField;
import prociencia2.views.dialogs.DialogConfirmar;
import prociencia2.views.frames.MainFrame;
/**
 *
 * @author Klac
 */
public class PanelRegistroEstudiante extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final ControlModel logica = ControlModel.getInstance();
    
    private final java.util.ResourceBundle RB =
            java.util.ResourceBundle.getBundle(PanelRegistroEstudiante.class.getPackage().getName()+".properties.PropertiesRegistro");
    
    private OcupacionEnum ocupacion = OcupacionEnum.ESTUDIANTE;
    private PanelValidador panelOCupacionView = new PanelCaseEstudiante(RB);;
    
    public PanelRegistroEstudiante(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButtonEnviar = new javax.swing.JButton();
        jLabelNombres = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldNombres = new PJTextField();
        jComboBoxSexo = new javax.swing.JComboBox();
        jTextFieldDia = new PJTextField();
        jTextFieldAÒo = new PJTextField();
        jTextFieldMes = new PJTextField();
        jComboBoxOcupacion = new javax.swing.JComboBox();
        jPanelOcupacion = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));

        jButtonEnviar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonEnviar.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jButtonEnviar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonEnviar.setText("Enviar");
        jButtonEnviar.setBorder(null);
        jButtonEnviar.setBorderPainted(false);
        jButtonEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar.setEnabled(false);
        jButtonEnviar.setFocusPainted(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabelNombres.setBackground(getBackground());
        jLabelNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNombres.setForeground(new java.awt.Color(51, 51, 51));
        jLabelNombres.setText("Nombres:");

        jLabelFecha.setBackground(jLabelNombres.getForeground());
        jLabelFecha.setFont(jLabelNombres.getFont());
        jLabelFecha.setForeground(jLabelNombres.getForeground());
        jLabelFecha.setText("Fecha de Nacimiento:");

        jLabel4.setBackground(jLabelNombres.getBackground());
        jLabel4.setFont(jLabelNombres.getFont());
        jLabel4.setForeground(jLabelNombres.getForeground());
        jLabel4.setText("Sexo:");

        jLabel5.setBackground(jLabelNombres.getBackground());
        jLabel5.setFont(jLabelNombres.getFont());
        jLabel5.setForeground(jLabelNombres.getForeground());
        jLabel5.setText("Ocupaci√≥n:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Datos Personales");

        jTextFieldNombres.setBackground(jLabelNombres.getBackground());
        jTextFieldNombres.setFont(jLabelNombres.getFont());
        jTextFieldNombres.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresActionPerformed(evt);
            }
        });
        jTextFieldNombres.addKeyListener(new KeyListenerTad());

        jComboBoxSexo.setFont(jLabelNombres.getFont());
        jComboBoxSexo.setForeground(jLabelNombres.getForeground());
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jTextFieldDia.setFont(jTextFieldNombres.getFont());
        jTextFieldDia.setForeground(jTextFieldNombres.getForeground());
        jTextFieldDia.setText("d√≠a");
        jTextFieldDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDiaFocusGained(evt);
            }
        });
        jTextFieldDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiaActionPerformed(evt);
            }
        });
        jTextFieldDia.addKeyListener(new KeyListenerTad());

        jTextFieldAÒo.setBackground(jTextFieldNombres.getBackground());
        jTextFieldAÒo.setFont(jTextFieldNombres.getFont());
        jTextFieldAÒo.setForeground(jTextFieldNombres.getForeground());
        jTextFieldAÒo.setText("a√±o");
        jTextFieldAÒo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAÒoFocusGained(evt);
            }
        });
        jTextFieldAÒo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAÒoActionPerformed(evt);
            }
        });
        jTextFieldAÒo.addKeyListener(new KeyListenerTad());

        jTextFieldMes.setBackground(jTextFieldNombres.getBackground());
        jTextFieldMes.setFont(jTextFieldNombres.getFont());
        jTextFieldMes.setForeground(jTextFieldNombres.getForeground());
        jTextFieldMes.setText("mes");
        jTextFieldMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMesFocusGained(evt);
            }
        });
        jTextFieldMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesActionPerformed(evt);
            }
        });
        jTextFieldMes.addKeyListener(new KeyListenerTad());

        jComboBoxOcupacion.setFont(jLabelNombres.getFont());
        jComboBoxOcupacion.setForeground(jLabelNombres.getForeground());
        jComboBoxOcupacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estudiante", "Empleado", "Otro" }));
        jComboBoxOcupacion.setToolTipText(RB.getString("TickOcupacion")
        );
        jComboBoxOcupacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOcupacionItemStateChanged(evt);
            }
        });

        jPanelOcupacion.setBackground(getBackground());
        jPanelOcupacion.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAÒo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxOcupacion, 0, 165, Short.MAX_VALUE))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(jPanelOcupacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDia)
                    .addComponent(jTextFieldAÒo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jComboBoxSexo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelOcupacion, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelOcupacion.add((javax.swing.JPanel)panelOCupacionView, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombresActionPerformed

    }//GEN-LAST:event_jTextFieldNombresActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        if(panelOCupacionView.camposVacios()){
             panelOCupacionView.throwWarning();
             return;
        }
        registroEstudiante();
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextFieldDiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDiaFocusGained
        if(jTextFieldDia.getText().compareTo("D√≠a") == 0){
            jTextFieldDia.setText("");
            ((PJTextField)jTextFieldDia).setCalendar(true);
        }
    }//GEN-LAST:event_jTextFieldDiaFocusGained

    private void jTextFieldMesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMesFocusGained
        if(jTextFieldMes.getText().compareTo("Mes") == 0){
            jTextFieldMes.setText("");
            ((PJTextField)jTextFieldMes).setCalendar(true);
        }
    }//GEN-LAST:event_jTextFieldMesFocusGained

    private void jTextFieldAÒoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAÒoFocusGained
        if(jTextFieldAÒo.getText().compareTo("A√±o") == 0){
            jTextFieldAÒo.setText("");
            ((PJTextField)jTextFieldAÒo).setCalendar(true);
        }
    }//GEN-LAST:event_jTextFieldAÒoFocusGained

    private void jTextFieldDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiaActionPerformed
        jTextFieldMes.requestFocus();
    }//GEN-LAST:event_jTextFieldDiaActionPerformed

    private void jTextFieldMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMesActionPerformed
        jTextFieldAÒo.requestFocus();
    }//GEN-LAST:event_jTextFieldMesActionPerformed

    private void jTextFieldAÒoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAÒoActionPerformed
        jComboBoxSexo.requestFocus();
    }//GEN-LAST:event_jTextFieldAÒoActionPerformed

    private void jComboBoxOcupacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOcupacionItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            int index = jComboBoxOcupacion.getSelectedIndex();
            jPanelOcupacion.removeAll();

            switch(index){
                case 0:{
                    ocupacion = OcupacionEnum.ESTUDIANTE;
                    panelOCupacionView = new PanelCaseEstudiante(RB);
                    jPanelOcupacion.add((javax.swing.JPanel) panelOCupacionView, java.awt.BorderLayout.CENTER);
                    break;
                }
                case 1:{
                    ocupacion = OcupacionEnum.EMPLEADO;
                    panelOCupacionView = new PanelCaseEmpleado(RB);
                    jPanelOcupacion.add((javax.swing.JPanel)panelOCupacionView,java.awt.BorderLayout.CENTER);
                    break;
                }case 2:{
                    ocupacion = OcupacionEnum.OTRO;
                    panelOCupacionView = new PanelCaseOtro(RB);
                    jPanelOcupacion.add((javax.swing.JPanel)panelOCupacionView, java.awt.BorderLayout.CENTER);
                    break;
                }
            }
            jPanelOcupacion.updateUI();
        }
    }//GEN-LAST:event_jComboBoxOcupacionItemStateChanged

    private void verificaFormulario(){
        jButtonEnviar.setEnabled(!(((PJTextField)jTextFieldNombres).fieldEmply()
                ||((PJTextField)jTextFieldDia).fieldEmply()||((PJTextField)jTextFieldMes).fieldEmply()||((PJTextField)jTextFieldAÒo).fieldEmply()));
    }
    
    private Persona getEstudianteFromFormulario() throws NumberFormatException, IndexOutOfBoundsException{
        Persona persona = new Persona();
        persona.setNombreCompleto(jTextFieldNombres.getText());
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(Integer.parseInt(jTextFieldAÒo.getText()), Integer.parseInt(jTextFieldMes.getText())-1, Integer.parseInt(jTextFieldDia.getText()));
        persona.setFechaNacimiento(new java.sql.Date(calendar.getTimeInMillis()));
        persona.setFechaRegistro((new java.sql.Date(java.util.Calendar.getInstance().getTimeInMillis())));
        persona.setSexo((jComboBoxSexo.getSelectedIndex() == 0)? 'M':'F');
        persona.setTipoOcupacion(ocupacion);
        persona.setOcupacion(panelOCupacionView.getOcupacion());
        persona.setLugar(panelOCupacionView.getLugar());
        System.out.println(persona.getFechaNacimiento());
        
        return persona;
    }
    
    private void registroEstudiante(){
        final Runnable run = new Runnable() {

            @Override
            public void run() {
                try{
                    logica.setEstudiante(getEstudianteFromFormulario());
                }catch(NumberFormatException ex){
                    javax.swing.JOptionPane.showMessageDialog(jTextFieldDia, ex);
                    return;
                }catch(ArrayIndexOutOfBoundsException ex){
                    javax.swing.JOptionPane.showMessageDialog(jTextFieldDia, ex);
                    return;
                }
                DialogConfirmar confirmar = new DialogConfirmar(PanelRegistroEstudiante.this, logica.getEstudiante().getNombreCompleto());
                mainFrame.getjToggleButtonRealizaTest().setEnabled(true);
                if(confirmar.getRespuesta() == 1){
                      mainFrame.updateViewTest(true);
                      ControlModel.getInstance().waiting();
                      mainFrame.getjToggleButtonRegistro().setEnabled(true);
                      mainFrame.getjToggleButtonRealizaTest().setSelected(true);
                      ControlModel.getInstance().establacerPanelActual(new PanelViewTest(mainFrame));
                }
            }
        };
        new Thread(run).start();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JComboBox jComboBoxOcupacion;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JPanel jPanelOcupacion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldAÒo;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNombres;
    // End of variables declaration//GEN-END:variables
private class KeyListenerTad extends java.awt.event.KeyAdapter{
        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            verificaFormulario();
        }   
    }
}
