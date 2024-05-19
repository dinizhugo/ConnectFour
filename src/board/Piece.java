package board;

public abstract class Piece {
    private Board board;
    protected Position position;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "O";
    }
}
