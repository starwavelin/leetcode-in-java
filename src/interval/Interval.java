package interval;

/**
 * Structure class for
 * 56. Merge Intervals 
 * 57. Insert Interval
 */


/* Define Interval class */
public class Interval {
	
	public int start;
	public int end;
	
	public Interval () {
		start = 0;
		end = 0;
	}

	public Interval (int s, int e) {
		start = s;
		end = e;
	}
}