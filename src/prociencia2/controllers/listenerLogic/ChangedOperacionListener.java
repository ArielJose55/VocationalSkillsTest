/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.controllers.listenerLogic;

import prociencia2.logic.model.ControlModel;
import prociencia2.views.frames.MainFrame;
import prociencia2.views.panels.PanelRegistroEstudiante;
import prociencia2.views.panels.PanelViewTest;

/**
 *
 * @author Klac
 */
public class ChangedOperacionListener implements java.awt.event.ItemListener{

    private final ControlModel  logica = ControlModel.getInstance();
    private final MainFrame mainFrame;
    
    public ChangedOperacionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void itemStateChanged(java.awt.event.ItemEvent e) {
        if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            javax.swing.JToggleButton button = (javax.swing.JToggleButton)e.getSource();
            logica.getPanelWork().removeAll();
            logica.waiting();
            estableceOperacion(button.getText().replaceAll(" ", ""));
        }
    }
    
    private void estableceOperacion(final String operacion){
        final Runnable run = new Runnable(){
            public void run(){
                if(operacion.compareTo("FormulariodeRegistro") == 0){
                    mainFrame.updateViewTest(false);
                    logica.establacerPanelActual(new PanelRegistroEstudiante(mainFrame));
                }else if(operacion.compareTo("RealizarTest") == 0){
                    mainFrame.updateViewTest(true);
                    logica.establacerPanelActual(new PanelViewTest(mainFrame));
                }else{
                    System.out.println(operacion);
                }
                
            }
        };

        Thread hilito=new Thread(run);
        hilito.start();
    }  
}
