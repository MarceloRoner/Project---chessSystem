package Aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChassMatch;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChassMatch chessMatch = new ChassMatch(); // Criar uma instância de ChassMatch
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMatch()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured); // Chamar o método printBoard() da classe UI
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				if (chessMatch.getPromoted() != null) {
					System.out.println("Digite a peça escolhida para promoção (B/R/Q/H): ");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("H") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Valor inválido, digite novamente para alguma dessas 4 peças: (B/R/Q/H): ");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
