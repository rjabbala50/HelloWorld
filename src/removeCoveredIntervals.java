
/*
Given a list of intervals, remove all intervals that are covered by another interval in the list.
Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
After doing so, return the number of remaining intervals.

Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:
Input: intervals = [[1,4],[2,3]]
Output: 1

Example 3:
Input: intervals = [[0,10],[5,12]]
Output: 2

Example 4:
Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2

Example 5:
Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1

Constraints:
    1 <= intervals.length <= 1000
    intervals[i].length == 2
    0 <= intervals[i][0] < intervals[i][1] <= 10^5
    All the intervals are unique.
 */


import java.util.Arrays;

public class removeCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {

        /*
        int coveredIntervals = 0 ;
        for (int k = 0; k < intervals.length; k++) {
            for (int i = 0; i < intervals.length; i++) {
                //System.out.println(" = " +intervals[k][0] +"," +intervals[i][0]+"     "+intervals[i][1]+","+intervals[k][1]);
                if( (k!=i) && (intervals[k][0] >= intervals[i][0]) && ( intervals[k][1] <= intervals[i][1]) ) {
                    System.out.println(" = " +intervals[k][0] +"," +intervals[i][0]+"     "+intervals[i][1]+","+intervals[k][1]);
                    coveredIntervals++; break;
                }
            }
       }
        System.out.println("coveredIntervals = " + coveredIntervals);
        return intervals.length-coveredIntervals ;

         */

        class Solution {
            public int removeCoveredIntervals(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
                int[] currInt = {-1, -1};
                int result = 0;
                for(int[] interval: intervals) {
                    if(currInt[0] < interval[0] && currInt[1] < interval[1]) {
                        currInt[0] = interval[0];
                        result++;
                    }
                    currInt[1] = Math.max(currInt[1], interval[1]);
                }

                return result;
            }
        }
        return 0 ;
    }

    public static void main(String[] args) {
        removeCoveredIntervals rm = new removeCoveredIntervals() ;
        int TC_1 = 1 ;
        int TC_2 = 1 ;
        int TC_3 = 1 ;
        int TC_4 = 1 ;
        int TC_5 = 1 ;

        if(TC_1 ==1) {
            if(rm.removeCoveredIntervals(new int[][] {{1,4},{3,6},{2,8}}) == 2)  {
                System.out.println("TC_1 PASS");
            }
            else {
                System.out.println("TC_1 Fail");
            }

        }
        if(TC_2 ==1) {
            if(rm.removeCoveredIntervals(new int[][] {{1,4},{2,3}}) == 1)  {
                System.out.println("TC_1 PASS");
            }
            else {
                System.out.println("TC_1 Fail");
            }

        }

        if(TC_3 ==1) {
            if(rm.removeCoveredIntervals(new int[][] {{0,10},{5,12}}) == 2)  {
                System.out.println("TC_1 PASS");
            }
            else {
                System.out.println("TC_1 Fail");
            }

        }

        if(TC_4 ==1) {
            if(rm.removeCoveredIntervals(new int[][] {{3,10},{4,10},{5,11}}) == 2)  {
                System.out.println("TC_1 PASS");
            }
            else {
                System.out.println("TC_1 Fail");
            }

        }

        if(TC_5 ==1) {
            if(rm.removeCoveredIntervals(new int[][] {{1,2},{1,4},{3,4}}) == 1)  {
                System.out.println("TC_1 PASS");
            }
            else {
                System.out.println("TC_1 Fail");
            }

        }
    }
}
