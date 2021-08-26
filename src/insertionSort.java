import java.util.Arrays;

public class insertionSort {

    int [] sort ;

    private void swap (int a  , int b)
    {
        int temp = sort[a] ;
        sort[a] = sort[b] ;
        sort[b] = temp ;
    }

    private void print(int[] arr)
    {
        for(int i: arr)
            System.out.print(i +",");
    }

    public void insertionsortingRecursive(int[] sortArray, int n)
    {
        if(n<=0) return ;
        insertionsortingRecursive(sortArray,n-1);

        int j =  n-1;
        while ( (j>0) && (sortArray[j] < sortArray[j-1] )) {
            swap(j,j-1 );
            j-- ;
        }
    }

    public void insertionsortingRecursiveWithShift(int[] A, int n)
    {
        if(n<=0) return ;
        insertionsortingRecursiveWithShift(A,n-1);
        int smallNum = A[n] ;
        int j = n ;
        while( j>0 && A[j-1] > smallNum  )
        {
            A[j] = A[j-1] ;
            j = j-1 ;
        }
        A[j] = smallNum ;
        /*
        int ele =  sortArray[n-1];
        int j = n-1 ;
        while ( (j>0) && (ele < sortArray[j-1] )) {
            sortArray[j] = sortArray[j-1]  ;
            j-- ;
        }
        sortArray[j] = ele ;
        */

    }

    //Iterative approacch
    public void insertionsorting(int[] sortArray)
    {
        sort = Arrays.stream(sortArray).toArray() ;
        for(int i =0; i<sort.length-1;i++) {
           int j = i+1 ;
           while ( (j>0) && (sort[j-1] > sort[j] )) {
                   swap(j,j-1 );
                   j-- ;
           }
        }
       // for(int i: sort)
         //   System.out.println("i = " + i);
    }

    public void insertIterativeShift( int[] A, int len)
    {
        if(len <= 1) return ;

        for (int i=1; i<len; i++)
        {
            int smallNum = A[i] ;
            int j = i-1 ;
            while( j>=0 && A[j] > smallNum  )
            {
                A[j+1] = A[j] ;
                j = j-1 ;
            }
            A[j+1] = smallNum ;
        }
        //for(int i=0; i< A.length; i++)
          //  System.out.print(A[i] + ",") ;
    }

    public static void main(String[] args) {
        insertionSort ss = new insertionSort();
       // int[] a = new int[] {-1,2,2,-1} ;
        //int[] a = new int[] {4, -1,0,8,-5,10,9} ;
        int[] a = new int[] {2,1,4,3} ;
        //int[] a = new int[] {0,-1,0} ;
       // ss.sort = Arrays.stream(a).toArray() ;

        //ss.insertIterativeShift(a,a.length);
        ss.insertionsortingRecursiveWithShift(a, a.length-1) ;
        ss.print(a) ;

        //ss.insertionsortingRecursive(ss.sort,ss.sort.length);
        //ss.insertionsortingRecursiveWithShift(ss.sort,ss.sort.length);
        //ss.insertionsortingRecursiveWithShift(a,a.length);
        //ss.print(ss.sort) ;
       //ss.insertionsorting(new int[]{4, -1,0,8,-5,10,9});
       // ss.insertionsorting(a);
        // ss.insertionsorting(new int[]{-1,0,3,6,4,8});
       //ss.bubblesorting(new int[]{0,0,0});
    }
}
