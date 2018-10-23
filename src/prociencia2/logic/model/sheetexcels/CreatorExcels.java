/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.model.sheetexcels;

import prociencia2.logic.core.daos.PersonaDao;
import prociencia2.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class CreatorExcels {
    
    private final java.io.File parent;
    private final java.util.List<Persona> lista;
    private String alert;

    public CreatorExcels(java.io.File parent, java.util.List<Persona> lista,boolean updateProcess) {
        this.parent = parent;
        this.lista = lista;
        this.alert = "";
        updatePersonProccess(updateProcess);
    }
    
    private void updatePersonProccess(boolean start) {
        if(start){
            try{
                new PersonaDao().uptateProcessPerson(lista);
            }catch(java.sql.SQLException ex){
                alert = "Ooops! Los registros no fueron correctamente marcados como procesados";
            }
        }
    }
    
    public void startWriting() throws Exception{
        for(Persona person : lista){
            UpdateExcelStudent excelWriter = new UpdateExcelStudent(parent, person);
            excelWriter.beginningWriting();
        }
    }
    
    public String getAlertsAndWarning(){
        return alert;
    }
}
