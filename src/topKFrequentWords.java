

/*
https://leetcode.com/problems/top-k-frequent-words/
    692. Top K Frequent Words
    Medium

    Given a non-empty list of words, return the k most frequent elements.

    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

    Example 1:

    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
        Note that "i" comes before "love" due to a lower alphabetical order.

    Example 2:

    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    Output: ["the", "is", "sunny", "day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
        with the number of occurrence being 4, 3, 2 and 1 respectively.

    Note:

        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Input words contain only lowercase letters.

Follow up:

    Try to solve it in O(n log k) time and O(n) extra space.

 */

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class topKFrequentWords {


    public class tuple {
        int count = 1;
        String val;
        tuple(String in) {
            this.val = in ;
        }
        tuple(String s, int c) {
            this.val = s;
            this.count = c ;
        }
    }

    static class wordCompare implements Comparator<tuple>  {

        @Override
        public int compare(tuple o1, tuple o2) {
            if(o1.count > o2.count) return 1 ;
            else if (o1.count < o2.count){
                return -1;
            }
            else if(o1.count == o2.count) {
                return o2.val.compareTo(o1.val);
            }
            return 0;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> hm = new HashMap<String,Integer>() ;
        for (String word : words) {
            hm.put(word,hm.getOrDefault(word,0)+1) ;
        }

        PriorityQueue<tuple> pq = new PriorityQueue<tuple>(new wordCompare()) ;

        for(Map.Entry<String,Integer> e : hm.entrySet()) {
            pq.offer(new tuple(e.getKey(),e.getValue())) ;
            if(pq.size()>k) {
                pq.poll();
            }
            }

        ArrayList<tuple> result = new ArrayList<tuple>(pq.size()) ;
        while(pq.size()>0) {
            result.add(pq.poll()) ;
        }
/*
        result.sort(new Comparator<tuple>() {
            public int compare(tuple t1, tuple t2) {
                int result = 0;
                if(t1.count == t2.count) {
                    result = t1.val.compareTo(t2.val);
                    return result ;
                }
                else {
                    if(t1.count >t2.count) result = -1;
                    else if (t1.count < t2.count) result = 1;
                }
                return result ;
            }
        }); */
        List<String> output = new ArrayList<String>() ;
        for(tuple t:result)
            output.add(t.val);

    return output;
    }

    public static void main(String[] args) {
        topKFrequentWords tf = new topKFrequentWords() ;


        //String[] input2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"} ;
        //List<String> out = tf.topKFrequent(input2,4) ;
        String[] input1 = {"i", "love", "leetcode", "i", "love", "coding"} ;
       List<String> out = tf.topKFrequent(input1,3) ;
        for(String str: out) {
            System.out.print(str+" ");
        }

    }
}
