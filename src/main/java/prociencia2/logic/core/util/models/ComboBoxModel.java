/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.util.models;

import prociencia2.logic.core.daos.PersonaDao;

/**
 *
 * @author Klac
 */
public class ComboBoxModel extends javax.swing.DefaultComboBoxModel<Object>{

    private java.util.List lista;
    private int type;
    
    public ComboBoxModel(int type) {
        this.type = type;
        if(type == 0){
            lista = new java.util.ArrayList();
            lista.add("Seleccione una Ocupación");
            lista.add("Estudiante");
            lista.add("Empleado");
            lista.add("Otro");
        }else{
            lista = new java.util.ArrayList();
            lista.add("Seleccione una Fecha");
            try {
                this.lista.addAll(new PersonaDao().getFechas());
            } catch (java.sql.SQLException ex) {
                lista.add("Fecha no obtenidas");
                ex.printStackTrace();
            }
        }
        
    }

    public void update(){
        if(lista.size() >= 0){
            if(type != 0){
                int ultimo = lista.size();
                lista = new java.util.ArrayList();
                fireIntervalRemoved(this, 0, ultimo);
                lista.add("Seleccione una Fecha");
                try {
                    this.lista.addAll(new PersonaDao().getFechas());
                } catch (java.sql.SQLException ex) {
                    lista.add("Fecha no obtenidas");
                    ex.printStackTrace();
                }finally{
                    ultimo = lista.size();
                    fireIntervalAdded(this, 0, ultimo);
                }
            }
        }
    }
    
    @Override
    public Object getElementAt(int index) {
        return (lista == null) ? null : lista.get(index);
    }

    @Override
    public int getSize() {
        return (lista == null) ? 0: lista.size();
    }
    
    }