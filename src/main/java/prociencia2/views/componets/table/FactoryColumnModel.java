/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.views.componets.table;

/**
 *
 * @author Klac
 */
public class FactoryColumnModel {
    
    public static javax.swing.table.TableColumnModel createModelColumnTableMain(){
        javax.swing.table.DefaultTableColumnModel tablaColumn = new  javax.swing.table.DefaultTableColumnModel();
        tablaColumn.setColumnMargin(0);
        int ancho[] ={330,70,90,100,150,80};
        String cabeceras[] = {"  Nombres","Edad","Sexo","Fecha","Ocupacion","Procesado"}; 
        for(int i = 0; i < cabeceras.length ; i++){
                javax.swing.table.TableColumn columna = new javax.swing.table.TableColumn(i,ancho[i]);
                columna.setHeaderValue(cabeceras[i]);
                javax.swing.table.DefaultTableCellRenderer rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(-1, TypeTable.TABLE_MAIN);
                columna.setHeaderRenderer(rowRenderer);
                if(i == 5){
                    rowRenderer = FactoryCellTableRenderer.createTableCellRendererProcess();
                }else{
                    rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(i, TypeTable.TABLE_MAIN);
                }
                columna.setCellRenderer(rowRenderer);
                tablaColumn.addColumn(columna);
        }
        return tablaColumn;
    }
    
    public static javax.swing.table.TableColumnModel createModelColumnTableToChart(){
        javax.swing.table.DefaultTableColumnModel tablaColumn = new  javax.swing.table.DefaultTableColumnModel();
        tablaColumn.setColumnMargin(0);
        int ancho[] ={100,10,20};
        String cabeceras[] = {"Area","PD","Clave"}; 
        for(int i = 0; i < 3 ; i++){
                javax.swing.table.TableColumn columna = new javax.swing.table.TableColumn(i,ancho[i]);
                columna.setHeaderValue(cabeceras[i]);
                javax.swing.table.DefaultTableCellRenderer rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(-1, TypeTable.TABLE_VIEW_CHART);
                columna.setHeaderRenderer(rowRenderer);
                rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(i, TypeTable.TABLE_VIEW_CHART);
                columna.setCellRenderer(rowRenderer);
                tablaColumn.addColumn(columna);
        }
        return tablaColumn;
    } 
    public static javax.swing.table.TableColumnModel createModelColumnTableRegistro(){
        javax.swing.table.DefaultTableColumnModel tablaColumn = new  javax.swing.table.DefaultTableColumnModel();
        tablaColumn.setColumnMargin(0);
        int ancho[] ={350,60,150,200};
        String cabeceras[] = {"NOMBRES","EDAD","OCUPACIÓN","FECHA DE REGISTRO"};
        for(int i = 0; i < 4 ; i++){
                javax.swing.table.TableColumn columna = new javax.swing.table.TableColumn(i,ancho[i]);
                columna.setHeaderValue(cabeceras[i]);
                javax.swing.table.DefaultTableCellRenderer rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(-1, TypeTable.TABLE_MAIN);
                columna.setHeaderRenderer(rowRenderer);
                rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(i, TypeTable.TABLE_MAIN);
                columna.setCellRenderer(rowRenderer);
                tablaColumn.addColumn(columna);
        }
        return tablaColumn;
    }
}
