package graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import utility.UGNode;
/***************************************************************************
* Problem No. : 133
* Problem Name: Clone Graph
* Problem URL : https://leetcode.com/problems/clone-graph/description/
* Date        : Jan 17 2018
* Author	  	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Clone a graph and return the entry node of the cloned graph.
* 	Assumption:
* 		
	Example: 
* 	Input:
* 		1--2
* 		|  |
* 		3--4	 
* 	Output: 
* 		1'--2'
* 		|  |
* 		3'--4'
* 	should return 1'
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-graph, tag-bfs, tag-dfs
***************************************************************************/
public class CloneGraph {

	public static class BFSSol {
		public UGNode clone(UGNode node) {
			if (node == null) {
				return null;
			}
			return bfs(node);
		}
		private UGNode bfs(UGNode node) {
			Map<UGNode, UGNode> map = new HashMap<>();
			map.put(node, new UGNode(node.val));
			Queue<UGNode> q = new ArrayDeque<>();
			q.offer(node);
			while (!q.isEmpty()) {
				UGNode cur = q.poll();
				for(UGNode nei: cur.neighbors) {
					UGNode newNei = map.get(nei);
					if (newNei == null) {
						map.put(nei, new UGNode(nei.val));
						q.offer(nei);
					}
					map.get(cur).neighbors.add(map.get(nei));
				}
			}
			return map.get(node);
		}
	}
	
	public static class DFSSol {
		
	}
	
	public static void main(String[] args) {
		/* Construct the original graph */
		UGNode one = new UGNode(1);
		UGNode two = new UGNode(2);
		UGNode three = new UGNode(3);
		UGNode four = new UGNode(4);
		one.neighbors.add(two);
		one.neighbors.add(three);
		two.neighbors.add(one);
		two.neighbors.add(four);
		three.neighbors.add(one);
		three.neighbors.add(four);
		four.neighbors.add(two);
		four.neighbors.add(three);

		BFSSol bfsSol = new BFSSol();
		System.out.println("Entry point of cloned graph: " + bfsSol.clone(one).val);
		
	}
}
