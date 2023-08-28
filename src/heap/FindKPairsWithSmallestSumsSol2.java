package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Corresponding JS solution:
 *  https://github.com/starwavelin/leetcode-in-ts/blob/master/src/heap/FindKPairsWithSmallestSumsSol2.js 
 */

public class FindKPairsWithSmallestSumsSol2 {    
    class Obj {
        List<Integer> pair;
        int sum;

        public Obj(List<Integer> pair, int sum) {
            this.pair = pair;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        Queue<Obj> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        for (int i=0; i < Math.min(nums1.length, k); i++) {
            for (int j=0; j < Math.min(nums2.length, k); j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]); pair.add(nums2[j]);
                int sum = nums1[i] + nums2[j];
                if (maxHeap.size() < k) {
                    maxHeap.offer(new Obj(pair, sum));
                } else if (sum < maxHeap.peek().sum) {
                    maxHeap.poll();
                    maxHeap.offer(new Obj(pair, sum));
                }
            }
        }
        
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll().pair);
        }

        return res;
    }
}
