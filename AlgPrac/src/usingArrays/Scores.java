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
	
	
}
