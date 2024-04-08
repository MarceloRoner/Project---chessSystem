package boardgame;

public class Board {
	private int rows;
	private int colums;
	private Piece[][] pieces;
	public Board(int rows, int colums) {
		
		this.rows = rows;
		this.colums = colums;
		
		pieces = new Piece[rows][colums];
	}
	
}
