import java.util.Arrays;

public class bubbleSort {

    int [] sort ;

    private void swap (int a  , int b)
    {
        int temp = sort[a] ;
        sort[a] = sort[b] ;
        sort[b] = temp ;
    }


    public void bubblesorting(int[] sortArray)
    {
        sort = Arrays.stream(sortArray).toArray() ;
        for(int i =0; i<sort.length-1;i++) {
            for (int j = sort.length - 1; j > i; j--) {
                if(sort[j] < sort[j-1]) {
                    swap(j,j-1);
                }
            }
        }
        for(int i: sort)
            System.out.println("i = " + i);
    }

    public void bubblesortingDecreasing(int[] sortArray)
    {
        sort = Arrays.stream(sortArray).toArray() ;
        for(int i =0; i<sort.length-1;i++) {
            for (int j = sort.length - 1; j > i; j--) {
                if(sort[j] > sort[j-1]) {
                    swap(j,j-1);
                }
            }
        }
        for(int i: sort)
            System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        bubbleSort ss = new bubbleSort();
       //ss.bubblesorting(new int[]{4, -1, 1});
       ss.bubblesortingDecreasing(new int[]{-1,0,3,6,4,8});
       //ss.bubblesorting(new int[]{0,0,0});
    }
}
