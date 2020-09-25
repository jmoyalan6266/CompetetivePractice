import java.util.*;
import java.io.*;

public class PingPong {
	public static void main(String args[])
	{
		File file = new File("PingP.txt");
		try {
			Scanner scan = new Scanner(file);
			int queries = scan.nextInt();
			double [][] adjMatrix = new double[queries][queries];
			HashMap<Integer, Pair> vertices = new HashMap<>();
			int count = 0;
			int numVerts = 0;
			while (count < queries)
			{
				int check = scan.nextInt();
				if(check == 1)
				{
					int inter1 = scan.nextInt();
					int inter2 = scan.nextInt();
					Pair current = new Pair(inter1, inter2);
					vertices.put(numVerts, current);
					for (int i = 0 ; i < vertices.size(); i++)
					{
						if (i != numVerts)
						{
							Pair temp = vertices.get(i);
							int tempI1 = temp.getNum1();
							int tempI2 = temp.getNum2();
							if((tempI1 < inter1 && inter1 < tempI2) || (tempI1 < inter2 && inter2 < tempI2))
							{
								adjMatrix[numVerts][i] = 1;
							}
							if((inter1 < tempI1 && tempI1 < inter2) || (inter1 < tempI2 && tempI2 < inter2))
							{
								adjMatrix[i][numVerts] = 1;
							}
						}
					}
					numVerts++;
				}
				else
				{
					int start = scan.nextInt() - 1;
					int end = scan.nextInt() - 1;
					boolean found = DFS(start, end, adjMatrix);
					if(found)
					{
						System.out.println("YES");
					}
					else
					{
						System.out.println("NO");
					}
				}
				count++;
			}
			scan.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
		
		
	}
	
	public static boolean DFS(int start, int end, double [][] adjMatrix)
	{
		boolean [] visited = new boolean[adjMatrix.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while(!stack.empty())
		{
			int vert = stack.pop();
			if(vert == end)
			{
				return true;
			}
			if(visited[vert] == true)
			{
				continue;
			}
			visited[vert] = true;
			for (int j = 0; j < adjMatrix[vert].length; j++)
			{
				if(adjMatrix[vert][j] != 0 && vert != j)
				{
					stack.push(j);
				}
			}
		}
		return false;
	}
	
	static class Pair 
	{
		int num1;
		int num2;
		public Pair(int num1, int num2)
		{
			this.num1 = num1;
			this.num2 = num2;
		}
		public int getNum1()
		{
			return num1;
		}
		public int getNum2()
		{
			return num2;
		}
	}
}
