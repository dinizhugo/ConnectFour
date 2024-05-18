package board;

public abstract class Piece {
    private Board board;
    protected Position position;

    public Piece(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
