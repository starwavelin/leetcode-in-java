package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************************************************************
* Problem No. : 56
* Problem Name: Merge Intervals
* Problem URL : https://leetcode.com/problems/merge-intervals/description/
* Date        : Nov 2 2017
* Author      :	@codingbro
* Notes       :
* 	Scenario:
* 		Given a collection of intervals, merge all overlapping intervals.
* 	Assumption:
* 		1. Given intervals are non-overlapping
* 		2. Given intervals are NOT sorted
	Example:
* 	Input/Output:
* 	ie1:
* 		given intervals: [[1,3],[7,14],[2,6],[8,10]]
* 		output intervals: [[1,6],[7,14]]
* 	Data Structure and Alg:
* 		See code comments
*
* Complexity  :
* 	Time Complexity: O() -- See code comments
* 	Space Complexity: O() -- See code comments
*
* meta        : tag-array, tag-factset
*
* 考点: Math.max(), Math.min()的应用
***************************************************************************/
public class MergeIntervals {

	/**
	 * Solution 1:
	 * 	Sort the list of intervals based on their start point in the ascending order
	 * 	Then traverse the interval list,
	 * 		if the cur interval is the last interval OR cur interval has no overlap with its next interval
	 * 			append cur interval to the result
	 * 		else
	 * 			merge cur interval and its next interval and
	 * 			save the merged interval to cur's next interval (Important, save to intervals.get(i+1))
	 *	return result
	 *
	 * Time Complexity: O(n) -- one pass
	 * Space Complexity: O(1)
	 */
	public static List<Interval> merge1(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Collections.sort(intervals, (a, b) -> (a.start - b.start));
		for (int i = 0; i < intervals.size(); i++) {
			if (i == intervals.size() - 1 || intervals.get(i).end < intervals.get(i + 1).start) {
				res.add(intervals.get(i));
			} else {
				intervals.get(i + 1).start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
				intervals.get(i + 1).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		/* Test Solution 1 Example 1 */
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(7, 14);
		Interval i3 = new Interval(2, 6);
		Interval i4 = new Interval(8, 10);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		System.out.print("Sol 1: intervals after merging becomes: ");
		List<Interval> res = merge1(intervals);
		for (int i = 0; i < res.size(); i++) {
			System.out.print("[" + res.get(i).start + "," + res.get(i).end + "] ");
		}
	}
}
