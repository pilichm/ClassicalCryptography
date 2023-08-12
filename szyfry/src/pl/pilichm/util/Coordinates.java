package pl.pilichm.util;

public class Coordinates {
    private int rowIdx;
    private int colIdx;

    public Coordinates(){
        this.rowIdx = -1;
        this.colIdx = -1;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getColIdx() {
        return colIdx;
    }

    public void setRowIdx(int rowIdx) {
        this.rowIdx = rowIdx;
    }

    public void setColIdx(int colIdx) {
        this.colIdx = colIdx;
    }

    @Override
    public String toString() {
        return "Row: " + this.rowIdx + ", col: " + colIdx;
    }
}
