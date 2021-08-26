import java.util.ArrayList;
import java.util.List;

public class TextJustificationLeetcode68 {


    public List<String> fullJustify(String[] words, int maxWidth) {

        int[] wordLengthMapper = new int[words.length+1] ;

        for (int i=0; i<words.length;i++)
        {
            wordLengthMapper[i] = words[i].length();
        }

        List<String> outputList = new ArrayList() ;
        int numWords = 0 ;

        for(int i=0;i<wordLengthMapper.length;i++)
        {
            int lineCharCount = 0 ;

            lineCharCount += wordLengthMapper[i] ;
            //default add one space between each word

            if(lineCharCount >= maxWidth) {
                numWords = 0; //reset word counter for output line.
                lineCharCount -= wordLengthMapper[i] ;
                //left adjust remaining spaces and output it
                i = i-1 ;
                int numSpaces = 0;

                if(i!=0) {
                    numSpaces = maxWidth-lineCharCount ;
                     numSpaces = maxWidth / i;
                }
                else {
                    numSpaces = 0 ;
                }
               if(i==0 || i==1)
               {
                   //Form output string
                   String outstr = new String() ;

               }

            }

        }

        return new ArrayList<>() ;
    }

    //Driver code

    public static void main(String[] args) {
    String [] input = { "this", "is","an","example","of", "text","justification"} ;
    int maxWidth = 16;
    TextJustificationLeetcode68 t = new TextJustificationLeetcode68() ;

    List<String> output = t.fullJustify(input,maxWidth) ;

    System.out.println(output);

    }
}

