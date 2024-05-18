package connectfourgame;

import board.Board;

public class ConnectFourMatch {
    private Board board;

    public ConnectFourMatch() {
        this.board = new Board(6, 7);
    }

    public ConnectFourPiece[][] getAllPieces() {
        ConnectFourPiece[][] pieces = new ConnectFourPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                pieces[i][j] = (ConnectFourPiece) board.piece(i, j);
            }
        }
        return pieces;
    }
}
