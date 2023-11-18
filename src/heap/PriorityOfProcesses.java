package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityOfProcesses {

    public static List<Integer> process(int[] priority) {
        class Obj {
            int val;
            int idx;

            public Obj(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }
        }

        // form the maxHeap
        PriorityQueue<Obj> heap = new PriorityQueue<>((a, b) -> {
            if (b.val > a.val) {
                return 1;
            } else if (b.val < a.val) {
                return -1;
            } else {
                if (a.idx < b.idx) {
                    return -1;
                } else if (a.idx > b.idx) {
                    return 1;
                }
                return 0;
            }
        });

        // populate heap with obj { val, idx }
        for (int i = 0; i < priority.length; i++) {
            heap.offer(new Obj(priority[i], i));
        }

        List<Obj> resObj = new ArrayList<>(); // resObj to store the final objs

        while (!heap.isEmpty()) {
            Obj tmp = heap.poll();
            if (!heap.isEmpty() && tmp.val == heap.peek().val) {
                Obj el = heap.poll();
                el.val = el.val / 2;
                heap.offer(el);

                // handle when encounter a priority=0 case
                if (el.val == 0) {
                    while (!heap.isEmpty()) {
                        resObj.add(heap.poll());
                    }
                    break;
                }
            } else {
                resObj.add(tmp);
            }
        }

        // Sort the resObj based on index
        resObj.sort((a, b) -> a.idx - b.idx);

        List<Integer> res = new ArrayList<>();
        for (Obj o : resObj) {
            res.add(o.val);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] priority1 = { 6, 6, 6, 1, 2, 2 };
        System.out.println(process(priority1)); // expect [3, 6, 0]

        int[] priority2 = { 4, 4, 2, 1 };
        System.out.println(process(priority2)); // expect [0]

        int[] priority3 = { 2, 1, 5, 10, 10, 1 };
        System.out.println(process(priority3)); // expect [0, 1]

        int[] priority4 = { 4, 4, 2, 1, 1, 1 };
        System.out.println(process(priority4)); // expect [0, 1, 1]

        int[] priority5 = { 1, 3, 5, 10, 10 };
        System.out.println(process(priority5)); // expect [1, 3, 2]

        int[] priority6 = { 1, 3, 5, 10, 10, 10, 10 };
        System.out.println(process(priority6)); // expect [1, 3, 2, 5]

        int[] priority7 = { 6, 3, 1, 1 };
        System.out.println(process(priority7)); // expect [6, 3, 0]

        int[] priority8 = { 1, 3, 5, 10, 10, 10, 10, 19 };
        System.out.println(process(priority8)); // expect [1, 3, 2, 5, 19]
    }
}
