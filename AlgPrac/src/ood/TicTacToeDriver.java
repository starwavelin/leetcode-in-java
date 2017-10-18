package ood;

public class TicTacToeDriver {
	
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		
		/* X moves */				/* O moves */
		ttt.putMark(1, 1);			ttt.putMark(0, 2);
		ttt.putMark(2, 2); 			ttt.putMark(0, 0);
		ttt.putMark(0, 1); 			ttt.putMark(2, 1);
		ttt.putMark(1, 2); 			ttt.putMark(1, 0);
		ttt.putMark(2, 0);
		
		System.out.println(ttt.toString());
		int winningPlayer = ttt.winner();
		if (winningPlayer != 0) {
			System.out.println(winningPlayer + " Wins");
		} else {
			System.out.println("Tie");
		}
	}
	
}
