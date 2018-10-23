
package prociencia2.views.panels;

import prociencia2.logic.core.entities.Ocupacion;
import prociencia2.views.componets.PJTextField;
/**
 *
 * @author Klac
 */
public class PanelCaseEstudiante extends javax.swing.JPanel implements PanelValidador{

    private final java.util.ResourceBundle RB;
    private final Ocupacion ocupacion = new Ocupacion();
    private final java.awt.Color colorGuia;
    
    public PanelCaseEstudiante(java.util.ResourceBundle RB) {
        this.RB = RB;
        initComponents();
        this.colorGuia = guiaMain.getForeground();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        gradoCursado = new PJTextField(true);
        jLabel2 = new javax.swing.JLabel();
        Institucion = new PJTextField();
        guiaMain = new javax.swing.JLabel();
        guia2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lugar = new PJTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(getFont());
        jLabel1.setForeground(getForeground());
        jLabel1.setText("Grado cursado:");

        gradoCursado.setFont(getFont());
        gradoCursado.setForeground(getForeground());
        gradoCursado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gradoCursadoFocusGained(evt);
            }
        });

        jLabel2.setFont(getFont());
        jLabel2.setForeground(getForeground());
        jLabel2.setText("Institución:");

        Institucion.setFont(getFont());
        Institucion.setForeground(getForeground());
        Institucion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InstitucionFocusGained(evt);
            }
        });
        Institucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstitucionActionPerformed(evt);
            }
        });

        guiaMain.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        guiaMain.setForeground(new java.awt.Color(0, 102, 255));
        guiaMain.setText(RB.getString("GuiEstudiante"));

        guia2.setFont(guiaMain.getFont());
        guia2.setForeground(guiaMain.getForeground());
        guia2.setText(RB.getString("GuiaGrado")
        );

        jLabel3.setFont(getFont());
        jLabel3.setForeground(getForeground());
        jLabel3.setText("Lugar de registro:");

        lugar.setFont(getFont());
        lugar.setForeground(getForeground());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gradoCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guiaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guiaMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gradoCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guia2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstitucionActionPerformed
        gradoCursado.requestFocus();
    }//GEN-LAST:event_InstitucionActionPerformed

    private void InstitucionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InstitucionFocusGained
        guiaMain.setForeground(colorGuia);
    }//GEN-LAST:event_InstitucionFocusGained

    private void gradoCursadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gradoCursadoFocusGained
        guia2.setForeground(colorGuia);
    }//GEN-LAST:event_gradoCursadoFocusGained

    public boolean camposVacios(){
        return ((PJTextField)gradoCursado).fieldEmply() || ((PJTextField)Institucion).fieldEmply() ||((PJTextField)lugar).fieldEmply();
    }
    
    public Ocupacion getOcupacion(){
        ocupacion.setInstitucion(Institucion.getText());
        ocupacion.setGradoCursado(Integer.parseInt(gradoCursado.getText()));
        ocupacion.setNivelEscolaridad(null);
        ocupacion.setCulmino(null);
        ocupacion.setUltimoGrado(null);
        ocupacion.setCargo(null);
        return ocupacion;
    }
    
    public void throwWarning(){
        javax.swing.JOptionPane.showMessageDialog(this, RB.getString("WarningGene"),"Datos incompletos",javax.swing.JOptionPane.WARNING_MESSAGE,
             new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/Attention.png")));
    }

    public String getLugar() {
        return lugar.getText().compareTo("") == 0 ? null : lugar.getText();
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Institucion;
    private javax.swing.JTextField gradoCursado;
    private javax.swing.JLabel guia2;
    private javax.swing.JLabel guiaMain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lugar;
    // End of variables declaration//GEN-END:variables
}
