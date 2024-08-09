package stack;

import java.util.Stack;

public class CountGroups {
    public int countGroups(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack();
        int count = 0;
        for (int r = 0; r <= n; r++) {
            int cur = (r == n) ? Integer.MAX_VALUE : arr[r];
            while (!stack.isEmpty() && arr[stack.peek()] < cur) {
                // DEBUG:
                // System.out.printf("r=%d, arr[r]=%d, cnt=%d\n", r, cur, cnt);
                // System.out.printf("stk=%s\n", stk.toString());
                int j = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                count += r - j + j - l - 1;
            }
            stack.push(r);
        }
        return count;
    }
}
