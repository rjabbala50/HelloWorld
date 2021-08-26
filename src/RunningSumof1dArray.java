
//Input: nums = [1,2,3,4]
//Output: [1,3,6,10]
//Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

public class RunningSumof1dArray
{
    public static void main(String[] args) {
        int[] output = runningSum(new int[]{3,1,2,10,1}) ;
        for (int i=0;i<output.length;i++) {
            System.out.println ("running sum of array is: "+ output[i]) ;
        }
    }

    public static int[] runningSum(int[] nums) {

        int[] outputarray = new int[nums.length] ;
        outputarray[0] = nums[0] ;
        for(int i = 1;i<nums.length;i++) {
            outputarray[i] = outputarray[i-1]+ nums[i] ;
        }
        return outputarray ;
    }
}
