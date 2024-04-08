package Aplication;

import boardgame.Board;
import boardgame.Position;
import chess.ChassMatch;

public class Program {

	public static void main(String[] args) {
	
		ChassMatch chessmatch = new ChassMatch();
		UI.printBoard(chessmatch.getPieces());;
		
		
	}

} 
