import java.util.*;
import java.io.*;
 
public class Clumps
{
    public static void main(String args[])
    {	
    	File file = new File("ClumpsTxt.txt");
    	try {
    		Scanner in = new Scanner(file);
            int numOfStudents = in.nextInt();
            //flush buffer
            in.nextLine();
            String prev = in.nextLine();
            String current;
            int clumps = 1;
            for(int i = 1 ; i < numOfStudents; i++)
            {
                current = in.nextLine();
                if(!current.equals(prev))
                {
                    clumps++;
                    prev = current;
                }
            }
            System.out.println(clumps);
    	}
    	catch(FileNotFoundException e) {
            
        }
        
        
    }
}