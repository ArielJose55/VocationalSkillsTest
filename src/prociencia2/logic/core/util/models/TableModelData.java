/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.util.models;

import prociencia2.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class TableModelData extends javax.swing.table.AbstractTableModel{

    private java.util.List<Persona> lista;

    public TableModelData() {
        this.lista = null;
    }
    
    public java.util.List<Persona> getLista() {
        return lista;
    }

    public void addListaAndReplace(java.util.List<Persona> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public void addLista(java.util.List<Persona> lista){
        if(this.lista == null){
            this.lista = lista;
            fireTableRowsInserted(0, lista.size());
        }
        this.lista.addAll(lista);
        fireTableRowsInserted(this.lista.size(), this.lista.size() - 1 + lista.size());
        
    }
    
    public Persona getPersona(int fila){
        return lista.get(fila);
    }

    public int getCodigoEstudiante(int fila){
        return lista.get(fila).getCodigo();
    }
    
    @Override
    public int getRowCount() {
        return (lista == null)? 0:lista.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int column){
        if(column == 0 || column == 2 || column == 3 || column == 4){
            return  String.class;
        }else if(column == 5){
            return Boolean.class;
        }else{
            return Integer.class;
        }
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getAtributeFeature(lista.get(rowIndex), columnIndex);
    }
    
    private Object getAtributeFeature(Persona estudiante, int column){
        switch(column){
            case 0: return "   "+estudiante.getNombreCompleto();
            case 1: return getAños(estudiante.getFechaNacimiento());
            case 2: return (estudiante.getSexo().compareTo('M') == 0)? "Masculino":"Femenino";
            case 3: return estudiante.getFechaRegistro().toString().replaceAll("-", "/");
            case 4: return estudiante.getStringDeOcupacion(estudiante.getTipoOcupacion());
            case 5: return estudiante.isProcesado();
            default: return null;
        }
    }
    private int getAños(java.sql.Date fecha){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        int añoNacimiento = calendar.get(java.util.Calendar.YEAR);
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - añoNacimiento;
    }
}
