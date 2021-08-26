
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.

 */


import java.util.*;

public class topkfrequentproblem {

    HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>()  ;
    Integer[] keyArray ;

    private void swap(int a, int b)
    {
        int temp = keyArray[a] ;
        keyArray[a] = keyArray[b] ;
        keyArray[b] = temp ;
    }

    private int partition(int left, int right, int pivot)
    {
        int pivotvalue = hm.get(keyArray[pivot])  ;
        swap(right,pivot) ;
        int newpi = left ;

        for(int i = left; i<= right;i++) {
            if(hm.get(keyArray[i]) <pivotvalue) {
                swap(i,newpi) ;
                newpi++ ;
            }
        }
        swap(newpi,right) ;
        return newpi ;
    }

    public int quickSelect(int left, int right, int pivot) {

        if(left == right) return 1;

       // int newPivot = (left+right)/2 ;
       // System.out.println("left+\",\"+right+\",\"+pivot = " + left+","+right+","+pivot);
        int  newpivot = left+ new Random().nextInt(right-left) ;

        int newpivot1 = partition(left, right, newpivot) ;

        if(newpivot == pivot) {
            return 1 ;
        }
        if(newpivot1 < pivot) {
            quickSelect(left,newpivot-1,pivot) ;
        }
        else if (newpivot1 > pivot) {
            quickSelect(newpivot+1,right,pivot) ;
        }

        return  1;
    }

    public int[] topKFrequentwithQuickSelect(int[] nums, int k) {

        if(nums.length==1) return nums ;
        //if(k<0) k *= -1 ;

        for(Integer i : nums) {
            hm.put(i,hm.getOrDefault(i,0)+1) ;
        }

        keyArray = hm.keySet().toArray(new Integer[0]);

        quickSelect(0,keyArray.length-1,keyArray.length-k) ;

        int[] ar = Arrays.stream(keyArray).mapToInt(Integer::intValue).toArray() ;
        //print(ar);

        return Arrays.copyOfRange(ar,ar.length-k,ar.length) ;
    }


    public class topk {
        Integer Key ;
        Integer value ;
        public topk(Integer k, Integer v){
            this.Key = k;
            this.value = v ;
        }
    }

    public int[] topKFrequentwithPQ(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>()   ;

        if(k<0) k *= -1 ;
        for(Integer i : nums) {
            hm.put(i,hm.getOrDefault(i,0)+1) ;
        }
        PriorityQueue<topk> minHeap = new PriorityQueue<>(Comparator.comparing(a->a.value)) ;

        for(Map.Entry<Integer,Integer> iter : hm.entrySet()) {
            minHeap.offer(new topk(iter.getKey(),iter.getValue())) ;

            if(minHeap.size()>k) {
                minHeap.poll() ;
            }
        }
        List<Integer> out  = new ArrayList<Integer>() ;
        while(minHeap.size()>0) {
            out.add(minHeap.poll().Key) ;
        }
        print(out.stream().mapToInt(i -> i).toArray());
        return out.stream().mapToInt(i -> i).toArray();
    }


    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 1) return nums ;

        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>()   ;

        //Arrays.sort(nums);
        //print(nums) ;

        for(int i = 0;i<nums.length;i++) {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i],hm.get(nums[i])+1) ;
            }
            else
                hm.put(nums[i], 1) ;
        }

        List<topk> list = new ArrayList<topk>() ;
        for(Integer key: hm.keySet())
        {
            topk t = new topk(key,hm.get(key)) ;
           list.add(t) ;
        }

        Collections.sort(list, new Comparator<topk>() {
        public int compare (topk t1, topk t2)
        {
            return t1.value.compareTo(t2.value) ;
        }
        });

        if(k<0) k= k*(-1) ;
        List<Integer> out = new ArrayList<>( );
        System.out.println("k = " + k);
        int j = 0;
        for(int i = list.size()-1;i>=0 && k>0;i--,k--){
            System.out.println("list.get(i).value+\",\"+list.get(i).Key = " + list.get(i).value+","+list.get(i).Key);
            out.add(list.get(i).Key) ;
        }

       return out.stream().mapToInt(i -> i).toArray();
    }
    

    public void print(int[] nums)
    {
        for (int i : nums)
            System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        topkfrequentproblem topk = new topkfrequentproblem() ;

        //System.out.println("args = " + topk.topKFrequentwithQuickSelect(new int[] {6,1,2,3},2));

        //System.out.println("args = " + topk.topKFrequentwithQuickSelect(new int[] {1,1,1,2,2,3},2));
       //topk.print(topk.topKFrequentwithQuickSelect(new int[] {6,1,2,4},2)) ;
        //topk.print(topk.topKFrequentwithQuickSelect(new int[] {1},1)) ;

        //topk.print(topk.topKFrequentwithQuickSelect(new int[] {-1,-1},-1)) ;
       // topk.print(topk.topKFrequentwithQuickSelect(new int[] {4,1,-1,2,-1,2,3},2)) ;
        //topk.print(topk.topKFrequentwithPQ(new int[] {4,1,-1,2,-1,2,3},2)) ;

        //System.out.println("args = " + topk.topKFrequentwithQuickSelect(new int[] {1,2,1,3,1,2,2,2},2));
        //output is [1,2]
       //System.out.println("args = " + topk.topKFrequentwithQuickSelect(new int[] {1},1));
        //output is [1]
        //System.out.println("args = " + topk.topKFrequentwithPQ(new int[] {5,5,5,6,6,6,2},2));
       System.out.println("args = " + topk.topKFrequentwithPQ(new int[] {6,1,2,6},2));
      // System.out.println("args = " + topk.topKFrequentwithPQ(new int[] {-1,-1},1));

    }
}
