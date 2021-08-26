


//Input: nums = [2,5,1,3,4,7], n = 3
//Output: [2,3,5,4,1,7]
//Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].


public class ShuffletheArray {


    public static void main(String[]args){

        int[] input = new int[] {1,1,2,2} ;
        int split = 2;
        int [] out = shuffle(input,split) ;
        for(int i =0; i<out.length;i++){
            System.out.println("Shuffled array is: " + out[i]) ;
        }
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] outarray = new int[nums.length] ;
        int j = n ;
        int k = 0 ;
        for (int i =0; i<n; i++) {
            outarray[k] = nums[i] ;
            outarray[k+1] = nums[j++] ;
            k += 2 ;
        }
        return outarray ;
    }
}
