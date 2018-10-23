/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.controllers.listeners;

/**
 *
 * @author Klac
 */
public class MouseMoveListener extends java.awt.event.MouseAdapter{

    private java.awt.Color colorOriginal;
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        javax.swing.JToggleButton component = (javax.swing.JToggleButton) e.getComponent();
        if(component.isSelected()){
            component.setBackground(colorOriginal);
            return;
        }
        colorOriginal = component.getBackground();
        component.setBackground(new java.awt.Color(240,240,255));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        javax.swing.JToggleButton component = (javax.swing.JToggleButton) e.getComponent();
        if(component.isSelected()){
            component.setBackground(colorOriginal);
            return;
        }
        component.setBackground(colorOriginal);
    }
}

