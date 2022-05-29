package array.greedy;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/***************************************************************************
 * Problem No. : 135
 * Problem Name: Candy
 * Problem URL : https://leetcode.com/problems/candy
 * Date        : May 22, 2022
 * Author      : @codingbro
 *
 * meta        : tag-array, tag-greedy
 ***************************************************************************/

public class Candy {

    class Solution1 {
        public int getCandies(int[] ratings) {
            if (ratings.length <= 1) {
                return 1;
            }

            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);


            //从左往右扫描，如果右边的rating大于左边的则右边孩子的糖果数等于左边孩子的糖果数+1
            for (int i = 0; i + 1 < candies.length; i++) {
                if (ratings[i] < ratings[i+1]) {
                    candies[i+1] = candies[i] + 1;
                }
            }

            int count = candies[candies.length - 1]; // store the number of the least candies needed

            //从右往左扫描，如果左边的rating大于右边的，且左边的糖果数<=右边孩子的糖果数，则左边孩子的糖果数等于右边孩子的糖果数+1
            for (int j = candies.length - 1; j - 1 >= 0; j--) {
                if (ratings[j-1] > ratings[j] && candies[j-1] <= candies[j]) {
                    candies[j-1] = candies[j] + 1;
                }
                count += candies[j-1];
            }

            return count;
        }
    }

    /**
     * Used math knowledge -- arithmetic sequence summation
     */
    class Solution2 {
        public int getCandies(int[] ratings) {
            if (ratings.length <= 1) {
                return 1;
            }

            int res = 1, pre = 1, count = 0;  // res存结果, pre为发现ratings等差数列出现时的前一个孩子的糖果计数 初始为1，count记录等差数列的项数

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] >= ratings[i-1]) {
                    if (count > 0) {
                        res += count * (count  + 1) / 2; //等差数列求和
                        if (count >= pre) {
                            res += count - pre + 1; //count - pre + 1 为初次算给pre的糖果数
                        }
                        count = 0; //还原
                        pre = 1;
                    }
                    pre = (ratings[i] == ratings[i-1]) ? 1 : pre + 1; // 再次看pre要不要在原来基础上追加一个糖果
                    res += pre;
                } else {
                    count++; // 等差数列开始出现
                }
            }

            if (count > 0) {
                res += count * (count + 1) / 2;
                if (count >= pre) {
                    res += count - pre + 1;
                }
            }

            return res;
        }
    }

    // Test Cases
    int[] ratings1 = new int[]{1, 0, 2};
    int[] ratings2 = new int[]{1, 2, 2, 1};
    int[] ratings3 = new int[]{3, 2, 0};
    int[] ratings4 = new int[]{1, 2, 2};
    int[] ratings5 = new int[]{1, 4, 2, 1};

    @Test
    public void testSolution1() {
        Candy.Solution1 sol = new Candy.Solution1();

        assertEquals("Least candies are 5", 5, sol.getCandies(ratings1));
        assertEquals("Least candies are 6", 6, sol.getCandies(ratings2));
        assertEquals("Least candies are 6", 6, sol.getCandies(ratings3));
        assertEquals("Least candies are 4", 4, sol.getCandies(ratings4));
        assertEquals("Least candies are 7", 7, sol.getCandies(ratings5));
    }

    @Test
    public void testSolution2() {
        Candy.Solution2 sol2 = new Candy.Solution2();

        assertEquals("Least candies are 5", 5, sol2.getCandies(ratings1));
        assertEquals("Least candies are 6", 6, sol2.getCandies(ratings2));
        assertEquals("Least candies are 6", 6, sol2.getCandies(ratings3));
        assertEquals("Least candies are 4", 4, sol2.getCandies(ratings4));
        assertEquals("Least candies are 7", 7, sol2.getCandies(ratings5));
    }
}
