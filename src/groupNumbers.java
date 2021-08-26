/*
Group the numbers

You are given an integer array arr of size n. Group and rearrange them (in-place) into evens and odds in such a
way that group of all even integers appears on the left side and group of all odd integers appears on the right side.
Example

Input: [1, 2, 3, 4]
Output: [4, 2, 1, 3]

Order does not matter. Other valid solutions are:
[2, 4, 1, 3]
[2, 4, 3, 1]
[4, 2, 3, 1]

Notes
Input Parameters: There is only one argument: Integer array arr.
Output: Return the same integer array, with evens on left side and odds on the right side.
There is no need to preserve order within odds or within evens.

Constraints:
    1 <= n <= 10^5
    arr contains only positive integers.
    arr may contain duplicate numbers.
    Solution with linear time complexity and constant auxiliary space is expected.
 */


public class groupNumbers {

    public static void print(int[] a)
    {
        for(int i:a)
            System.out.print( i);
        System.out.println();
    }

    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }
    public static int[] solve(int[] arr) {

        int odd=0;
        int even = arr.length-1 ;
        while(odd < even) {
            //seek until you find odd
            while( (arr[odd]%2 == 0) && odd<even)
            {
                odd++ ;
            }
            while( (arr[even]%2 != 0) && even>odd )
            {
                even-- ;
            }
            swap(arr,odd,even);
            odd++;even-- ;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,3,3,3,6,7,8,9} ;
        //int[] input = new int[] {2,4,6,8} ;
        //int[] input = new int[] {1,3,5,7} ;

        print(solve(input)) ;
    }

}
