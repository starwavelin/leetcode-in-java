package ood;

public class TicTacToe {
	
	public static final int X = 1, O = -1;	// two players X and O
	public static final int EMPTY = 0;		// use 0 to denote an empty cell
	private int board[][] = new int[3][3];	// game board
	private int player;						// the current player
	
	// constructor
	public TicTacToe() {
		clearBoard();
	}
	
	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY; 
			}
		}
		player = X;		// X is the first player by default
	}
	
	// Puts an X or O mark at position (i, j)
	public void putMark(int i, int j) throws IllegalArgumentException {
		if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
			throw new IllegalArgumentException("Invalid Board Position");
		}
		if (board[i][j] != EMPTY) {
			throw new IllegalArgumentException("Board Position occupied");
		}
		board[i][j] = player;		// place mark for the current player
		player = -player;			// switch player [use the fact that X = -O]
	}
	
	// Check if the board configuration is a Win situation for a player
	public boolean isWin(int mark) {
		boolean ret = ((board[0][0] + board[0][1] + board[0][2] == mark * 3)	// row 0
				|| (board[1][0] + board[1][1] + board[1][2] == mark * 3)		// row 1
				|| (board[2][0] + board[2][1] + board[2][2] == mark * 3)		// row 2
				|| (board[0][0] + board[1][0] + board[2][0] == mark * 3)		// col 0
				|| (board[0][1] + board[1][1] + board[2][1] == mark * 3)		// col 1
				|| (board[0][2] + board[1][2] + board[2][2] == mark * 3)		// col 2
				|| (board[0][0] + board[1][1] + board[2][2] == mark * 3)		// diagonal
				|| (board[0][2] + board[1][1] + board[2][0] == mark * 3)		// diagonal
				);
		return ret;
	}
	
	// Returns the winning player or 0 indicates a tie
	public int winner() {
		if (isWin(X)) {
			return X;
		} else if (isWin(O)) {
			return O;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch(board[i][j]) {
				case X: 
					s += "X";
					break;
				case O:
					s += "O";
					break;
				case EMPTY:
					s += " ";
					break;
				}
				if (j < 2) {
					s += "|";	// column boundary
				}
			}
			if (i < 2) {
				s += "\n------\n"; // row boundary
			}
		}
		return s;
	}
	
}
