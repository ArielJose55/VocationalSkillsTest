

package prociencia2.logic.model;

import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.util.models.TableModelData;
import prociencia2.logic.model.threads.ThreadExecutorTutor;
import prociencia2.views.frames.MainFrame;
import prociencia2.views.panels.PanelRegistroEstudiante;
import prociencia2.views.panels.PanelViewListEstudiante;

/**
 *
 * @author Klac
 */
public class ControlModel {
    
    private static ControlModel logica = null;
    private static boolean workConnection = false;
    private static User sesion = User.ESTUDIANTE;
    
    private javax.swing.JPanel panelWork;
    private javax.swing.JPanel panelActual;
    private javax.swing.JPanel panelAnterior;
    private final TableModelData tableModel = new TableModelData();
    private final ConsultorDatabase consultor = new ConsultorDatabase(this);
    private final Thread hiloActulizador;
    private Persona estudiante;
    private java.util.Timer tareaProgramada;
    
    private ControlModel() {
        panelActual = panelAnterior = null;
        hiloActulizador = new Thread(consultor);
        inti();
        initExecutor();
//        inicarFiltrado();
    }
    
    private void initExecutor(){
        try {
            new ThreadExecutorTutor();
        } catch (java.io.IOException e) {
        }
    }
    
    private void inti(){
        hiloActulizador.start();
        tareaProgramada = new java.util.Timer();
        java.util.TimerTask tarea = new java.util.TimerTask() {
            @Override
            public void run() {
                System.err.println("timer ejecutandose....");
             consultor.despertar();
            }
        };
        tareaProgramada.schedule(tarea, 0,1800000);
    }
    
    public static ControlModel getInstance(){
        if(logica == null){
            logica = new ControlModel();
        }
        return logica;
    }

    public static boolean isWorkConnection() {
        return workConnection;
    }

    public static void setWorkConnection(boolean workConnection) {
        ControlModel.workConnection = workConnection;
    }

    public static User getSesion() {
        return sesion;
    }

    public static void setSesion(User sesion) {
        ControlModel.sesion = sesion;
    }
    
    
//-------------------------------------------------------------------------------------------------------------------------------------
    public void setPanelWork(javax.swing.JPanel panelWork) {
        this.panelWork = panelWork;
    }

    public javax.swing.JPanel getPanelWork() {
        return panelWork;
    }  

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public TableModelData getTableModel() {
        return tableModel;
    }

    public ConsultorDatabase getConsultor() {
        return consultor;
    }
    
    public void createDateModelTable(java.util.List<Persona> listAllEstudiante) {
        tableModel.addListaAndReplace(listAllEstudiante);
    }
    
    public ControlModelAdministrador getControlModelAdministrador(){
        return ControlModelAdministrador.getInstance();
    }
    public void destrucControlModelAdministrador(){
        ControlModelAdministrador.destructControlModelAdministrador();
    }
    
    public void closeSessionAdministrador(MainFrame main){
        main.updateViewTest(false);
        panelActual = new PanelRegistroEstudiante(main);
        destrucControlModelAdministrador();
        cambiarPanel();
    }
//-------------------------------------------------------------------------------------------------------------------------------------
    
    public void volverAlPanelAnterior(){
        javax.swing.JPanel panel = panelAnterior;
        panelAnterior = panelActual;
        panelActual = panel;
        cambiarPanel();
    }
    
    public void waiting(){
        panelWork.add(new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/prociencia2/views/resources/CircleLoading.gif")))
                ,java.awt.BorderLayout.CENTER);
        panelWork.updateUI();
    }
    
    public void establacerPanelActual(javax.swing.JPanel actual){
        if(!(actual instanceof PanelViewListEstudiante) && (panelActual instanceof PanelViewListEstudiante))
            destrucControlModelAdministrador();
        panelAnterior = panelActual;
        panelActual = actual;
        cambiarPanel();
    }
    private void cambiarPanel(){
        panelWork.removeAll();
        if(panelAnterior == null){
              panelWork.add(panelActual, java.awt.BorderLayout.CENTER);
        }else{
             panelWork.add(panelActual, java.awt.BorderLayout.CENTER);
        }
        panelWork.updateUI();
    }

    
}
