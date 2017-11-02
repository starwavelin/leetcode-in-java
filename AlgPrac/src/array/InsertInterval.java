package array;

import java.util.ArrayList;
import java.util.List;

import utility.ListUtil;

/***************************************************************************
* Problem No. : 57
* Problem Name: Insert Interval
* Problem URL : https://leetcode.com/problems/insert-interval/description/
* Date        : Nov 2 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a set of non-overlapping sorted intervals, insert a new interval into the intervals (merge if necessary).
* 	Assumption:
* 		1. Given intervals are non-overlapping
* 		2. Given intervals are already sorted based on their start time
	Example:
* 	Input/Output:
* 	ie1: 
* 		given intervals: [[1,3],[6,9]]  given interval: [2,5]
* 		output intervals: [[1,5],[6,9]] 
* 	ie2:
* 		given intervals: [[1,3],[6,9]]  given interval: [-14,-3]
* 		output intervals: [[-14,-3],[1,3],[6,9]]
*  
* 	Data Structure and Alg:
* 		See code comments
* 		  
* Complexity  : 
* 	Time Complexity: O() -- See code comments
* 	Space Complexity: O() -- See code comments
* 
* meta        : tag-array
* 
* 考点： ArrayList.add(index, el) 方法，是在特定index位置加el, 然后把原先index所指元素向后挤一位
***************************************************************************/
public class InsertInterval {
	/**
	 * Solution 1：Utilize the given Interval class
	 *  Traverse the existing interval list, and for each existing interval, we use newInterval to compare it and determine the insertion strategy. 
	 *  There are 6 cases for insertion：
	 *  	2 are directly insert w/o merge: the newInterval if newInterval's end < someInterval's start or newInterval's start > someInerval's end
	 *  	如图：
	 *  		someInterval			|---|
	 *  		newInterval		|---|
	 *  
	 *  		someInterval		|---|
	 *  		newInterval					|---|
	 *  	4 cases need merge, and for the merge we wanna update the newInterval's start and end for future comparisons.
	 *  	these 4 cases 如图：
	 *  		someInterval	  |---|		
	 *  		newInterval		|---|				newInterval's end is between someInterval
	 *  
	 *  		someInterval		|---|
	 *  		newInterval			   |---|		newInterval's start is between someInterval
	 *  
	 *  		someInterval		|---|
	 *  		newInterval		|-------------|		newInterval covers someInterval
	 *  
	 *  		someInterval	|-----------------|
	 *  		newInterval			|---|			newInterval is covered by someInterval
	 *   
	 * Time Complexity: O(n) -- one pass
	 * Space Complexity: O(1) -- one pointer to traverse the existing interval list, and one to indicate the insert position.
	 */
	public static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			if (newInterval != null) {
				res.add(newInterval);
			}
			return res;
		}
		
		int insPos = 0; //insertion position
		/* 注意，traverse过程中 res加的都是existing interval,但根据情况更新insPos。Traverse完了最后加 newInterval */
		for (Interval itvl : intervals) {
			if (newInterval.end < itvl.start) {
				res.add(itvl);
			} else if (newInterval.start > itvl.end) {
				res.add(itvl);
				insPos++;
			} else {
				newInterval.start = Math.min(itvl.start, newInterval.start);
				newInterval.end = Math.max(itvl.end, newInterval.end);
			}
		}
		
		res.add(insPos, newInterval); // insert the newInterval at the end
		return res;	
	}
	
	/**
	 * Solution 2:
	 * 	Same idea and logic as Solution 1, but instead of using an Interval class, I asked myself to use int[]
	 * of size 2 to represent an interval's start and end numbers.
	 */
	public static List<int[]> insert2(List<int[]> intervals, int[] newInterval) {
		return null;
	}
	
	
	public static void main(String[] args) {
		/* Test Solution 1 Example 1*/
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(6, 9);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1); intervals.add(i2);
		Interval newInterval = new Interval(2, 5);
		System.out.print("ie1: intervals after insertion becomes: ");
		List<Interval> res = insert1(intervals, newInterval);
		for (int i = 0; i < res.size(); i++) {
			System.out.print("[" + res.get(i).start + "," + res.get(i).end + "] ");
		}
		
		
	}
}

/* Define Interval class */
class Interval {
	int start;
	int end;
	public Interval () {start = 0; end = 0;}
	public Interval (int s, int e) {start = s; end = e;}
}
