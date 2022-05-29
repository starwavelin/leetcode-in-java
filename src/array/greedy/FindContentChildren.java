package array.greedy;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/***************************************************************************
 * Problem No. : 455
 * Problem Name: Assign Cookies
 * Problem URL : https://leetcode.com/problems/assign-cookies
 * Date        : May 21, 2022
 * Author      : @codingbro
 *
 * meta        : tag-array, tag-greedy
 ***************************************************************************/

public class FindContentChildren {

    class Solution {
        public int findContentChildren(int[] children, int[] cookies) {
            Arrays.sort(children);
            Arrays.sort(cookies);

            int i = 0; // loop counter for children array
            int j = 0; // loop counter for cookies array
            while (i < children.length && j < cookies.length) {
                if (cookies[j] >= children[i]) {
                    i++; // content child +1
                }
                j++;
            }

            return i;
        }
    }

    @Test
    public void testSolution() {
        Solution sol = new Solution();

        int[] children1 = new int[]{1, 2, 4, 4};
        int[] cookies1 = new int[]{1, 2, 2, 2, 5};
        assertEquals("Content children are 3", 3, sol.findContentChildren(children1, cookies1));

        int[] children2 = new int[]{5};
        int[] cookies2 = new int[]{1, 2, 4};
        assertEquals("Content children are 0", 0, sol.findContentChildren(children2, cookies2));

        int[] children3 = new int[]{2, 3};
        int[] cookies3 = new int[]{2};
        assertEquals("Content children are 1", 1, sol.findContentChildren(children3, cookies3));

        int[] children4 = new int[]{2, 3};
        int[] cookies4 = new int[]{3};
        assertEquals("Content children are 1", 1, sol.findContentChildren(children3, cookies3));
    }
}
