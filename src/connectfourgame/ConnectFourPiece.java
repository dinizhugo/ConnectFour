package connectfourgame;

import board.Board;
import board.Piece;
import board.Position;

public class ConnectFourPiece extends Piece {
    private Color color;

    public ConnectFourPiece(Board board, Position position, Color color) {
        super(board, position);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
