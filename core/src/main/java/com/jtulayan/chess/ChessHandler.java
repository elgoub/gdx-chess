package com.jtulayan.chess;

import java.util.Scanner;

/**
 * Game Caretaker, in context of Memento Pattern.
 *
 * This handles making and validating chess moves, along with
 * keeping track of the game state.
 *
 * More or less, this will actually handle the backend of the game.
 * No GUI is drawn in this class.
 */
public class ChessHandler {
    public static void main(String[] args) {
        Board b = new Board();

        boolean playing = true;
        Scanner s = new Scanner(System.in);
        while (playing) {
            System.out.println(b);

            String moves = b.listPossibleMoves(b.isWhiteTurn());
            String move = "";

            boolean validLoc = false;
            while (!validLoc) {
                System.out.print("Pick a location: ");
                String loc = "";
                String from = s.nextLine();
                try {
                    AlgebraicNotation.getTileIndex(from);
                    loc += from;
                } catch (Exception e) {
                    continue;
                }
                System.out.print("Pick a destination: ");
                String to = s.nextLine();
                try {
                    AlgebraicNotation.getTileIndex(to);
                    loc += to;
                } catch (Exception e) {
                    continue;
                }

                if (moves.contains(loc)) {
                    move = loc;
                    validLoc = true;
                }
            }

            int moveLoc = moves.indexOf(move);
            System.out.println(b.makeMove(moves.substring(moveLoc, moves.indexOf("/", moveLoc))));
        }
    }
}
