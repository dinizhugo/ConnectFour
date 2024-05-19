package board;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position (int column) {
        this.row = 5;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
