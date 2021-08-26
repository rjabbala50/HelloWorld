import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/n-queens/
N-Queens problem
*/

public class rec_nqueens {
    ArrayList<String> result = new ArrayList<String>() ;

    private boolean isValid(char[] slate, int row, int col)
    {
        for(int qrow =0; qrow<row; qrow++) {
            int qcol = slate[qrow]-'0'   ;
            if(qcol == col) return false ;
            int rowdiff = Math.abs(row-qrow) ;
            int coldiff = Math.abs(col-qcol) ;
            if(rowdiff == coldiff) return false ;
        }
        return true ;
    }

    private void helper(int n, int row, char[] slate)
    {
        if(row == n) {
            result.add(new String(slate)) ;
            return ;
        }
        for(int col = 0;col<n;col++) {
            if( isValid(slate,row,col)) {
                slate[row] = (char)('0'+col) ;
                helper(n,row+1,slate);
            }
        }
    }


    //public List<List<String>> solveNQueens(int n) {
    private List<String> solveNQueens(int n) {
        helper(n,0, new char[n]) ;
        return result ;
    }

    private void print()
    {
        for(String s:result)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {
        rec_nqueens r = new rec_nqueens() ;
        r.solveNQueens(8) ;
        r.print() ;
    }
}