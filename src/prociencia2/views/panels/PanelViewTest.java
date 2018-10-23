/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.panels;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prociencia2.logic.core.daos.PersonaDao;
import prociencia2.logic.core.daos.WriteWorkConnection;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.entities.Seccion;
import prociencia2.logic.core.entities.Test;
import prociencia2.logic.core.entities.TypeTest;
import prociencia2.logic.core.util.questionario.ReaderXMLQuestionario;
import prociencia2.logic.model.ControlModel;
import prociencia2.views.frames.MainFrame;

/**
 *
 * @author Klac
 */
public  class PanelViewTest extends javax.swing.JPanel{
    
    private final MainFrame mainFrame;
    
    public PanelViewTest(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        try {
            initComponents();
        } catch (Exception ex) {
            Logger.getLogger(PanelViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initComponents() throws Exception{
        setLayout(new java.awt.BorderLayout());
        panelRoot = new javax.swing.JPanel();
        panelRoot.setLayout(new javax.swing.BoxLayout(panelRoot, javax.swing.BoxLayout.Y_AXIS));
        panelRoot.add(new PanelInstructionInteres());
        Test test = ReaderXMLQuestionario.getTestIntereses();
        for(Seccion section : test.getSecciones()){
            panelRoot.add(new PanelSection(section));
        }
        
        test = ReaderXMLQuestionario.getTestAptitudes();
        panelRoot.add(new PanelInstructionAptitud());
        for(Seccion section : test.getSecciones()){
            panelRoot.add(new PanelSection(section));
        }
        panelRoot.add(createPanelVerifica());
        javax.swing.JScrollPane scrollPanel = new javax.swing.JScrollPane();
        scrollPanel.getVerticalScrollBar().setUnitIncrement(14);
        scrollPanel.setHorizontalScrollBar(null);
        scrollPanel.setWheelScrollingEnabled(false);
//        scrollPanel.setLayout(null);
        scrollPanel.setViewportView(panelRoot);
        add(scrollPanel, java.awt.BorderLayout.CENTER);
    }
    
//    public static void main(String ar[]){
//        final javax.swing.JFrame v = new javax.swing.JFrame();
//        v.add(new PanelViewTest(), java.awt.BorderLayout.CENTER);
//        v.pack();
//        v.setVisible(true);
//    }
     private javax.swing.JPanel createPanelVerifica(){
            javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridBagLayout());
            panel.setPreferredSize(new java.awt.Dimension(20, 120));
            javax.swing.JButton boton = new javax.swing.JButton("Enviar");
            boton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
            boton.setBackground(new java.awt.Color(204,204,255));
            boton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.CYAN, 1));
            
            boton.setFocusPainted(false);
            boton.setFont(new java.awt.Font("Tahoma",java.awt.Font.PLAIN,22));
        
            java.awt.GridBagConstraints confi = new java.awt.GridBagConstraints();
            confi.ipadx = 100;
            confi.ipady = 26;
        
            boton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Test testInteres = new Test(null,"Intereses Ocupacionales");
                    Test testAptitud = new Test(null,"Aptitudes Vocacionales");
                    boolean todoBien = true;
            
                    int i;
                    for (java.awt.Component compo : panelRoot.getComponents()) {

                        if(compo instanceof PanelSection){
//                      ((PanelQuestionario)(compo)).azar();
                            i = ((PanelSection)(compo)).getSelectionTotalQuestion();
                            if(i < 0){
                                todoBien = false;
                                continue;
                            }
                            Seccion secion = ((PanelSection)(compo)).getSeccion();
                            secion.setSumatoria(i);
                            if(secion.getTypeTest().compareTo(TypeTest.APTITUDES) == 0){
                                testAptitud.getSecciones().add(secion);
                            }else{
                                testInteres.getSecciones().add(secion);
                            }
                        }
                    }
                    if(todoBien){
                        Persona estudiante = ControlModel.getInstance().getEstudiante();
                        estudiante.setTestAptitudes(testAptitud);
                        estudiante.setTestIntereses(testInteres);
                        if(ControlModel.isWorkConnection()){
                            try {
                                WriteWorkConnection.getInstance().writeStudent(estudiante);
                                javax.swing.JOptionPane.showMessageDialog(PanelViewTest.this, "Gracias por Realizar el Test");
                                mainFrame.updateViewTest(!todoBien);
                                mainFrame.getjToggleButtonRegistro().setSelected(todoBien);
                                ControlModel.getInstance().establacerPanelActual(new PanelRegistroEstudiante(mainFrame));
                                ControlModel.getInstance().setEstudiante(null);
                            } catch (Exception ex) {
                                Logger.getLogger(PanelViewTest.class.getName()).log(Level.SEVERE, null, ex);
                                javax.swing.JOptionPane.showMessageDialog(PanelViewTest.this,"No Prueba no pudo ser registrada."
                                    + "\nPor intentelo más tarde!","Error de escritura",javax.swing.JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            PersonaDao estudianteDao = new PersonaDao();
                            try {
                                estudianteDao.registrarPersona(estudiante);
                                javax.swing.JOptionPane.showMessageDialog(PanelViewTest.this, "Gracias por Realizar el Test");
                                mainFrame.updateViewTest(!todoBien);
                                mainFrame.getjToggleButtonRegistro().setSelected(todoBien);
                                ControlModel.getInstance().establacerPanelActual(new PanelRegistroEstudiante(mainFrame));
                                ControlModel.getInstance().setEstudiante(null);
                            } catch (SQLException ex) {
                                Logger.getLogger(PanelViewTest.class.getName()).log(Level.SEVERE, null, ex);
                                javax.swing.JOptionPane.showMessageDialog(PanelViewTest.this, "<html>"
                                + "<h3>Ooops! conexión no establecida con la base da datos<br/>"
                                + "Por favor, intentelo más tarde.<h3/><p style = 'color = rgb(255,0,0)'>Nota:"
                                + " Si el problema persiste, le recomendamos que trabaje sin conexion a internet</p>"
                                + "</html>","Conexión Fallida",javax.swing.JOptionPane.WARNING_MESSAGE);
                            }
                        }
;
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(PanelViewTest.this, "<html><h3>Verifique que todas las "
                                + "preguntas estén respondidas</h3>.<h4>Nota: aquellas que no lo estén, estarán marcadas "
                                + "con un borde de color rojo</h4></html>","Preguntas sin respuestas",javax.swing.JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        panel.add(boton,confi);
        return panel;
     }
     
     private javax.swing.JPanel panelRoot;
     
}
