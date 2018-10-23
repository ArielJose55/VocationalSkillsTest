/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.panels;

import javax.swing.AbstractButton;

/**
 *
 * @author Klac
 */
public class PanelOptions extends javax.swing.JPanel {

    private final ChangedListenerTad EVENT_CHANGE = new ChangedListenerTad();
    /**
     * Creates new form PanelOptions
     */
    public PanelOptions() {
        initComponents();
    }
    
    public void uptadeViewQuestion(boolean viewQuestion){
        option5.setVisible(viewQuestion);
    }
    
    public void azar(){
        java.util.Random rd = new java.util.Random();
        int i = rd.nextInt(5);
        switch(i){
            case 0:{
                option1.setSelected(true);
                break;
            }
            case 1:{
                option2.setSelected(true);
                break;
            }
            case 2:{
                option3.setSelected(true);
                break;
            }
            case 3:{
                option4.setSelected(true);
                break;
            }
            
            default:{
                if(option5.isVisible()){
                    option5.setSelected(true);
                }else{
                    option1.setSelected(true);
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        option5 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        option1.setBackground(this.getBackground());
        botones.add(option1);
        option1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        option1.setForeground(new java.awt.Color(51, 51, 51));
        option1.setText("1");
        option1.addItemListener(EVENT_CHANGE);

        option2.setBackground(option1.getBackground());
        botones.add(option2);
        option2.setFont(option1.getFont());
        option2.setForeground(option1.getForeground());
        option2.setText("2");
        option2.addItemListener(EVENT_CHANGE);

        option3.setBackground(option1.getBackground());
        botones.add(option3);
        option3.setFont(option1.getFont());
        option3.setForeground(option1.getForeground());
        option3.setText("3");
        option3.addItemListener(EVENT_CHANGE);

        option4.setBackground(option1.getBackground());
        botones.add(option4);
        option4.setFont(option1.getFont());
        option4.setForeground(option1.getForeground());
        option4.setText("4");
        option4.addItemListener(EVENT_CHANGE);

        option5.setBackground(option1.getBackground());
        botones.add(option5);
        option5.setFont(option1.getFont());
        option5.setForeground(option1.getForeground());
        option5.setText("5");
        option5.addItemListener(EVENT_CHANGE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(option4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(option5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getSelectionOption(){
        java.util.Enumeration<javax.swing.AbstractButton> buttons = botones.getElements();
        
        while (buttons.hasMoreElements()) {
            AbstractButton abstractButton = buttons.nextElement();
            if(abstractButton.isSelected()){
                return Integer.parseInt(abstractButton.getText());
            }
        }
        notSelectionOption();
        return -1;
        
    }
    private void notSelectionOption(){
        setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
    }

    private class ChangedListenerTad implements java.awt.event.ItemListener{

        @Override
        public void itemStateChanged(java.awt.event.ItemEvent e) {
            if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED){
                if(getBorder() != null) setBorder(null);
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botones;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JRadioButton option5;
    // End of variables declaration//GEN-END:variables
}
