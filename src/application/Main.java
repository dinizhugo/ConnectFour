package application;

import connectfourgame.ConnectFourMatch;
import connectfourgame.ConnectFourPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectFourMatch connectFourMatch = new ConnectFourMatch();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(connectFourMatch.getAllPieces());
                System.out.print("Digite uma coluna: ");
                ConnectFourPosition position = UI.readChessPosition(sc);
                connectFourMatch.placePiece(position);
            }catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
