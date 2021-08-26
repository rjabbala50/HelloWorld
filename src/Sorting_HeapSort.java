
public class Sorting_HeapSort {

    private void swap(int[] A, int start, int end) {
        int temp = A[start] ;
        A[start] = A[end] ;
        A[end] = temp ;
    }

    private void buildHeap(int[] A, int heapSize, int rootIndex ) {
        while(rootIndex >0) {
            int parent = rootIndex/2 ;
            if(A[rootIndex] > A[parent]) {
                swap(A,parent,rootIndex);
            }
            rootIndex /= 2 ;
        }
    }

    private void adjustHeap (int[] A, int heapSize)
    {
        int parent = 0;
        int leftChild = 2*parent+1 ;
        int rightChild = 2*parent+2 ;
        while (leftChild < heapSize && rightChild < heapSize) {
            if(A[leftChild] > A[parent]) {
                swap(A,leftChild,parent);
            }
            if(A[rightChild] > A[parent]) {
                swap(A,rightChild,parent);
            }
            parent = leftChild ;
            leftChild = 2*parent +1 ;
            rightChild = 2*parent+2 ;
        }
    }

    private void deleteParent (int[] A, int heapSize) {
        while(heapSize >1) {
            swap(A,0,heapSize-1) ;
            heapSize -= 1 ;
            adjustHeap(A,heapSize) ;
        }
    }

    public void heapSort ( int[] A) {

        for(int i=0; i< A.length-1;i++) {
            buildHeap(A, i,i+1) ;
        }

        for(int i:A)
            System.out.print("  "+i+",");

        System.out.println();

        deleteParent(A,A.length);

        for(int i:A)
            System.out.print("  "+i+",");
    }

    public static void main(String[] args) {
     int [] array = {2,4,8,6,9,1,-1,-1,0,0} ;
     Sorting_HeapSort heapsort = new Sorting_HeapSort() ;
     heapsort.heapSort(array);
    }
}
