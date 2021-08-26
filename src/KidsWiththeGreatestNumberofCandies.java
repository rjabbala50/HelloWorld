
//Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
//
//For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
//Input: candies = [2,3,5,1,3], extraCandies = 3
//Output: [true,true,true,false,true]

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
    public static void main(String[] args) {

        List<Boolean> output = kidsWithCandies(new int[]{12,1,12},10) ;
        for(int i = 0;i<output.size();i++) {
            System.out.println("output: " + output.get(i));
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
         List<Boolean> out = new ArrayList<>();
          for(int i=0;i<candies.length;i++) {
              if(candies[i]+ extraCandies >= Arrays.stream(candies).max().getAsInt()) {
                  out.add(true) ;
              }else
                  out.add(false) ;
          }
          return out ;
    }
}
