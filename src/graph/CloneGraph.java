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
* Author      :	@codingbro
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
*
* Think: How to unit test Clone Graph?
* 	Some research:
* 	1. https://stackoverflow.com/questions/43538038/how-to-junit-test-my-cloning-method
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
			map.put(node, new UGNode(node.label));
			Queue<UGNode> q = new ArrayDeque<>();
			q.offer(node);
			while (!q.isEmpty()) {
				UGNode cur = q.poll();
				for(UGNode nei: cur.neighbors) {
					UGNode newNei = map.get(nei);
					if (newNei == null) {
						map.put(nei, new UGNode(nei.label));
						q.offer(nei);
					}
					map.get(cur).neighbors.add(map.get(nei));
				}
			}
			return map.get(node);
		}
	}

	public static class DFSSol {
		public UGNode clone(UGNode node) {
			if (node == null) {
				return null;
			}
			Map<UGNode, UGNode> map = new HashMap<>();
			return dfs(node, map);
		}
		private UGNode dfs(UGNode node, Map<UGNode, UGNode> map) {
			map.put(node, new UGNode(node.label));
			for (UGNode nei : node.neighbors) {
				UGNode newNei = map.get(nei);
				if (newNei == null) {
					newNei = dfs(nei, map); //易错点： 在dfs过程中，所得的值 dfs(nei, map); 必须赋给newNei
				}
				map.get(node).neighbors.add(newNei);
			}
			return map.get(node);
		}
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
		System.out.println("Entry point of cloned graph: " + bfsSol.clone(one).label); //1

		DFSSol dfsSol = new DFSSol();
		System.out.println("Entry point of cloned graph: " + dfsSol.clone(one).label); //1
	}
}
