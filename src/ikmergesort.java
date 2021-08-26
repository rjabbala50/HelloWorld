
/*
Implement Merge Sort
Problem Statement:
You are given an array of integers. You have to sort the array using merge sort algorithm.

Input/Output Format For The Function:
Input Format:

The function contains a single argument, an integer array arr.
Output Format:
Return the sorted integer array.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ikmergesort {

    private static void merge(int[] arr, int left , int right, int mid)
    {
        int i = left ;
        int j = mid+1 ;
        int k = left ;

        int[] res = new int[arr.length] ;

        while(i<=mid && j<=right)
        {
            if(arr[i] < arr[j]) {
                res[k++] = arr[i++] ;
            }
            else {
                res[k++] = arr[j++] ;
            }
        }

        while(i<=mid) {
            res[k++] = arr[i++] ;
        }
        while (j<=right) {
            res[k++] = arr[j++] ;
        }

        for(int w = left; w<=right;w++)
            arr[w] = res[w] ;
        //if (right + 1 - left >= 0) System.arraycopy(res, left, arr, left, right + 1 - left);
    }

    private static void helper(int[] arr, int left , int right,int mid)
    {
        if(left>=right) return;
        mid = (left+right)/2 ;

        helper(arr,left,mid,mid);
        helper(arr,mid+1,right,mid);
        merge(arr, left, right,mid) ;
    }
    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here

        int[] input = new int[arr.size()] ;
        for(int i = 0; i<arr.size();i++) {
            input[i] = arr.get(i) ;
        }
        helper(input, 0, input.length-1,(input.length-1)/2);

        //Convert int[] to List

        List<Integer> newlist = new ArrayList<>(input.length) ;

        for(int i=0;i<input.length;i++)
            newlist.add(i,input[i]);

        return  newlist ;
    }

    public static void print(List<Integer> li)
    {
        for(Integer i : li)
            System.out.println(i);
        System.out.println();
    }
    public static void main(String[] args) {

        List<Integer> li = new ArrayList<Integer>() ;
        li.add(0);
        li.add(1) ;
        li.add(3) ;
        li.add(2) ;
        print(merge_sort(li)) ;
    }
}
