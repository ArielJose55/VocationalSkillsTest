/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.model;


import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.util.models.TableModelData;

/**
 *
 * @author Klac
 */
public class ControlModelAdministrador {
    
    private static ControlModelAdministrador logicAdministador = null;
    
    private final javax.swing.table.TableRowSorter<TableModelData> tableRowSorter;
    
    private javax.swing.RowFilter<TableModelData,Integer> rowFieldSearch;
    private javax.swing.RowFilter<TableModelData,Integer> rowFilterDate;
    private javax.swing.RowFilter<TableModelData,Integer> rowfilterOcupation;
    private javax.swing.RowFilter<TableModelData,Integer> rowFilterProcess;
    
    private String filterNames;
    private String filterOcupation;
    private String filterDate;
    private Boolean filterProcess;

    private ControlModelAdministrador() {
        tableRowSorter = new javax.swing.table.TableRowSorter<TableModelData>(ControlModel.getInstance().getTableModel());
        initComponentsFilter();
    }
    
    static ControlModelAdministrador getInstance(){
        if(logicAdministador == null){
            logicAdministador = new ControlModelAdministrador();
        }
        return logicAdministador;
    }

    static void destructControlModelAdministrador(){
        logicAdministador = null;
    }
    
    public javax.swing.table.TableRowSorter<TableModelData> getTableRowSorter() {
        return tableRowSorter;
    }

    public void setFilterNames(String filterNames) {
        this.filterNames = filterNames;
    }

    public void setFilterOcupation(String filterOcupation) {
        this.filterOcupation = filterOcupation;
    }

    public void setFilterDate(String filterDate) {
        this.filterDate = filterDate;
    }
    

    public void setFilterProcess(Boolean filterProcess) {
        this.filterProcess = filterProcess;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------
    
    private void initComponentsFilter(){
        rowFieldSearch = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterNames) || compateTo("Buscar", filterNames)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                return isNotNull(persona.getNombreCompleto()) && compareOrContains(persona.getNombreCompleto(), filterNames);
            }
        };
        
        rowFilterDate = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterDate) || compateTo("Seleccione una fecha", filterDate)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona estudiante = modelo.getPersona(entrada.getIdentifier());
                return compateTo(estudiante.getFechaRegistro().toString(), filterDate);
            }
        };
        
        rowfilterOcupation = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterOcupation)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona estudiante = modelo.getPersona(entrada.getIdentifier());
                return isNotNull(estudiante.getStringDeOcupacion(estudiante.getTipoOcupacion())) 
                        && compareOrContains(estudiante.getStringDeOcupacion(estudiante.getTipoOcupacion()), filterOcupation);
            }
        };
        
        
        rowFilterProcess = new javax.swing.RowFilter<TableModelData, Integer>(){
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterProcess)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                if(filterProcess.compareTo(Boolean.TRUE) == 0){
                    return isNotNull(persona.isProcesado()) && compareTo(!persona.isProcesado(), filterProcess);
                }else{
                    return true;
                }
            }
        };
    }
    
//    --------------------------------------------------------------------------------------------------------
    
    public boolean isNotNull(Boolean entero){
        return entero != null;
    }
    
    private boolean isNotNull(Character ch){
        return ch != null;
    }
    
    public boolean compareTo(Boolean entero, Boolean entero2){
        return entero.compareTo(entero2) == 0;
    }
    
    private boolean isNotNull(String filter){
        return filter != null && filter.compareTo("") != 0;
    }
    
    private boolean compateTo(Character ch1, Character ch2){
        return ch1.compareTo(ch2) == 0;
    }
    
    private boolean compareOrContains(String textOrigen,String textDestine) {
        return textOrigen.toLowerCase().replace(" ", "").contains(textDestine.toLowerCase().replace(" ", ""));
    }
    
    private boolean compateTo(String textOrigen,String textDestine){
        return textOrigen.toLowerCase().replace(" ", "").compareTo(textDestine.toLowerCase().replace(" ", "")) == 0;
    }
    
//    -----------------------------------------------------------------------------------------------------------
    
    public void startFiltering(){
     /*1*/   if(isNotNull(filterProcess) && isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(4);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowfilterOcupation);
                select.add(rowFilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
     /*2*/    }else if(isNotNull(filterProcess) && isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowfilterOcupation);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*3*/     }else if(isNotNull(filterProcess) && !isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowFilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*4*/     }else if(isNotNull(filterProcess) && !isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*5*/     }else if(!isNotNull(filterProcess) && isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowfilterOcupation);
                select.add(rowFilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*6*/     }else if(!isNotNull(filterProcess) && isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowfilterOcupation);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
     /*7*/    }else if(!isNotNull(filterProcess) && !isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowFilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*8*/     }else{
                tableRowSorter.setRowFilter(rowFieldSearch);
    /**/      }
    }

}
