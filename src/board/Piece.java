package board;

public abstract class Piece {
    private Board board;
    protected Position position;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }


    @Override
    public String toString() {
        return "O";
    }
}
