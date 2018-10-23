/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.panels;

import prociencia2.logic.core.daos.TestDao;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.entities.Test;
import prociencia2.logic.model.ControlModel;

/**
 *
 * @author Klac
 */
public class PanelViewChatInform extends javax.swing.JPanel {

    private final Persona estudiante;
    
    public PanelViewChatInform(Persona estudiante) {
        this.estudiante = estudiante;
        initComponents();
        initTabbedPaneChart();
    }

    private void initTabbedPaneChart(){
        TestDao testDao = new TestDao();
        try{
            for(Test test:testDao.getTesOfStudent(estudiante.getCodigo())){
                jTabbedPaneViewChart.add(test.getNombre(), new PanelTabbedChart(test,estudiante));
            }
        }catch(java.sql.SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(this, ex);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelTitle = new javax.swing.JPanel();
        jButtonBackPanel = new javax.swing.JButton();
        jLabelNameStudent = new javax.swing.JLabel();
        jTabbedPaneViewChart = new javax.swing.JTabbedPane();
        jPanelFoot = new javax.swing.JPanel();
        jLabelOcupacion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jPanelTitle.setBackground(new java.awt.Color(204, 204, 255));

        jButtonBackPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/19-Left-Arrow-icon.png"))); // NOI18N
        jButtonBackPanel.setToolTipText("volver al panel principal");
        jButtonBackPanel.setBorderPainted(false);
        jButtonBackPanel.setContentAreaFilled(false);
        jButtonBackPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBackPanel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/19-Left-Arrow-iconRellover.png"))); // NOI18N
        jButtonBackPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackPanelActionPerformed(evt);
            }
        });

        jLabelNameStudent.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabelNameStudent.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNameStudent.setText(estudiante.getNombreCompleto());

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addComponent(jButtonBackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addComponent(jButtonBackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(jPanelTitle, gridBagConstraints);
        jPanelTitle.getAccessibleContext().setAccessibleDescription("");

        jTabbedPaneViewChart.setBackground(getBackground());
        jTabbedPaneViewChart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPaneViewChart.setForeground(jLabelNameStudent.getForeground());
        jTabbedPaneViewChart.setFont(jLabelNameStudent.getFont());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPaneViewChart, gridBagConstraints);

        jPanelFoot.setBackground(jPanelTitle.getBackground());
        jPanelFoot.setPreferredSize(new java.awt.Dimension(841, 30));

        jLabelOcupacion.setFont(jLabelNameStudent.getFont());
        jLabelOcupacion.setForeground(jLabelNameStudent.getForeground());
        jLabelOcupacion.setText("  Ocupación: "+estudiante.getStringDeOcupacion(estudiante.getTipoOcupacion())+"       Lugar: "+estudiante.getLugar());

        javax.swing.GroupLayout jPanelFootLayout = new javax.swing.GroupLayout(jPanelFoot);
        jPanelFoot.setLayout(jPanelFootLayout);
        jPanelFootLayout.setHorizontalGroup(
            jPanelFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOcupacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        jPanelFootLayout.setVerticalGroup(
            jPanelFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOcupacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanelFoot, gridBagConstraints);
        jPanelFoot.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackPanelActionPerformed
        ControlModel.getInstance().volverAlPanelAnterior();
    }//GEN-LAST:event_jButtonBackPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackPanel;
    private javax.swing.JLabel jLabelNameStudent;
    private javax.swing.JLabel jLabelOcupacion;
    private javax.swing.JPanel jPanelFoot;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JTabbedPane jTabbedPaneViewChart;
    // End of variables declaration//GEN-END:variables
}
