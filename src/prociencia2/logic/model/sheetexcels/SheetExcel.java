/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.model.sheetexcels;

import java.util.List;

/**
 *
 * @author Klac
 */
class SheetExcel {
    
    private final int index;
    private final java.util.List<CellExcel> listCell;

    SheetExcel(int index) {
        this.index = index;
        listCell = new java.util.ArrayList<CellExcel>();
    }

    int getIndex() {
        return index;
    }

    List<CellExcel> getListCell() {
        return listCell;
    }
        
}
