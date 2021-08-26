import java.util.Arrays;

public class selectionSort {

    int [] sort ;

    private void swap (int a  , int b)
    {
        int temp = sort[a] ;
        sort[a] = sort[b] ;
        sort[b] = temp ;
    }


    public void selectionsortingDecreasing(int[] sortArray)
    {
        sort = Arrays.stream(sortArray).toArray() ;

        for(int i =0; i<sort.length-1;i++) {
            int max =i ;
            for(int j=i+1; j<sort.length;j++) {
                if(sort[j] > sort[max] ) {
                    max = j ;
                }
            }
            if(max!=i)
                swap(i,max);
        }

        for(int i: sort)
            System.out.println("i = " + i);

    }


    public void selectionsortingIncreasing(int[] sortArray)
    {
        sort = Arrays.stream(sortArray).toArray() ;

        for(int i =0; i<sort.length-1;i++) {
            int min =i ;
            for(int j=i+1; j<sort.length;j++) {
                if(sort[j] < sort[min] ) {
                   min = j ;
                }
            }
            if(min!=i)
              swap(i,min);
        }

        for(int i: sort)
            System.out.println("i = " + i);

    }
    public static void main(String[] args) {

        selectionSort ss = new selectionSort();
       // ss.selectionsortingIncreasing(new int[]{4, -1, 1});
        ss.selectionsortingDecreasing(new int[]{-1, -1, 0});
    }
}
