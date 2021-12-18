package aplicacao;

import chess.ChessMatch;

public class Programa {

	public static void main(String[] args) {
	
		ChessMatch chessMat = new ChessMatch();
		UI.printBoard(chessMat.getPieces());
	}

}
