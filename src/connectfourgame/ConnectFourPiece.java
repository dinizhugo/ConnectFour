package connectfourgame;

import board.Board;
import board.Piece;
import board.Position;

public class ConnectFourPiece extends Piece {
    private Color color;

    public ConnectFourPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
