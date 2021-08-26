
/*
        Merge K sorted arrays

        This is a popular Facebook problem.
        Given K sorted arrays arr, of size N each, merge them into a new array res, such that res is a sorted array.
        Assume N is very large compared to K. N may not even be known. The arrays could be just sorted streams, for
        instance, timestamp streams. All arrays might be sorted in increasing manner or decreasing manner.
        Sort all of them in the manner they appear in input.

        Repeats are allowed.
        Negative numbers and zeros are allowed.
        Assume all arrays are sorted in the same order. Preserve that sort order in output.
        It is possible to find out the sort order from at least one of the arrays.

        Example:
        Input:
        K = 3, N = 4
        arr = [[1, 3, 5, 7],
        [2, 4, 6, 8],
        [0, 9, 10, 11]]
        Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class mergeKsortedArrays {

    public void print(int[] out)
    {
        for(int i : out)
            System.out.print(i);
    }

    public  int[] mergeArrays(int[][] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        boolean order = false ;//Increasing


        for(int i =0; i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++) {
                pq.add(arr[i][j]);
                if(j+1 != arr[i].length) {
                    if (arr[i][j] > arr[i][j + 1])
                        order = true;
                }
            }

        Integer [] out1 = new Integer[pq.size()]  ;
        Integer [] out =  pq.toArray(out1);

        if(order == true) //decreasing
            Arrays.sort(out,Comparator.reverseOrder());
        else
            Arrays.sort(out);

        int[] result = new int[out.length] ;

        for(int i=0;i<out.length;i++)
            result[i] = out[i]  ;


        return result ;
    }

    public static void main(String[] args) {
        mergeKsortedArrays mk = new mergeKsortedArrays() ;
        int[][] input = new int[][] { {5}, {5}, {8,8,8,8,8},{8,8,8,8,8},{8,8,7,8},{8,8,8,8,8},{8,8,8,8,8}}    ;
        //int[][] input = new int[][] { {6,7}, {4,5}, {2,6}}    ;


        mk.print( mk.mergeArrays(input) ) ;
    }
}