package Aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChassMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChassMatch chessMatch = new ChassMatch(); // Criar uma instância de ChassMatch

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces()); // Chamar o método printBoard() da classe UI
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
