package connectfourgame;

import board.Board;
import board.Piece;
import board.Position;
import board.exception.BoardException;
import connectfourgame.exception.GameException;

public class ConnectFourMatch {
    private Color currentPlayer;
    private int turn;
    private Board board;

    public ConnectFourMatch() {
        this.board = new Board(6, 7);
        this.currentPlayer = Color.RED;
        this.turn = 1;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
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

    private void validatePosition(Position position) throws GameException {
        if (board.isColumnFull(position.getColumn())) {
            throw new GameException("The column is already complete, choose another column.");
        }
    }

    private void nextTurn() {
        this.turn++;
        currentPlayer = (currentPlayer == Color.RED) ? Color.YELLOW : Color.RED;
    }


    public void placePiece(ConnectFourPosition position) throws BoardException {
        if (board.isThereAnyPossiblePlace()) {
            throw new GameException("TA CHEIO");
        }
        validatePosition(position.toPosition());
        board.placePiece(new ConnectFourPiece(board, getCurrentPlayer()), position.toPosition());
        nextTurn();
    }
}
