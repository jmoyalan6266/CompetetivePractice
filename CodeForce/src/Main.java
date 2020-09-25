
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	 public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.print("First number : ");
	     int size = scan.nextInt();
	     System.out.print("Second number : ");
	     int hop = scan.nextInt();
	     scan.nextLine();
	     System.out.print("Cells : ");
	     String cells = scan.nextLine();
	     char[] allCells = cells.toCharArray();
	     int hopperIndex = -1;
	     char find = 'N';
	     String answer = "";
	     for(int i = 0; i < size; i++)
	     {
	    	 
	    	 if(allCells[i] == 'G' && find == 'N')
	    	 {
	    		 hopperIndex = i;
	    		 find = 'T';
	    	 }
	    	 if(allCells[i] == 'T' && find == 'N')
	    	 {
	    		 hopperIndex  = i;
	    		 find = 'G';
	    	 }
	    	 if((hopperIndex + hop) == i && hopperIndex != -1)
	    	 {
	    		 if(allCells[i] == '.')
	    		 {
	    			 hopperIndex += hop;
	    		 }
	    		 else if(allCells[i] == '#')
	    		 {
	    			 break;
	    		 }
	    		 else if(allCells[i] == find)
	    		 {
	    			 answer += "YES";
	    			 break;
	    		 }
	    	 }
	     }
	     if(answer.equals(""))
	     {
	    	 System.out.println("NO");
	     }
	     else 
	     {
	    	 System.out.println(answer);
	     }
	 }
}
