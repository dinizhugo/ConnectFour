package connectfourgame;

import board.Board;
import board.Position;
import board.exception.BoardException;
import connectfourgame.exception.GameException;

public class ConnectFourMatch {
    private Color currentPlayer;
    private String winner;
    private int turn;
    private final Board board;

    public ConnectFourMatch() {
        this.board = new Board(6, 7);
        this.currentPlayer = Color.RED;
        this.turn = 1;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public String getWinner() {
        return winner;
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
        validatePosition(position.toPosition());
        board.placePiece(new ConnectFourPiece(board, getCurrentPlayer()), position.toPosition());

        if (!board.isThereAnyPossiblePlace()) {this.winner = "Draw";}

        checkWin();

        if (getWinner() == null) {nextTurn();}
    }

    private void checkWin() {
        ConnectFourPiece[][] pieces = getAllPieces();

        //Horizontally
        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces[row].length - 3; column++) {
                if (pieces[row][column] != null) {
                    if (pieces[row][column + 1] != null &&
                            pieces[row][column + 2] != null &&
                            pieces[row][column + 3] != null &&
                            pieces[row][column].getColor() == pieces[row][column + 1].getColor() &&
                            pieces[row][column + 1].getColor() == pieces[row][column + 2].getColor() &&
                            pieces[row][column + 2].getColor() == pieces[row][column + 3].getColor()) {

                        setWinner(row,column);
                        return;
                    }
                }
            }
        }

        //Vertically
        for (int column = 0; column < pieces[0].length; column++) {
            for (int row = 0; row < pieces.length - 3; row++) {
                if (pieces[row][column] != null) {
                    if (pieces[row + 1][column] != null &&
                            pieces[row + 2][column] != null &&
                            pieces[row + 3][column] != null &&
                            pieces[row][column].getColor() == pieces[row + 1][column].getColor() &&
                            pieces[row + 1][column].getColor() == pieces[row + 2][column].getColor() &&
                            pieces[row + 2][column].getColor() == pieces[row + 3][column].getColor()) {
                        setWinner(row,column);
                        return;

                    }
                }
            }
        }

        //DiagonallyDescending

        for (int row = 0; row < pieces.length - 3; row++) {
            for (int column = 0; column < pieces[row].length - 3; column++) {
                if (pieces[row][column] != null) {
                    if (pieces[row + 1][column + 1] != null &&
                            pieces[row + 2][column + 2] != null &&
                            pieces[row + 3][column + 3] != null &&
                            pieces[row][column].getColor() == pieces[row + 1][column + 1].getColor() &&
                            pieces[row + 1][column + 1].getColor() == pieces[row + 2][column + 2].getColor() &&
                            pieces[row + 2][column + 2].getColor() == pieces[row + 3][column + 3].getColor()) {
                        setWinner(row,column);
                        return;
                    }
                }
            }
        }

        //DiagonalAscending

        for (int row = 3; row < pieces.length; row++) {
            for (int column = 0; column < pieces[row].length - 3; column++) {
                if (pieces[row][column] != null) {
                    if (pieces[row - 1][column + 1] != null &&
                            pieces[row - 2][column + 2] != null &&
                            pieces[row - 3][column + 3] != null &&
                            pieces[row][column].getColor() == pieces[row - 1][column + 1].getColor() &&
                            pieces[row - 1][column + 1].getColor() == pieces[row - 2][column + 2].getColor() &&
                            pieces[row - 2][column + 2].getColor() == pieces[row - 3][column + 3].getColor()) {
                        setWinner(row,column);
                        return;
                    }
                }
            }
        }
    }

    private void setWinner(int row, int column) {
        ConnectFourPiece[][] pieces = getAllPieces();
        if (pieces[row][column].getColor() == Color.RED) {
            this.winner = Color.RED.toString();
            return;
        }
        this.winner = Color.YELLOW.toString();
    }
}
