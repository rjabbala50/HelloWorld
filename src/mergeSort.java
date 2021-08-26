import java.util.Arrays;

public class mergeSort {

    int [] sort ;

    private void print(int[] arr)
    {
        for(int i: arr)
            System.out.print(i);
        System.out.println();
    }

    private void merge ( int[] A, int start, int mid, int end)
    {
        int i = start;
        int j = mid+1;
        int k = start ;

        while(i<=mid && j<=end) {
            if(A[i] > A[j])
                sort[k++] = A[i++];
            else
                sort[k++] = A[j++];
        }
        while(i<=mid)
            sort[k++] = A[i++];

        while(j<=end)
            sort[k++] = A[j++];

        for(int w = start; w<=end; w++)
           A[w] = sort[w] ;
    }

    private void mergesortingHelper(int[] A, int start, int end)
    {
        if(start >= end) return ;
            int mid = (start + end) / 2;
            mergesortingHelper(A, start, mid);
            mergesortingHelper(A, mid + 1, end);
            merge(A, start, mid, end);
    }

    public void mergeSorting(int[] A)
    {
        if(A.length<=1) return;
        sort = new int[A.length] ;
        mergesortingHelper(A,0,A.length-1);
    }

    public static void main(String[] args) {
        mergeSort ss = new mergeSort();
       //int[] a = new int[] {-1,2,2,-1} ;
        //int[] a = new int[] {2,-1,5,0,-1} ;

        int[] a = new int[] {3,5,0,9,-1,2,11} ;
        //ss.merge(a1,0,a1.length/2-1,a1.length-1);
        //int[] a = new int[] {0,-1,0} ;
        //ss.sort = Arrays.stream(a).toArray() ;

        ss.mergeSorting(a);
        ss.print(a) ;
       //ss.insertionsorting(new int[]{4, -1,0,8,-5,10,9});
       // ss.insertionsorting(a);
        // ss.insertionsorting(new int[]{-1,0,3,6,4,8});
       //ss.bubblesorting(new int[]{0,0,0});
    }
}

/*
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        //int arr[] = { 12, 11, 13, 5, 6, 7 };
        //int arr[] = { -1,2,2,-1};
        int arr[] = {0,-1,0};


        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
*/

/*

public class mergeSort {

    private void print(int[] a) {
        for(int i:a)
            System.out.println("i = " + i);
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A1= {1,3,5,7};
        int[] A2= {2,4,6,9,11,15};
        int[] Array= {1,0,2,-1};
        int [] Result=new int[A1.length+A2.length] ;
        int []Array1= {-1,0,3,2,6,9,-1};
        mergeSort obj=new mergeSort();
        //obj.merge(A1,A2,Result);
        //obj.merge(Array1, 0, 1, 2);
        obj.mergeSort(Array1,0,Array1.length-1);
        //obj.mergeSort(Array,0,Array.length);
       obj.print(Array1) ;

    }


    void mergeSort(int[] array,int start,int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            mergeD(array, start, mid, end);
        }
    }

    void mergeD (int[] Array,int start,int mid,int end )
    {
        //int i=0,j=mid+1,k=0;
        int i = start ;
        int j = mid+1 ;
        int k = start;

        int[] newArray=new int[Array.length];
        newArray = Arrays.stream(Array).toArray() ;

        while(i<=mid && j<=end)
        {
            if(newArray[i]<newArray[j]){
                Array[k]=newArray[i++];
            }
            else {
                Array[k]=newArray[j++];
            }
            k++ ;
        }
        while(i<=mid)
            Array[k++]=newArray[i++];
        while(j<=end)
          Array[k++]=newArray[j++];
    }
}

*/

/*
public class mergeSort {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }


    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }

    public static void main(String[] args) {
        mergeSort ms = new mergeSort() ;
        int[] a = new int[] {3,0,1,5,8,7,2} ;
        ms.sort(a);
        for(int i:a)
            System.out.println(i);
    }
}

*/
