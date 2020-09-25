import java.util.*;
import java.io.*;	

public class Elesay
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine());
        int asciiLines = in.nextInt(); 
        //clear buffer
        in.nextLine();
        System.out.println();
        for (int i = 0 ; i < asciiLines; i++)
        {
            System.out.println(in.nextLine());
        }
    }
}