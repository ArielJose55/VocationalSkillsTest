package prociencia2.logic.model.sheetexcels;

import prociencia2.logic.core.daos.TestDao;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.entities.Test;

/**
 *
 * @author Klac
 */
public class UpdateExcelStudent {
    
    private final Persona persona;
    private final java.io.File parent;

    public UpdateExcelStudent(java.io.File parent, Persona estudiante) {
        this.parent = parent;
        this.persona = estudiante;
    }
    
    private java.util.List<Test> getTestFromDataBase() throws java.sql.SQLException{
        TestDao testDao = new TestDao();
        return testDao.getTesOfStudent(persona.getCodigo());
    }
    
    public void beginningWriting() throws Exception{
        Test intereses,aptitudes;
        intereses = aptitudes = null;
        for(Test test : getTestFromDataBase()){
            if(test.getNombre().compareTo("Aptitudes Vocacionales") == 0){
                aptitudes = test;
            }else if(test.getNombre().compareTo("Intereses Ocupacionales") == 0){
                intereses = test;
            }else{
                throw new Exception("La obtenciÃ³n de pruebas ocupaciones ha fallado");
            }
        }
        java.util.List<SheetExcel> list = putSheetExcelFromXML();
        org.apache.poi.hssf.usermodel.HSSFWorkbook workbook = 
                new org.apache.poi.hssf.usermodel.HSSFWorkbook(UpdateExcelStudent.class.getResourceAsStream("Intereses y Aptitudes.xls"));      
        
        for(SheetExcel sheetXML : list){
            org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.getSheetAt(sheetXML.getIndex());
            workbook.setActiveSheet(sheetXML.getIndex());
            for(CellExcel cellXML : sheetXML.getListCell()){
                org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(cellXML.getRow()).getCell(cellXML.getColumn());
                cell.setAsActiveCell();
                setAttributeStudent(intereses , aptitudes ,cell, sheetXML.getIndex(), cellXML.getRow(), cellXML.getColumn());
            }  
            sheet.setForceFormulaRecalculation(true);
        }
       
        java.io.FileOutputStream outFile =new java.io.FileOutputStream(new java.io.File(parent, persona.getNombreCompleto()+".xls"));
        workbook.write(outFile);
        outFile.close();
    }
   
    private void setAttributeStudent(Test testIntereses , Test testAptitudes , org.apache.poi.ss.usermodel.Cell cell , int sheet , int row , int column){
        switch(sheet){
            case 0:{
                switch(row){
                    case 4: {
                        cell.setCellValue(persona.getNombreCompleto());
                        break;
                    }

                    case 8: {
                        cell.setCellValue(persona.getFechaNacimiento().toString().replace("-", "/"));
                        break;
                    }
                    case 10: {
                        cell.setCellValue(getAños(persona.getFechaNacimiento()));
                        break;
                    }
                    case 12: {
                        cell.setCellValue(persona.getSexo().toString());
                        break;
                    }
                    case 14: {
                        cell.setCellValue(persona.getStringDeOcupacion(persona.getTipoOcupacion()));
                        break;
                    }
                    case 16: {
                        cell.setCellValue(persona.getFechaRegistro().toString().replace("-", "/"));
                        break;
                    }
                    case 20: {
                        cell.setCellValue( persona.getLugar());
                        break;
                    }
                }
                break;
            }
            case 1:{
                if(row == 10){
                    switch(column){
                        case 1: {
                            cell.setCellValue(testIntereses.getSecciones().get(0).getSumatoria());
                            break;
                        }
                        case 4: {
                            cell.setCellValue(testIntereses.getSecciones().get(1).getSumatoria());
                            break;
                        }
                        case 7: {
                            cell.setCellValue( testIntereses.getSecciones().get(2).getSumatoria());
                            break;
                        }
                        case 10: {
                            cell.setCellValue(testIntereses.getSecciones().get(3).getSumatoria());
                            break;
                        }
                        case 13: {
                            cell.setCellValue(testIntereses.getSecciones().get(4).getSumatoria());
                            break;
                        }
                        case 16: {
                            cell.setCellValue(testIntereses.getSecciones().get(5).getSumatoria());
                            break;
                        }
                    }
                    
                }else{
                    switch(column){
                        case 1: {
                            cell.setCellValue(testIntereses.getSecciones().get(6).getSumatoria());
                            break;
                        }
                        case 4: {
                            cell.setCellValue(testIntereses.getSecciones().get(7).getSumatoria());
                            break;
                        }
                        case 7: {
                            cell.setCellValue(testIntereses.getSecciones().get(8).getSumatoria());
                            break;
                        }
                        case 10: {
                            cell.setCellValue(testIntereses.getSecciones().get(9).getSumatoria());
                            break;
                        }
                    }
                }
                break;
            }
            default:{
                if(row == 9){ //verdavera
                    switch(column){
                        case 1: {
                            cell.setCellValue(testAptitudes.getSecciones().get(0).getSumatoria());
                            break;
                        }
                        case 4: {
                            cell.setCellValue(testAptitudes.getSecciones().get(1).getSumatoria());
                            break;
                        }
                        case 7: {
                            cell.setCellValue(testAptitudes.getSecciones().get(2).getSumatoria());
                            break;
                        }
                        case 10: {
                            cell.setCellValue(testAptitudes.getSecciones().get(3).getSumatoria());
                            break;
                        }
                        case 13: {
                            cell.setCellValue(testAptitudes.getSecciones().get(4).getSumatoria());
                            break;
                        }
                        case 16: {
                            cell.setCellValue(testAptitudes.getSecciones().get(5).getSumatoria());
                            break;
                        }
                    }
                }else{
                    switch(column){ //verdavera
                        case 1: {
                            cell.setCellValue(testAptitudes.getSecciones().get(6).getSumatoria());
                            break;
                        }
                        case 4: {
                            cell.setCellValue(testAptitudes.getSecciones().get(7).getSumatoria());
                            break;
                        }
                        case 7: {
                            cell.setCellValue(testAptitudes.getSecciones().get(8).getSumatoria());
                            break;
                        }
                        case 10: {
                            cell.setCellValue(testAptitudes.getSecciones().get(9).getSumatoria());
                            break;
                        }
                        case 13: {
                            cell.setCellValue(testAptitudes.getSecciones().get(10).getSumatoria());
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private java.util.List<SheetExcel> putSheetExcelFromXML() throws Exception{
        final java.util.List<SheetExcel> listSheet = new java.util.ArrayList<SheetExcel>();
        org.jdom2.Document documento = new org.jdom2.input.SAXBuilder().build(UpdateExcelStudent.class.getResource("PropertiesSheetExcel.xml"));
        org.jdom2.Element root = documento.getRootElement();
        for(org.jdom2.Element sheetChild : root.getChildren()){
            SheetExcel sheet = new SheetExcel(Integer.parseInt(sheetChild.getAttributeValue("number")));
            for(org.jdom2.Element cellChild:sheetChild.getChildren()){
                sheet.getListCell().add(new CellExcel(
                        Integer.parseInt(cellChild.getAttributeValue("row")), Integer.parseInt(cellChild.getTextNormalize())));
            }
            listSheet.add(sheet);
        }
        return listSheet;
    }
    
    private Integer getAños(java.sql.Date fecha){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        int añoNacimiento = calendar.get(java.util.Calendar.YEAR);
        return new Integer(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - añoNacimiento);
    }
}
