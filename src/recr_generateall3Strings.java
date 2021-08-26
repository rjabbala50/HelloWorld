
/*
Generate all 3 lenghth sub strings
 */


import java.util.ArrayList;
import java.util.List;

public class recr_generateall3Strings {

    List<String> result = new ArrayList<String>() ;

    public void helper(String[] str, int index, String slate, int chars)
    {
        if(index == 0 ) {
            result.add(slate);
            return ;
        }

        for(int alpha = 0; alpha < chars ;alpha++)
        {
            String newstr = slate + str[alpha];
            helper(str,index-1,newstr,chars) ;
        }
    }

    public void generateString(String[] str)
    {
        String  slate = "";
        helper(str,2,slate,str.length) ;
    }

    public static void main(String[] args) {
        recr_generateall3Strings r = new recr_generateall3Strings() ;
        r.generateString(new String[]{"1","2","3"});
        for(String s :r.result) {
            System.out.println(s);
        }
    }
}
