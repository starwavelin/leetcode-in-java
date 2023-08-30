package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrixSol1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(matrix[i][j]);
                } else if (matrix[i][j] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(matrix[i][j]);
                }
            }
        }

        return maxHeap.poll();
    }
}
