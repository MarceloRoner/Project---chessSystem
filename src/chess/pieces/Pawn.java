package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];

		int direction = (getColor() == Color.WHITE) ? -1 : 1; // Define a direção de avanço do peão

		Position p = new Position(position.getRow() + direction, position.getColum());

		// Verifica se pode avançar uma casa
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;

			// Verifica se pode avançar duas casas (se ainda não se moveu)
			if (getMoveCount() == 0) {
				p.setValues(p.getRow() + direction, p.getColum());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColum()] = true;
				}
			}
		}

		// Verifica captura diagonal esquerda
		p.setValues(position.getRow() + direction, position.getColum() - 1);
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		// Verifica captura diagonal direita
		p.setValues(position.getRow() + direction, position.getColum() + 1);
		if (getBoard().positionExists(p) && isThereOponnentPiece(p)) {
			mat[p.getRow()][p.getColum()] = true;
		}

		return mat;
	}

	

	@Override
	public String toString() {
		return "P";
	}
}
