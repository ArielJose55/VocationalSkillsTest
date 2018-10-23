/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.panels;

import prociencia2.logic.core.entities.Pregunta;
import prociencia2.logic.core.entities.Seccion;

/**
 *
 * @author Klac
 */
public class PanelSection extends javax.swing.JPanel{

    private final Seccion seccion;
    
    public PanelSection(Seccion seccion) {
        this.seccion = seccion;
        initComponets();
    }   
    
    public int getSelectionTotalQuestion(){
        int acumPositive;
        int acumNegative;
        acumNegative = acumPositive = 0;
        for(java.awt.Component component : this.getComponents()){
            if(component instanceof PanelOptions){
//                ((PanelOptions)component).azar();
                int i = ((PanelOptions)component).getSelectionOption();
                if(i < 0){
                    acumNegative += i;
                }else{
                    acumPositive += i;
                }
            }
        }
        if(acumNegative != 0){
            return acumNegative;
        }else{
            return acumPositive;
        }
    }
    
    private void initComponets(){
        setBackground(java.awt.Color.WHITE);
        setForeground(new java.awt.Color(100, 100, 100));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        setLayout(new java.awt.GridBagLayout());
        javax.swing.JLabel etiqueta = new javax.swing.JLabel("Seccion "+seccion.getNombre());
        etiqueta.setBackground(this.getBackground());
        etiqueta.setForeground(this.getForeground());
        etiqueta.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        java.awt.GridBagConstraints co = new java.awt.GridBagConstraints();
        co.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        co.insets = new java.awt.Insets(5, 25, 5, 5);
        co.gridx = 0;
        co.gridy = 0;
        
        
        add(etiqueta,co);
        
        PanelOptions panelOptions;
        
        java.awt.GridBagConstraints coLabel = new java.awt.GridBagConstraints();
        java.awt.GridBagConstraints coCombo = new java.awt.GridBagConstraints();
        coLabel.anchor = java.awt.GridBagConstraints.WEST;
        coLabel.gridx = 0;
        coLabel.fill = java.awt.GridBagConstraints.BOTH;
        coLabel.insets = new java.awt.Insets(2, 15, 2, 5);
//        coLabel.ipadx = 0;
        coLabel.weightx = 1f;
        coLabel.weighty = 1f;
        
        
        coCombo.anchor = java.awt.GridBagConstraints.EAST;
        coCombo.gridx = 1;
        coCombo.insets = new java.awt.Insets(2, 15, 2, 30);
//        coCombo.ipady = 30;
//        coCombo.ipadx = 80;
        
        int i = 1;
        
        for(Pregunta pregunta : seccion.getPreguntas()){
//            etiqueta = new javax.swing.JLabel("<html><h2>"+i+". "+pregunta.getPregunta()+"</h2></html>");
            etiqueta = new javax.swing.JLabel(i+". "+pregunta.getPregunta());
            etiqueta.setForeground(this.getForeground());
            etiqueta.setFont(new java.awt.Font("Arial", 0, 15));
            coLabel.gridy = i;
            add(etiqueta, coLabel);
            panelOptions = new PanelOptions();
            panelOptions.uptadeViewQuestion(seccion.getPreguntas().size()!=5);
            coCombo.gridy = i;
            add(panelOptions, coCombo);
            i++;
        }
    }

    public Seccion getSeccion() {
        return seccion;
    }
    
    
}
