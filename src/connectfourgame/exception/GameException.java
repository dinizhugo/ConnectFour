package connectfourgame.exception;

import board.exception.BoardException;

public class GameException extends BoardException {
    public GameException(String msg) {
        super(msg);
    }
}
