
//Given an array of integers nums.
//
//A pair (i,j) is called good if nums[i] == nums[j] and i < j.
//
//Return the number of good pairs.

//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

public  class NumberofGoodPairs {

    public static void main(String[] args) {
        System.out.println("Output: " + numIdenticalPairs(new int[] {1,2,3}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i=0;i<=nums.length;i++){
            for(int j=i;j<nums.length;j++) {
                    if (nums[i] == nums[j]) {
                        if(i<j) count++;
                    }
            }
        }
        return count ;
    }


}
