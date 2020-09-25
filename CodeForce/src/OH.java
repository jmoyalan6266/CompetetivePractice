import java.util.*;
import java.io.*;

public class OH
{
    public static void main(String args[])
    {
    	File file = new File("OH.txt");
    	try {
    		Scanner in = new Scanner(file);
	        int numInLine = in.nextInt();
	        int x = in.nextInt();
	        int y = in.nextInt();
	        int possible = 0;
	        for(int i = 1; i <= numInLine; i++)
	        {
	            if ((i - x) >= 1 && (numInLine - i) <= y)
	            {
	                possible++;
	            }
	        }
	        System.out.println(possible);
    		
    	}
    	catch(FileNotFoundException e)
    	{
    		
    	}
       
    }
}