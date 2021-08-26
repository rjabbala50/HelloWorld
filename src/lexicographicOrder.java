/*
Lexicographical Order

        Lexicographical Order


        Given a bunch of key-value pairs, for each unique key find 1) the number of values and 2) the
        lexicographically greatest value.


        Example One

        Input is an array of strings, each with a key and a value separated by a space:

        ["key1 abcd",

        "key2 zzz",

        "key1 hello",

        "key3 world",

        "key1 hello"]


        Output is an array of strings with unique keys followed by a colon, the total number of values, a comma,
        and the lexicographically greatest of the values associated with that key in the input:

        ["key1:3,hello",

        "key2:1,zzz",

        "key3:1,world"]

        The order or strings in the output is insignificant; these same strings in a different order are
        also a correct output.


        Example Two

        Input:

        ["mark zuckerberg",

        "tim cook",

        "mark twain"]


        Output:

        ["mark:2,zuckerberg",

        "tim:1,cook"]

        or

        ["tim:1,cook",

        "mark:2,zuckerberg"]


        Notes

        Order of strings in the output does not matter.


        Constraints:

        Keys and values consist of lowercase letters and digits.
        1 <= number of strings in input <= 10^4
        1 <= length of any key <= 256
        1 <= length of any value <= 650
        Keys can repeat.
        Values can repeat.




 */

import java.util.HashMap;
import java.util.Map;

public class lexicographicOrder {


    public static class lexString {
        int count = 1 ;
        String str = new String() ;

        private void copy(String in) {
            str = "" ;
            str = in ;
        }

        lexString(String inStr)
        {
            this.str = inStr ;
        }
    }

    public static String[] solve(String[] arr) {

        HashMap<String,lexString> hm = new HashMap<String,lexString>() ;
        for(String in:arr) {
            String[] str = in.split(" ") ;
            if(hm.containsKey(str[0])) {
                lexString s = hm.get(str[0]) ;
                String lexhi = (s.str.compareTo(str[1]) >0) ? s.str:str[1] ;
                s.count++ ;
                s.copy(lexhi);
            }
            else {
                hm.put(str[0],new lexString(str[1])) ;
            }
        }

        String[] result = new String[hm.size()] ;

        int i = 0 ;
        for(Map.Entry<String,lexString> entry: hm.entrySet()) {
            String s = new String (entry.getKey()+":"+entry.getValue().count+","+entry.getValue().str)  ;
            result[i++] = s ;
        }
        return result ;
    }


    public static void main(String[] args) {
/*
        String[] in =  new String[] {"key1 abcd",

                "key2 zzz",

                "key1 hello",

                "key3 world",

                "key1 hello"} ;

 */
        String[] in1 = new String[]  {"mark zuckerberg",

                "tim cook",

                "mark twain"} ;
        String[] s = solve(in1) ;
        for(String i:s)
            System.out.println(i);
    }


}
