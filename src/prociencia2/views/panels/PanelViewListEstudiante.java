

package prociencia2.views.panels;

import java.awt.event.ActionEvent;
import prociencia2.logic.core.util.models.ComboBoxModel;
import prociencia2.controllers.listenerComponent.ComponetFilterListener;
import prociencia2.logic.core.daos.PersonaDao;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.util.models.TableModelData;
import prociencia2.views.componets.table.FactoryColumnModel;
import prociencia2.logic.model.ControlModel;
import prociencia2.logic.model.ControlModelAdministrador;
import prociencia2.logic.model.sheetexcels.CreatorExcels;
import prociencia2.views.componets.alerts.FactoryMessage;

/**
 *
 * @author Klac
 */
public class PanelViewListEstudiante extends javax.swing.JPanel {

    private final ControlModelAdministrador logicAdministrador = ControlModel.getInstance().getControlModelAdministrador();
    private final ComponetFilterListener COMPO_FILTER_lISTENR = new ComponetFilterListener();
    
    public PanelViewListEstudiante() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelFiltrado = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBoxFecha = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButtonGenerarExcel = new javax.swing.JButton();
        jLabelProcessExcel = new javax.swing.JLabel();
        jButtonDeleteRow = new javax.swing.JButton();
        jLabelProcessDelete = new javax.swing.JLabel();
        jLabelCountStudent = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNames = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(getBackground());
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(getBackground());
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(ControlModel.getInstance().getTableModel()
        );
        jTable1.setRowSorter(logicAdministrador.getTableRowSorter());
        jTable1.setFillsViewportHeight(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(230, 240, 245));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.setColumnModel(FactoryColumnModel.createModelColumnTableMain());
        jTable1.setShowGrid(false);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(getBackground());
        jPanel2.setMaximumSize(new java.awt.Dimension(300, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 337));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jSeparator1.setBackground(getBackground());
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMinimumSize(new java.awt.Dimension(2, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 472;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jSeparator1, gridBagConstraints);

        jPanelFiltrado.setBackground(getBackground());
        jPanelFiltrado.setMaximumSize(new java.awt.Dimension(300, 353));
        jPanelFiltrado.setMinimumSize(new java.awt.Dimension(300, 353));
        jPanelFiltrado.setPreferredSize(new java.awt.Dimension(300, 353));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Filtros");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jComboBoxFecha.setFont(jButton1.getFont());
        jComboBoxFecha.setForeground(jButton1.getForeground());
        jComboBoxFecha.setModel(new ComboBoxModel(1));
        jComboBoxFecha.setBorder(null);
        jComboBoxFecha.setName("FechadeRegistro"); // NOI18N
        COMPO_FILTER_lISTENR.addComponent(jComboBoxFecha);
        jComboBoxFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFechaItemStateChanged(evt);
            }
        });

        jComboBox1.setFont(jButton1.getFont());
        jComboBox1.setForeground(jButton1.getForeground());
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Ocupación", "Estudiante", "Empleado", "Otro" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(jButton1.getFont());
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Información y Operaciones");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);

        jButtonGenerarExcel.setBackground(new java.awt.Color(204, 255, 204));
        jButtonGenerarExcel.setFont(new java.awt.Font("SansSerif", 0, 17)); // NOI18N
        jButtonGenerarExcel.setForeground(new java.awt.Color(0, 102, 204));
        jButtonGenerarExcel.setText("Generar Excel");
        jButtonGenerarExcel.setFocusPainted(false);
        jButtonGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarExcelActionPerformed(evt);
            }
        });

        jButtonDeleteRow.setBackground(new java.awt.Color(204, 204, 255));
        jButtonDeleteRow.setFont(jButtonGenerarExcel.getFont());
        jButtonDeleteRow.setForeground(new java.awt.Color(255, 0, 0));
        jButtonDeleteRow.setText("Elimina registro");
        jButtonDeleteRow.setToolTipText("");
        jButtonDeleteRow.setFocusPainted(false);
        jButtonDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRowActionPerformed(evt);
            }
        });

        jLabelCountStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCountStudent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
        jLabelCountStudent.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanelFiltradoLayout = new javax.swing.GroupLayout(jPanelFiltrado);
        jPanelFiltrado.setLayout(jPanelFiltradoLayout);
        jPanelFiltradoLayout.setHorizontalGroup(
            jPanelFiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltradoLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltradoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCountStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFiltradoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFiltradoLayout.createSequentialGroup()
                        .addComponent(jButtonGenerarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProcessExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFiltradoLayout.createSequentialGroup()
                        .addComponent(jButtonDeleteRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProcessDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFiltradoLayout.setVerticalGroup(
            jPanelFiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltradoLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGenerarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProcessExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProcessDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jLabelCountStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jComboBoxFecha.setSelectedIndex(0);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanelFiltrado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(getBackground());
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 34));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(getBackground());
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/Magnifier.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 5);
        jPanel3.add(jLabel1, gridBagConstraints);

        jTextFieldNames.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextFieldNames.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldNames.setText("Buscar");
        jTextFieldNames.setBorder(null);
        jTextFieldNames.setCaretPosition(0);
        jTextFieldNames.setMaximumSize(new java.awt.Dimension(2147483647, 32));
        jTextFieldNames.setMinimumSize(new java.awt.Dimension(0, 32));
        jTextFieldNames.setPreferredSize(new java.awt.Dimension(150, 32));
        jTextFieldNames.addKeyListener(new PJKeyAdapter());
        jTextFieldNames.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNamesFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 270;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        jPanel3.add(jTextFieldNames, gridBagConstraints);
        jTextFieldNames.getAccessibleContext().setAccessibleDescription("");

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 198;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jSeparator2, gridBagConstraints);

        jCheckBox1.setBackground(getBackground());
        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jCheckBox1.setForeground(jButton1.getForeground());
        jCheckBox1.setText("Mostrar No Procesados");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jCheckBox1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFechaItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            logicAdministrador.setFilterDate(evt.getItem().toString());
            logicAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
        }
    }//GEN-LAST:event_jComboBoxFechaItemStateChanged

    private void jTextFieldNamesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNamesFocusGained
        if(primerFoco){
            jTextFieldNames.setCaretPosition(0);
            primerFoco = false;
        }
    }//GEN-LAST:event_jTextFieldNamesFocusGained

    private void jButtonGenerarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarExcelActionPerformed
        
        final java.io.File file;
        try{
            checkTableSelectionEmply(true);
            file = createAndGetFileChooser();
        }catch(RuntimeException ex){
            java.awt.Toolkit.getDefaultToolkit().beep();
            try{checkTableSelectionEmply(false);}catch(RuntimeException ex2){}
            return;
        }
        
        final Runnable run = new Runnable(){
          public void run(){
              int option = javax.swing.JOptionPane.showConfirmDialog(PanelViewListEstudiante.this, "¿Marcar todos los registros seleccionados como procesados?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION, 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, null);
              setIconWaiting(0, 0);
              CreatorExcels creator = null;
              try{
                  java.util.List<Persona> list = getListFromModel();
                  creator = new CreatorExcels(file, list, option == javax.swing.JOptionPane.YES_OPTION);
                  creator.startWriting();
                  if(option == javax.swing.JOptionPane.YES_OPTION){
                        for(Persona person : list){
                            person.setProcesado(Boolean.TRUE);
                        }
                        ((TableModelData)jTable1.getModel()).fireTableDataChanged();
                    }
              }catch(Exception ex){
                  if(creator != null && creator.getAlertsAndWarning().compareTo("") != 0){
                      javax.swing.JOptionPane.showMessageDialog(PanelViewListEstudiante.this, creator.getAlertsAndWarning(),"Información",
                              javax.swing.JOptionPane.INFORMATION_MESSAGE);
                  }
              }finally{
                  setIconWaiting(2, 0);
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException ex){}
                    setIconWaiting(-1, 0);
                    try{checkTableSelectionEmply(false);}catch(RuntimeException ex){}
              }
          }  
        };
        
        createAndThrowThread(run);
    }//GEN-LAST:event_jButtonGenerarExcelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1 && evt.getClickCount() == 2){
            int i = jTable1.getSelectedRow();
            if( jTable1.getSelectedRowCount() == 1 && i >= 0 ){
                i = ((javax.swing.table.TableRowSorter)jTable1.getRowSorter()).convertRowIndexToModel(i);
                ControlModel.getInstance().establacerPanelActual(new PanelViewChatInform(((TableModelData)jTable1.getModel()).getPersona(i)));
            }
        }else if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3 && evt.getClickCount() == 1){
            createPopupMenu().show(jTable1, evt.getX(), evt.getY());
        }else if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1 && evt.getClickCount() == 1){
            int i = jTable1.getSelectedRow();
            if(i >= 0){
                if(!jButtonGenerarExcel.isEnabled()){
                    jButtonGenerarExcel.setEnabled(i >= 0);
                    jButtonDeleteRow.setEnabled(i >= 0);
                }
            }else{
                if(jButtonGenerarExcel.isEnabled()){
                    jButtonGenerarExcel.setEnabled(i >= 0);
                    jButtonDeleteRow.setEnabled(i >= 0);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRowActionPerformed

        try{
           checkTableSelectionEmply(true);
        }catch(RuntimeException ex){
           java.awt.Toolkit.getDefaultToolkit().beep();
           return;
        }
        
        final Runnable run = new Runnable(){
            public void run(){
                Integer codes[];
                if(jTable1.getSelectedRowCount() > 10){
                    codes = createOptionAndGetCodes(jTable1.getSelectedRows(), true);
                }else{
                    codes = createOptionAndGetCodes(jTable1.getSelectedRows(), false);
                }
                setIconWaiting(0, -1);
                if(codes == null || codes.length == 0){
                    return;
                }
                PersonaDao personDao = new PersonaDao();
                try{
                    personDao.removeEstudiantes(codes);
                    ControlModel.getInstance().getConsultor().despertar();
                    ((ComboBoxModel)jComboBoxFecha.getModel()).update();
                    jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
                }catch(java.sql.SQLException ex){
                    FactoryMessage.createMessageAlert(ex);
                }finally{
                    setIconWaiting(2, -1);
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException ex){}
                    setIconWaiting(-1, -1);
                    try{checkTableSelectionEmply(false);}catch(RuntimeException ex){}
                }
            }
        };
        createAndThrowThread(run);
    }//GEN-LAST:event_jButtonDeleteRowActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            if(jComboBox1.getSelectedIndex() == 0){
                logicAdministrador.setFilterOcupation(null);
            }else{
                logicAdministrador.setFilterOcupation(jComboBox1.getSelectedItem().toString());
            }
            logicAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            logicAdministrador.setFilterProcess(Boolean.TRUE);
        }else{
            logicAdministrador.setFilterProcess(null);
        }
        logicAdministrador.startFiltering();
        jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void createAndThrowThread(Runnable run){
        Thread thread = new Thread(run);
        thread.start();
    }
    
  
    private void setIconWaiting(int typeRequest, int typeProcess){
        if(typeProcess == 0){
            if(typeRequest < 0){
                jLabelProcessExcel.setIcon(null);
            }else if(typeRequest == 0){
                jLabelProcessExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/Original-728.gif")));
            }else{
                jLabelProcessExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/OK.png")));
            }
        }else{
            if(typeRequest < 0){
                jLabelProcessDelete.setIcon(null);
            }else if(typeRequest == 0){
                jLabelProcessDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/Original-728.gif")));
            }else{
                jLabelProcessDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/OK.png")));
            }
        }
    }
    
    private javax.swing.JPopupMenu createPopupMenu(){
        javax.swing.JPopupMenu menu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem item = new javax.swing.JMenuItem("Seleccionar todos");
        item.setFont(jButtonGenerarExcel.getFont());
        item.setBackground(jPanelFiltrado.getBackground());
        item.setBorder(null);
        item.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable1.selectAll();
            }
        });

        menu.add(item);
        return menu;
    }
    
    private Integer[] createOptionAndGetCodes(int [] rows, boolean severe){
        if(severe){
            int option = javax.swing.JOptionPane.showConfirmDialog(jTable1,
                    "<html><P color = red>¿Esta seguro de eliminar estos "+rows.length+" registros?</P></html>","Confirmar",javax.swing.JOptionPane.OK_CANCEL_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
            if(option == javax.swing.JOptionPane.YES_OPTION){
                return getCodesFromDataModel(rows);
            }else
                return null;
        }else{
            String [] options = {"Si, estoy seguro","Cancelar oparación"};
            int option = javax.swing.JOptionPane.showOptionDialog(jTable1, getNamesFromDataModel(rows),
                    "Confirmar", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(option == 0){
                return getCodesFromDataModel(rows);
            }else
                return null;
        }
    }
    
    private Integer[]  getCodesFromDataModel(int rows[]){
        Integer codes[] = new Integer[rows.length];  
        for(int i = 0 ; i < rows.length ; i++){
            codes[i] = ((TableModelData)jTable1.getModel()).getPersona(
                            ((javax.swing.table.TableRowSorter)jTable1.getRowSorter()).convertRowIndexToModel(rows[i])
                    ).getCodigo();
        }
        return codes;
    }
    
    private Object[] getNamesFromDataModel(int rows[]){
        Object names[] = new Object[rows.length+1];
        names[0] = "<html><P color = red>Los siguientes registros seran eliminados de la base de datos. ¿Desea realmente eliminarlos?</P></html><br/>";
        for(int i = 1 ; i <= rows.length ; i++){
            names[i] = ((TableModelData)jTable1.getModel()).getPersona(
                            ((javax.swing.table.TableRowSorter)jTable1.getRowSorter()).convertRowIndexToModel(rows[i-1])
                    ).toString();
        }
        return names;
    }
    
    private java.util.List<Persona> getListFromModel(){
        java.util.List<Persona> list = new java.util.ArrayList<Persona>();
        int indexs[] = jTable1.getSelectedRows();
        for(int i = 0 ; i < indexs.length ; i++)
            list.add(((TableModelData)jTable1.getModel()).getPersona(jTable1.convertRowIndexToModel(indexs[i])));
        return list;
    }
    
    public void checkTableSelectionEmply(boolean select){
        if(jTable1.getRowCount() == 0){
            throw new RuntimeException("");
        }
        if(select){
            jTable1.selectAll();
        }else{
            jTable1.getSelectionModel().clearSelection();
        }
    }
    
    public java.io.File createAndGetFileChooser() {
        
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        if(fileChooser.showSaveDialog(PanelViewListEstudiante.this) == javax.swing.JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        throw new RuntimeException();
    }
    
    private boolean primerFoco = true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDeleteRow;
    private javax.swing.JButton jButtonGenerarExcel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCountStudent;
    private javax.swing.JLabel jLabelProcessDelete;
    private javax.swing.JLabel jLabelProcessExcel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFiltrado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNames;
    // End of variables declaration//GEN-END:variables
    private class PJKeyAdapter extends java.awt.event.KeyAdapter{
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
            javax.swing.JTextField campo = (javax.swing.JTextField) e.getSource();
             if(campo.equals(jTextFieldNames)){
                if(campo.getText().compareTo("Buscar") == 0) campo.setText("");
            }
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            javax.swing.JTextField campo = (javax.swing.JTextField) e.getSource();
            if(campo.equals(jTextFieldNames)){
                logicAdministrador.setFilterNames(campo.getText());
            }
            logicAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" estudiante(s)");
        }
        
        
    }
}
