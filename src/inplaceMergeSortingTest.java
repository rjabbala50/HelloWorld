
/*
Merge One Sorted Array Into Another

        Merge One Sorted Array Into Another


        Given two arrays:

        1) arr1 of size n, which contains n positive integers sorted in the ascending order.

        2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).

        Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly sorted array of (2*n) positive integers.


        Example

        Input:

        n = 3

        arr1 = [1 3 5]

        arr2 = [2 4 6 0 0 0]


        Output: arr2 = [1 2 3 4 5 6]


        Notes

        Input Parameters: There are two arguments. First one is an integer array denoting arr1 and second one is also an integer array denoting arr2.


        Output: You don't have to return anything. You just need to modify the given array arr2.


        Constraints:

        1 <= n <= 10^5
        1 <= arr1[i] <= 2 * 10^9
        1 <= arr2[i] <= 2 * 10^9 (for the first half)
        arr2[i] = 0 (for the second half)
        You can use only constant extra space.
        0 denotes an empty space.

*/


public class inplaceMergeSortingTest {


    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */
        int p1 = arr1.length - 1;
        int p2 = arr1.length - 1;
        int end = arr2.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] >= arr2[p2]) {
                arr2[end--] = arr1[p1--];
            } else {
                arr2[end--] = arr2[p2--];
            }
        }
        while (p1 >= 0) {
            arr2[end--] = arr1[p1--];
        }
        while (p2 >= 0) {
            arr2[end--] = arr2[p2--];
        }
        for(int w:arr2)
            System.out.print(w);
    }

        /*
    public static void merger_first_into_second(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        int[] newarr = new int[arr2.length] ;
        int k=0 ;

        while ( i<arr1.length && j<arr2.length/2)
        {
            if(arr1[i] < arr2[j]) {
                newarr[k++] = arr1[i++]   ;
            }
            else {
                newarr[k++] = arr2[j++]   ;
            }
        }
        while(i<arr1.length) {
            newarr[k++] = arr1[i++]   ;
        }
        while (j<arr2.length/2) {
            newarr[k++] = arr2[j++]   ;
        }
        for(int w =0; w<newarr.length;w++) {
            arr2[w] = newarr[w] ;
        }
        for(int x:arr2)
            System.out.println(x);
    }

    */

    public static void main(String[] args) {
        // System.out.println(lexicographicString(new String("zuckerberg"), new String("twain")));
        // merger_first_into_second(new int[] {1,2,3},new int[] {4,5,6,0,0,0});

        //dutch_flag_sort(new char[] {'G','B','G','G','R','B','R','G'}) ;
        // 8 G B G G R B R G
    }
}
