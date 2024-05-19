package connectfourgame;

import board.Position;
import board.exception.BoardException;
import connectfourgame.exception.GameException;

public class ConnectFourPosition {
    private char column;

    public ConnectFourPosition(char column) throws GameException {
        if (column < 'a' || column > 'g') {
            throw new GameException("Error instantiating ConnectFourPosition. Valid values are from A to G");
        }
        this.column = column;
    }

    public char getColumn() {
        return column;
    }

    public Position toPosition() {
        return new Position(5, column - 'a');
    }
}
