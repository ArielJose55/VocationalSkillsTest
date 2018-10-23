
package prociencia2.logic.model;

import prociencia2.logic.core.daos.PersonaDao;


/**
 *
 * @author Klac
 */
public class ConsultorDatabase implements Runnable{

    private final ControlModel logica;

    public ConsultorDatabase(ControlModel logica) {
        this.logica = logica;
    }
    
    
    @Override
    public void run() {
        while (true) {            
            if(ControlModel.getSesion().compareTo(User.ADMINISTRADOR) == 0){
                PersonaDao estudao = new PersonaDao();
                try {
                    System.err.println("Consultando...");
                    logica.createDateModelTable(estudao.getListAllEstudiante());
                } catch (java.sql.SQLException ex) {
                    java.util.logging.Logger.getLogger(ConsultorDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            dormir();
        }
    }
    
    private synchronized void dormir(){

        try {
            this.wait();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(ConsultorDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void despertar(){
        this.notify();
    }
    

}
