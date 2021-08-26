import java.util.ArrayList;
import java.util.List;

public class fizzbuzz {

    public  List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<String>(n) ;

        for(int i=1;i<=n;i++) {
            if(i%3 ==0 && i%5 ==0) {
                out.add("Fizzbuzz" );
            }
            else if (i%3 == 0) {
                out.add("Fizz" );
            }
            else if(i%5 == 0) {
                out.add("Buzz") ;
            }
            else {
                out.add(String.valueOf(i));
            }
        }
        return out ;
    }

    public static void main(String[] args) {
        int n = 15 ;
        fizzbuzz f = new fizzbuzz() ;
        List<String> output = f.fizzBuzz(n) ;
        for(String i:output) {
            System.out.println("i = " + i);
        }
    }
}
