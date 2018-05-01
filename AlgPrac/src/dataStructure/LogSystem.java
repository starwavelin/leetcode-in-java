package dataStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.ListUtil;

/***************************************************************************
* Problem No. : 635
* Problem Name: Design Log Storage System
* Problem URL : https://leetcode.com/problems/design-log-storage-system/description/
* Date        : Sept 16 2017
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
* 		Create a system to store logs. Each log contains a unique logId and timestamp.
* 		This system supports a put method to insert a log record, and a retrieve method to
* 		get a list of logIds based on a range of timestamps.
* 	Staring from an example:
* 		directly use the example on LeetCode
* 	Assumption:
* 		Already given by this LeetCode Problem
* 		1. There will be at most 300 operations of Put or Retrieve. -- not a fancy system design problem
		2. Year ranges from [2000,2017]. Hour ranges from [00,23]. -- important to the timestamp input format
		3. Output for Retrieve has no order required.
			So, similar to the example but now the logId timestamp mapping changes to
			put(3, "2017:01:01:23:59:59");
			put(2, "2017:01:01:22:59:59");
			put(1, "2016:01:01:00:00:00");
			retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
			// return [3, 2, 1] for retrieve is fine.
* 	Input: Input format is important. Year is in 4 digit format, Month, Day, Hour, Minute, Second always take 2 digits.
* 	Output: A data structure with put and retrieve function API
* 		void put(int id, String timestamp)
* 		List<Integer> retrieve(String s, String e, String gra)
* 	Data Structure and Alg:
* 		For Put, need a data structure to store Id-TimeStamp pairs, I initially thought a List<Map<Integer, String>>
* 			then figured out List<String[]> with String[] always be an array of 2 elements (id, ts) to reduce overhead
* 		For Retrieve,
* 			idea is for each record in the Id-TimeStamp pair list, compare its timestamp with the given range,
* 			if its timestamp is within the given range, then add its Id to the res; if not, don't add its Id to res.
* 		Then the range is formed by s, t, and granularity, this indicates I need to store the last index of each granularity
* 			ie. 2017:01:01:23:59:59
* 			counting from index 1, then for granularity "year" we have ending index as 4, "month" we have index 7, etc.
* Complexity  :
* 	Time Complexity: Put O(1); Retrieve O(n) n--the number of log records
* 	Space Complexity: O(n) n--the number of log records
*
* meta        : tag-data-structure
***************************************************************************/

public class LogSystem {
	private List<String[]> idTimestampPairs; //each String[] contains two elements: {id, timestamp}
	private String[] granularities; //unit of measuring timestamp, ie. Year, Second in this problem
	private int[] indices; //index - ending index of each unit
	
	public LogSystem() {
		idTimestampPairs = new ArrayList<>();
		granularities = new String[]{"Year", "Month", "Day", "Hour", "Minute", "Second"};
		indices = new int[]{4,7,10,13,16,19};
	}

	/**
	 * Inserts one {id, timestamp} record into the ID-Timestamp Pair List
	 * @param id int: the log Id of a log record that is to be inserted
	 * @param timestamp String: the log timestamp of a log record that is to be inserted
	 */
    public void put(int id, String timestamp) {
    		idTimestampPairs.add(new String[]{Integer.toString(id), timestamp});
    }

    /**
     * Returns a list of IDs that align in the given starting and ending timestamps
     * @param s String: starting timestamp
     * @param e String: ending timestamp
     * @param gra String: granularity of timestamp, can be year, month, etc.
     * @return List<Integer>: a list of IDs that align in the given starting and ending timestamps
     */
    public List<Integer> retrieve(String s, String e, String gra) {
	    	List<Integer> res = new ArrayList<>();
	    	int index = indices[Arrays.asList(granularities).indexOf(gra)];
	    	for (String[] idTs: idTimestampPairs) {
	    		if (idTs[1].substring(0, index).compareTo(s.substring(0, index)) >= 0
	    				&& idTs[1].substring(0, index).compareTo(e.substring(0, index)) <= 0) {
	    			res.add(Integer.parseInt(idTs[0]));
	    		}
	    	}
	    	return res;
    }

    public static void main(String[] args) {
	    	LogSystem sys = new LogSystem();
	    	sys.put(1, "2017:01:01:23:59:59");
	    	sys.put(2, "2017:01:01:22:59:59");
	    	sys.put(3, "2016:01:01:00:00:00");
	    	sys.put(4, "2017:09:16:00:00:00");
	    	List<Integer> res = new ArrayList<Integer>();
	    	res = sys.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
	    		// return [1,2,3,4], because you need to return all logs within 2016 and 2017.
	    	ListUtil.display(res);
	    	res = sys.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
	    		// return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23,
	    		// where log 3, 4 are left outside the range.
	    	ListUtil.display(res);
    }
}
