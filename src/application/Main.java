package application;

import connectfourgame.ConnectFourMatch;
import connectfourgame.ConnectFourPosition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectFourMatch connectFourMatch = new ConnectFourMatch();
        Scanner sc = new Scanner(System.in);

        while (connectFourMatch.getWinner() == null) {
            try {
                UI.clearScreen();
                UI.printMatch(connectFourMatch);
                System.out.print("Digite uma coluna: ");
                ConnectFourPosition position = UI.readChessPosition(sc);
                connectFourMatch.placePiece(position);
            }catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(connectFourMatch);
    }
}
