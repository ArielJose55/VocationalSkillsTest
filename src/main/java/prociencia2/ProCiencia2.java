/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2;

import prociencia2.logic.model.ControlModel;
import prociencia2.views.frames.MainFrame;

/**
 *
 * @author Klac
 */
public class ProCiencia2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, javax.swing.UnsupportedLookAndFeelException {
// 
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(ControlModel.getInstance()).setVisible(true);
//                BarChartDemo1 nose = new BarChartDemo1("nose");
//                nose.setVisible(true);
            }
        });
    }
    
}
