package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Corresponding JS solution:
 *  https://github.com/starwavelin/leetcode-in-ts/blob/master/src/heap/FindKPairsWithSmallestSumsSol1.js
 * When running on LeetCode, got "Memory Limit Exceeded"
 */

public class FindKPairsWithSmallestSumsSol1 {
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

        Queue<Obj> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(nums1[i]); pair.add(nums2[j]);
                int sum = nums1[i] + nums2[j];
                minHeap.offer(new Obj(pair, sum));
            }
        }

        for (int i = 0; i < k; i++) {
            if (minHeap.size() == 0) break;
            res.add(minHeap.poll().pair);
        }
        return res;
    }
}
