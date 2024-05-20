package application;

import connectfourgame.Color;
import connectfourgame.ConnectFourMatch;
import connectfourgame.ConnectFourPiece;
import connectfourgame.ConnectFourPosition;
import connectfourgame.exception.GameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static void printBoard(ConnectFourPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                printPieces(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println(" A   B   C   D   E   F   G");
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static ConnectFourPosition readChessPosition(Scanner sc) throws GameException {
        try {
            String s = sc.nextLine().toLowerCase();
            char column = s.charAt(0);
            return new ConnectFourPosition(column);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading Position. Valid values are from A to G.");
        }
    }

    public static void printMatch(ConnectFourMatch match) {
        printBoard(match.getAllPieces());
        System.out.println();
        if (match.getWinner() == null) {
            System.out.println("ROUND: " + match.getTurn());
            System.out.println("TURN: " + match.getCurrentPlayer());
        } else {
            System.out.println("WINNER: " + match.getWinner());
            System.out.println("TOTAL ROUNDS: " + match.getTurn());
        }
    }

    private static void printPieces(ConnectFourPiece piece) {
        if (piece == null) {
            System.out.print("[-]");
        } else {
            if (piece.getColor() == Color.RED) {
                System.out.print("[" + ANSI_RED + piece + ANSI_RESET + "]");
            }else {
                System.out.print("[" + ANSI_YELLOW + piece + ANSI_RESET + "]");
            }
        }
        System.out.print(" ");
    }
}
