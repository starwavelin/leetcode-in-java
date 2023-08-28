package heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class FindKPairsWithSmallestSumsSol3 {
    class Obj {
        List<Integer> pair; // stores pair indices of the num elements
        int sum;

        public Obj(List<Integer> pair, int sum) {
            this.pair = pair;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        Queue<Obj> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        
        minHeap.offer(new Obj(List.of(0, 0), nums1[0] + nums2[0]));
        visited.add(new Pair<Integer,Integer>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            List<Integer> top = minHeap.poll().pair;
            int i = top.get(0), j = top.get(1);
            res.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i+1, j))) {
                minHeap.offer(new Obj(List.of(i+1, j), nums1[i+1] + nums2[j]));
                visited.add(new Pair<Integer,Integer>(i+1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j+1))) {
                minHeap.offer(new Obj(List.of(i, j+1), nums1[i] + nums2[j+1]));
                visited.add(new Pair<Integer,Integer>(i, j+1));
            }
        }

        return res;
    }
}
