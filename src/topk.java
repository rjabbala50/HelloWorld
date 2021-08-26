
/*
Top K
You are given an array of integers, arr, of size n, which is analogous to a continuous stream of integers input.
Your task is to find K largest elements from a given stream of numbers.  By definition, we don't know the size
of the input stream. Hence, produce K largest elements seen so far, at any  given time. For repeated numbers,
return them only once.

If there are less than K distinct elements in arr, return all of them.
    Don't rely on size of input array arr.
    Feel free to use built-in functions if you need a specific data-structure.
﻿
Example One
Input: arr = [1, 5, 4, 4, 2]; K = 2
Output: [4, 5]
Example Two
Input: arr = [1, 5, 1, 5, 1]; K = 3
Output: [5, 1]
Notes
Input Parameters: There is only one argument: Integer array arr.
Output: Return an integer array res, containing K largest elements. If there are less than K unique elements,
return all of them. Order of elements in res does not matter.

Constraints:
    1 <= n <= 10^5
    1 <= K <= 10^5
    arr may contain duplicate numbers.
    arr may or may not be sorted
 */

import java.util.*;
import java.util.stream.IntStream;

public class topk {

    private static int[] topkwithheap(int[] arr, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.comparing(a->a.intValue())) ;

        for(int i = 0; i<arr.length; i++) {
            pq.offer(arr[i]) ;
            if(pq.size()>k) {
                pq.poll() ;
            }
        }
        int[] result = pq.stream().mapToInt(a->a).toArray() ;
        return result ;
    }

    private static void swap(int[]arr, int a , int b)
    {
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp;
    }


    private static int partition(int[] arr,int start, int end, int pivot, int k)
    {
        int piele = arr[pivot] ;
        swap(arr,pivot,start);

        int orange = start ;

        for ( int green = start+1;green<= end; green++) {
            if(arr[green] <piele) {
                orange++ ;
                swap(arr,orange,green);
            }
        }
       swap(arr,orange,start);
      return orange ;
    }


    private static void topKwithQuickSelect(int[] arr, int start, int end,int k)
    {
        if(start >= end) return  ;

        Random rn = new Random() ;
        int pivot = start+rn.nextInt(end-start) ;

        int pivot1 = partition(arr,start,end,pivot,k) ;

        if(pivot1 == k) {
            return;
        }
        if( k > pivot1 ) {
            topKwithQuickSelect(arr,pivot1+1,end,k) ;
        }
        else { //k<pivot
            topKwithQuickSelect(arr,start,pivot1-1,k) ;
        }
    }

    public static int[] topK(int[] arr, int k) {

        //Remove duplicates
        Integer[] re = new Integer[arr.length] ;
        for(int i=0;i<arr.length;i++) {
            re[i] = arr[i];
        }
        LinkedHashSet<Integer> set1 = new LinkedHashSet<Integer>(Arrays.asList(re))  ;
        arr = set1.stream().mapToInt(i->i).toArray() ;
        if(k >=arr.length) return arr ;
        print(arr);

       // int[] result = topkwithheap(arr,k) ;
        topKwithQuickSelect(arr,0, arr.length-1,k)  ;
        if(k>=arr.length) return arr ;
        print(arr) ;
        int[] result = new int[k] ;
        int j = 0 ;
        for(int i= arr.length-1;i>=(arr.length-k); i--)
            result[j++] = arr[i] ;
      // int[] result = Arrays.copyOfRange(arr,arr.length-k,arr.length-1) ;
        for(int i:result)
            System.out.print(i);
        return result ;
    }

    static void print(int[] a)
    {
        for(int i:a)
            System.out.print(i);
        System.out.println();
    }

    public static void main(String[] args) {
        //print(topk.topK(new int[] {1, 5, 4, 4, 2} ,2) );
       // print(topk.topK(new int[] {1, 5, 1, 5, 1} ,5) );
       //print(topk.topK(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6} ,8) );
        print(topk.topK(new int[] { 5,6,1,4,1,8,2,4,1,7,9,3,2,1} ,2) );
        //print(topk.topK(new int[] { 4, 8, 9, 6, 6 ,2 ,10, 2, 8, 1 ,2} ,9) );
        //print(topk.topK(new int[] { 4,1,8,1,9,10,3,9,4,4,2,5,7,1,3,5} ,7) );
      // print(topk.topK(new int[] { 4,1,8,1,9,10,3,9,4,4,2,5,7,1,3,5} ,8) );
     /* int[] re = topk.topK(new int[] { 2,1,4,4,5} ,3) ;
        for(int i:re)
            System.out.print(i);

      */

    }
}
