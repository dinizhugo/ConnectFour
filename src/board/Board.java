package board;

import board.exception.BoardException;

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

    public void placePiece(Piece piece, Position position) throws BoardException {
        if (isColumnFull(position.getColumn())) {
            throw new BoardException("The column " + position.getColumn() + " is already complete, choose another column.");
        }

        if (isThereAPiece(position.getColumn())) {
            pieces[5][position.getColumn()] = piece;
        }else {
            Position lastPiece = LastOccurrencePieceInColumn(position.getColumn());
            pieces[lastPiece.getRow()][lastPiece.getColumn()] = piece;
        }
    }

    public boolean isThereAPiece(int column) {
        return piece(5, column) == null;
    }

    public boolean isColumnFull(int column) {
        int countColumn = 0;
        for (int row = pieces.length - 1; row > -1 ; row--) {
            if (pieces[row][column] != null) {
                countColumn++;
            }
        }
        return (countColumn >= 6);
    }

    public boolean isThereAnyPossiblePlace() {
        int count = 0;
        for (int column = 0; column < getColumns(); column++) {
            if (isColumnFull(column)) {
                count++;
            }
        }
        return (count >= 7);
    }

    private Position LastOccurrencePieceInColumn(int column) {
        Position p = new Position( 0,0);
        for (int row = pieces.length - 1; row > -1; row--) {
            if (piece(row, column) == null) {
                 p.setValues(row, column);
                 break;
            }
        }
        return p;
    }

}
