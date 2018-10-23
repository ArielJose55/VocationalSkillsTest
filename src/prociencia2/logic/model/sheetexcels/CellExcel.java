/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.model.sheetexcels;

/**
 *
 * @author Klac
 */
class CellExcel {
    
    private final int row;
    private final int column;

    CellExcel(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
