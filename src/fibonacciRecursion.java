/*
Recursion excercises
Print Fibonacci series
11235813
 */

public class fibonacciRecursion {

    public static int fibonacci(int n)
    {
        if( n <= 1 ) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        for(int i=1;i<20;i++)
            System.out.println(fibonacci(i) );
    }
}
