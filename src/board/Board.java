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
        if (!isThereAPiece(position.getColumn())) {
            pieces[5][position.getColumn()] = piece;
        }else {
            Position lastPiece = LastOccurrencePieceInColumn(position.getColumn());
            pieces[lastPiece.getRow()][lastPiece.getColumn()] = piece;
        }
    }

    public boolean isThereAPiece(int column) {
        if (piece(5, column) != null) {
            return false;
        }
        return true;
    }

    private Position LastOccurrencePieceInColumn(int column) throws BoardException {
        for (int row = pieces.length - 1; row > 0; row--) {
            if (piece(row, column) == null) {
                return new Position(row, column);
            }
        }
        throw new BoardException("The column is already complete, choose another column.");
    }

}
