import java.util.*;
import java.io.*;

public class Moody
{
    public static void main(String args[])
    {
    	File file = new File("MoodTxt.txt");
    	try {
    		Scanner in = new Scanner(file);
    		int pos = in.nextInt();
            in.nextLine();
            HashSet<String> posSet = new HashSet();
            for (int i = 0 ; i < pos; i++)
            {
                posSet.add(in.nextLine());
            }
            int neg = in.nextInt();
            in.nextLine();
            HashSet<String> negSet = new HashSet();
            for (int i = 0 ; i < neg; i++)
            {
                negSet.add(in.nextLine());
            }
            int numWords = in.nextInt();
            in.nextLine();
            int numPos = 0;
            int numNeg = 0;
            String temp;
            for (int x = 0 ; x < numWords ; x++)
            {
                temp = in.nextLine();
                if (posSet.contains(temp))
                {
                    numPos++;
                }
                if(negSet.contains(temp))
                {
                    numNeg++;
                }
            }
            if(numNeg == numPos)
            {
                System.out.println("Neutral");
            }
            else if(numNeg > numPos)
            {
                System.out.println("Negative");
            }
            else
            {
                System.out.println("Positive");
            }
        }
        catch(FileNotFoundException e) {
        
        }
        
        
    }
}
