package graph;

/**
 * @author xianlin
 *								Order of Growth for n sites (worst case)
 *	Algorithm					Constructor		Union		Find
 * 1. Quick Find					O(n)				O(n)			O(1)
 * 2. Quick Union				O(n)				O(h)			O(h)
 * 3. Weighted Quick Union		O(n)				O(logn)		O(logn)
 * 4. WQN with path compression	O(n)				Amortized O(1)
 */
public class UnionFind1 {
	
	private int[] id;	// access to component id (site indexed)
	private int count; 	// number of components
	
	public UnionFind1(int n) {
		// initialize component id array
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		return id[p];
	}
	
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			return;
		}
		
		//Core
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
		
		count--;
	}
}
