package board;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public Piece piece(int row, int columns) {
        return pieces[row][columns];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

}
