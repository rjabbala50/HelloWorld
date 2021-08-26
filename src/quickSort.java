import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class quickSort {

    int [] sort ;

    private void print(int[] arr)
    {
        for(int i =0; i<arr.length;i++)
            System.out.print(" "+ arr[i]);
        System.out.println();
    }

    private void swap(int @NotNull [] A, int left, int right)
    {
        int temp = A[left] ;
        A[left] = A[right] ;
        A[right] = temp ;
    }

    //Lomuto's partition
    private int partitionInPlace_Lomuto( int[] A, int start, int end,int pivot)
    {
        pivot = A[end];
        int i = (start-1);
        for (int j=start; j<end; j++)
        {
            if (A[j] <= pivot)
            {
                i++;
                swap(A,i,j) ;
            }
        }
        swap(A,i+1,end) ;
        return i+1;
    }

    //Hoares partition
    private int partitionInPlace_Hoare( int[] A, int start, int end,int pivot)
    {
        int pi = A[pivot];
        int left = start-1;
        int right = end+1 ;

        while(true) {
            left++ ;
            while (A[left] < pi) left++;
            right-- ;
            while (A[right] > pi) right--;
            if (left >= right) return right;
            swap(A, left, right);
        }
    }


    private int partition_aux ( int[] A, int start, int end,int pivot)
    {
        int i = start ;
        int lk = start,rk=end;
        int[] aux = new int[end+1] ;

        for(; i<=end; i++)
        {
            if(i==pivot) continue;

            if(A[i] < A[pivot]) {
                aux[lk++] = A[i] ;
                //System.out.println("i = " + i);
            }
            else {
                aux[rk--] = A[i] ;
                //System.out.println("j = " + j);
            }
        }
        aux[rk]=A[pivot] ;

        for(int w=start;w<=end;w++) {
           A[w] = aux[w] ;
        }
        return rk ;
    }

    private void quickSortHelper(int[] A, int start, int end)
    {
        if(start >= end) return;
        //Random r = new Random( );
        //int ri = start+r.nextInt(end-start) ;
        //int pivot = ri ;

        int pivot = start+end/2 ;

        //pivot = partition(A,start,end,pivot);
       // pivot = partitionInPlace_Lomuto(A,start,end,pivot);
        pivot = partitionInPlace_Hoare(A,start,end,pivot);
        quickSortHelper(A,start,pivot);
        quickSortHelper(A,pivot+1,end);

    }

    public void quickSorting(int[] A)
    {
        if(A.length<=1) return;
        sort = new int[A.length] ;
        quickSortHelper(A,0,A.length-1);
    }

    public static void main(String[] args) {
        quickSort ss = new quickSort();
        //int[] a = new int[] {0,-1,0};
        //int[] a = new int[] {3,1,2} ;
        //int[] a = new int[] {6,5,-1,-2,0,1} ;
        //int[] a = new int[] {7,6,3,5,1,2,4} ;
        //int[] a = new int[] {7,6,3,5,1} ;
        //int[] a = new int[] {-1,2,2,-1,-2,0} ;

       //int[] a = new int[] {2,-2,5,0,-1} ;
      int[] a = new int[] {3,5,0,9,-1,2,11} ;

        ss.quickSorting(a);
        ss.print(a) ;
    }
}
