package boardgame;

public class Board {
	private int rows;
	private int columns;	
	private Piece[][] pieces;

	public Board(int rows, int columns) {	
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro creando tabuleiro: � necess�rio que haja pelo menos uma linha e uma coluna");
		}
		
		this.rows = rows;
		this.columns = columns;		
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//uma pe�a e uma posi��o
	public void placePiece(Piece piece, Position position) {
		if(thereIsApiece(position)) {
			throw new BoardException("J� existe uma pe�a nesta posi��o " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	public boolean thereIsApiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posi��o n�o existe no tabuleiro");
		}
		return piece(position) != null;
	}
}
