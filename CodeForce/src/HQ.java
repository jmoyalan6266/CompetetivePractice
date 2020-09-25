import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class HQ
{
    public static void main(String args[])
    {
    	File file = new File("HQ.txt");
    	try {
    		Scanner in = new Scanner(file);
            int numOfCoords = in.nextInt();
            int[][] coords = new int[numOfCoords][3];
            double totalPop = 0;
            for(int i = 0; i < numOfCoords; i++)
            {
                coords[i][0] = in.nextInt();
                coords[i][1] = in.nextInt();
                coords[i][2] = in.nextInt();
                totalPop += coords[i][2];
            }
            double finalX = 0;
            double finalY = 0;
            for(int i = 0; i < numOfCoords; i++)
            {
                double ratio = coords[i][2]/totalPop;
                finalX += (coords[i][0] * ratio);
                finalY += (coords[i][1] * ratio);
            }
            DecimalFormat df = new DecimalFormat("#.####");
            System.out.println(df.format(finalX)+" "+df.format(finalY));	
    	}
    	catch(FileNotFoundException e){
    		
    	}
        
    }
}