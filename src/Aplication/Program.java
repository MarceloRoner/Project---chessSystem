package Aplication;

import boardgame.Board;
import boardgame.Position;
import chess.ChassMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChassMatch chessMatch = new ChassMatch(); // Criar uma instância de ChassMatch

		while (true) {
			chessMatch.printBoard(); // Chamar o método printBoard() na instância de ChassMatch
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);

			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);

			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}

	}

}
