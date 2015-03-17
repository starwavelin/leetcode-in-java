package usingArrays;

public class Scores {
	
	public static final int maxEntries = 10;
	
	private int numEntries;
	private GameEntry[] entries;
	
	public Scores() {
		entries = new GameEntry[maxEntries];
		numEntries = 0;
	}
	
	public String toString() {
		String s = "[";
		for (int i = 0; i < numEntries; i++) {
			if (i > 0) {
				s += ","; // separate entries by commas
			}
			s += entries[i];
		}
		return s + "]";
	}

	// methods for updating the set of high scores as follows
	
	public void add(GameEntry e) {
		int newScore = e.getScore();
		
		// is newScore really a high score;
		if (numEntries == maxEntries) {		// if array is full
			if (newScore <= entries[numEntries - 1].getScore()) {
				return;	// the newScore is not a high score in this case
			}			
		} else {
			numEntries++;
		}
		
		int i;
		for (i = numEntries - 1; (i > 0) && (e.getScore() > entries[i - 1].getScore()); i--) {
			entries[i] = entries[i - 1];
		}
		entries[i] = e;
	}
	
	
	public GameEntry remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= numEntries) {
			throw new IndexOutOfBoundsException("invalid index " + i);
		}
		GameEntry toRemove = entries[i];
		int j;
		for (j = i; j < numEntries - 1; j++) {
			entries[j] = entries[j + 1];
		}
		entries[numEntries - 1] = null; // nullify the current last entry
		numEntries--;
		return toRemove;
	}
}

class IndexOutOfBoundsException extends RuntimeException {
	public IndexOutOfBoundsException() {
		super();
	}
	
	public IndexOutOfBoundsException(String msg) {
		super(msg);
	}
}