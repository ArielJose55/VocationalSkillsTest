/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.controllers.listenerComponent;

/**
 *
 * @author Klac
 */
public class ComponetFilterListener implements java.awt.event.ItemListener{
    
    private final java.util.List<javax.swing.JComponent> listFields;
    

    public ComponetFilterListener() {
        this.listFields = new java.util.ArrayList<javax.swing.JComponent>();
    }

    public void addComponent(javax.swing.JComponent component){
        listFields.add(component);
    }
    
    @Override
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        String getText = ((javax.swing.JCheckBox) e.getSource()).getText();
        
        if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            for(javax.swing.JComponent component:listFields){
                if(getText.replaceAll(" ", "").compareTo(component.getName()) == 0){
                    component.setEnabled(true);
                    if(component instanceof javax.swing.JTextField){
                        ((javax.swing.JTextField)component).setText("filtrar por "+getText);
                        ((javax.swing.JTextField)component).setCaretPosition(0);
//                        System.out.println(((javax.swing.JTextField)component).getText());
                    }
                    component.requestFocus(true);
                    break;
                }
            }
        }else{
            for(javax.swing.JComponent component:listFields){
                if(getText.replaceAll(" ", "").compareTo(component.getName()) == 0){
                    component.setEnabled(false);
                    if(component instanceof javax.swing.JTextField){
                        ((javax.swing.JTextField)component).setText("");
                    }
                    break;
                }
            }
        }
    }
    
    
}
