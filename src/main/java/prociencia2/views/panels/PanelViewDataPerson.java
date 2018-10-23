/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.panels;

import prociencia2.logic.core.daos.OcupacionDao;
import prociencia2.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class PanelViewDataPerson extends javax.swing.JPanel {

    private final Persona persona;
    
    public PanelViewDataPerson(Persona person) {
        this.persona = person;
        initComponents(person.getCodigo());
    }

    private void initComponents(final int codeStudent){
        setBackground(new java.awt.Color(255, 255, 255));
        espere();
        final Runnable run = new Runnable(){
            public void run(){
                boolean todoBien = true;
                try {
                  persona.setOcupacion(new OcupacionDao().getOcupacion(codeStudent));
                } catch (java.sql.SQLException ex) {
                    java.util.logging.Logger.getLogger(PanelViewDataPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    todoBien = false;
                }finally{
                    try{Thread.sleep(1000);}catch(InterruptedException ex){}
                    PanelViewDataPerson.this.removeAll();
                    if(todoBien){
                        initComponents();
                        updateData();
                    }else{
                        PanelViewDataPerson.this.setLayout(new java.awt.BorderLayout());
                        throwAlert();
                    }
                    PanelViewDataPerson.this.updateUI();
                }
           }
        };
        
        new Thread(run).start();
    }
    
    private void throwAlert(){
        javax.swing.JLabel alert = new javax.swing.JLabel(new javax.swing.ImageIcon(
                getClass().getResource("/prociencia2/views/resources/Error.png")
        ));
        add(alert,java.awt.BorderLayout.CENTER);
        alert = new javax.swing.JLabel("Servidor Temporalmente fuera de servicio");
        alert.setFont(new java.awt.Font("Tahoma", 1, 22));
        alert.setForeground(new java.awt.Color(255, 150, 150));
        alert.setBackground(java.awt.Color.WHITE);
        alert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(alert,java.awt.BorderLayout.SOUTH);
    }
    
    private void espere(){
        javax.swing.JLabel eti = new javax.swing.JLabel(new javax.swing.ImageIcon(
                getClass().getResource("/prociencia2/views/resources/CircleLoadingEspereWrite.gif")
        ));
        add(eti, java.awt.BorderLayout.CENTER);
////        jPanelData.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        institucion = createTextField();
        edad = createTextField();
        ocupacion = createTextField();
        fecha = createTextField();
        grado = createTextField();
        programa = createTextField();
        cargo = createTextField();
        nombres = createTextField();
        escolaridad = createTextField();
        ultimo = createTextField();
        culmino = createTextField();

        institucion.setText("");

        edad.setText("");

        ocupacion.setText("");

        fecha.setText("");

        grado.setText("");

        programa.setText("");

        cargo.setText("");

        nombres.setText("");

        escolaridad.setText("");

        ultimo.setText("");

        culmino.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(programa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(escolaridad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(institucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(ocupacion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha)
                    .addComponent(grado)
                    .addComponent(edad)
                    .addComponent(nombres)
                    .addComponent(culmino)
                    .addComponent(ultimo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(escolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(programa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(culmino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void updateData(){
        if(persona.getNombreCompleto() == null){
               nombres.setVisible(false);
            }else{
                nombres.setText("Nombre: "+persona.getNombreCompleto());
            }
            if(persona.getFechaNacimiento()== null){
                edad.setVisible(false);
            }else{
                edad.setText("Edad: "+getAños(persona.getFechaNacimiento()));
            }
            if(persona.getTipoOcupacion() == null){
                ocupacion.setVisible(false);
            }else{
                ocupacion.setText("OcupaciÃ³n: "+persona.getStringDeOcupacion(persona.getTipoOcupacion()));
            }
            if(persona.getFechaRegistro() == null){
                fecha.setVisible(false);
            }else{
                fecha.setText("Fecha de registro: "+persona.getFechaRegistro().toString());
            }
            if(persona.getOcupacion()== null){
            }else{
                if(persona.getOcupacion().getGradoCursado() == null){
                    grado.setVisible(false);
                }else{
                    grado.setText("Grado cursado: "+persona.getOcupacion().getGradoCursado());
                }
                if(persona.getOcupacion().getInstitucion() == null){
                    institucion.setVisible(false);
                }else{
                    institucion.setText("InstituciÃ³n o Empresa: "+persona.getOcupacion().getInstitucion());
                }
                if(persona.getOcupacion().getCargo() == null){
                    cargo.setVisible(false);
                }else{
                    cargo.setText("Cargo desempeÃ±ado: "+persona.getOcupacion().getCargo());
                }
                if(persona.getOcupacion().getNivelEscolaridad() == null){
                    escolaridad.setVisible(false);
                }else{
                    escolaridad.setText("Nivel de escolaridad: "+persona.getOcupacion().getNivelEscolaridad());
                }
                if(persona.getOcupacion().getPrograma() == null){
                    programa.setVisible(false);
                }else{
                    programa.setText("Programa: "+persona.getOcupacion().getPrograma());
                }
                if(persona.getOcupacion().isCulmino() == null){
                    culmino.setVisible(false);
                }else{
                    culmino.setText("Estudios culminados: "+ ((persona.getOcupacion().isCulmino())? "SI":"NO"));
                }
                if(persona.getOcupacion().getUltimoGrado() == null){
                    ultimo.setVisible(false);
                }else{
                    ultimo.setText("Ultimo grado o semestre cursado: "+persona.getOcupacion().getUltimoGrado());
                }
            }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField culmino;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField escolaridad;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField grado;
    private javax.swing.JTextField institucion;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField ocupacion;
    private javax.swing.JTextField programa;
    private javax.swing.JTextField ultimo;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JTextField createTextField(){
        final javax.swing.JTextField campo = new javax.swing.JTextField();
        campo.setFont(new java.awt.Font("Arial", 0, 20));
        campo.setForeground(new java.awt.Color(102, 102, 102));
        campo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                e.consume();
            }
        });
        campo.addFocusListener(new FocusListenerCopy());
        return campo;
    }
    
    private class FocusListenerCopy implements java.awt.event.FocusListener{

        public void focusGained(java.awt.event.FocusEvent e) {
            javax.swing.JTextField campo = (javax.swing.JTextField)e.getSource();
            String text = campo.getText();
            if(text.compareTo("") != 0){
                int i = text.indexOf(": ");
                if(i > 0){
                    campo.setSelectionStart(i+2);
                    campo.setSelectionEnd(text.length());
                }
            }
        }

        public void focusLost(java.awt.event.FocusEvent e) {}
        
    }
    
    private int getAños(java.sql.Date fecha){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        int añoNacimiento = calendar.get(java.util.Calendar.YEAR);
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - añoNacimiento;
    }
}
