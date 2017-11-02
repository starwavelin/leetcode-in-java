package array;

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
	
	/* Define Interval class */
	class Interval {
		int start;
		int end;
		public Interval () {start = 0; end = 0;}
		public Interval (int s, int e) {start = s; end = e;}
	}
	
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
		
		
		
	}
	
	
	public static void main(String[] args) {
		
	}
}
