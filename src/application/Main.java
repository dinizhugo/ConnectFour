package application;

import connectfourgame.ConnectFourMatch;

public class Main {
    public static void main(String[] args) {
        ConnectFourMatch connectFourMatch = new ConnectFourMatch();
        UI.printBoard(connectFourMatch.getAllPieces());
    }
}
