import java.util.*;
import java.io.*;

public class Dijkstra {
	public static void main(String args[])
	{
		File file = new File("Dijkstra.txt");
		try {
			Scanner in = new Scanner(file);
			int vertices = in.nextInt();
			int edges = in.nextInt();
			int [][] adjMatrix = new int[vertices][vertices];
			int temp;
			int temp1;
			int weight;
			for (int i = 0; i < edges; i++)
			{
				temp = in.nextInt() - 1;
				temp1 = in.nextInt() - 1;
				weight = in.nextInt();
	            if((adjMatrix[temp][temp1] != 0 && weight < adjMatrix[temp][temp1]) || adjMatrix[temp][temp1] == 0)
	            {
	            	adjMatrix[temp][temp1] = weight;
	            	adjMatrix[temp1][temp] = weight;
	            }
				
			}
			
			PriorityQueue<QueueObject> pq = new PriorityQueue<QueueObject>();
			boolean[] visited = new boolean[vertices];
			pq.add(new QueueObject(0, -1, 1));
			QueueObject qo = null;
			int [][] min = new int[2][vertices];
			
			while(!pq.isEmpty())
			{	
				qo = pq.peek();
				if(min[0][qo.target -1] == 0)
				{
					min[0][qo.target - 1] = qo.cost;
					min[1][qo.target - 1] = qo.parent;
				}
				pq.poll();
				
				if(qo.target == vertices)
				{
					break;
				}
				visited[qo.target - 1] = true;
				for (int j = 0; j < adjMatrix[qo.target - 1].length; j++)
				{
					if(adjMatrix[qo.target - 1][j] != 0 && (qo.target - 1) != j)
					{
						int edgecost = adjMatrix[qo.target - 1][j];
						if(!visited[j])
						{
							pq.add(new QueueObject(edgecost + qo.cost, qo.target, j + 1));
						}
					}
				}
			}
			ArrayList<Integer> path = new ArrayList<>();
			path.add(vertices);
			int parent = min[1][vertices - 1];
			boolean found = true;
			while(parent != 1)
			{
				path.add(parent);
				if((parent - 1) >= 0)
				{
					parent = min[1][parent - 1];
				}
				else
				{
					found = false;
					break;
				}
			}
			if (found)
			{
				path.add(1);
				for (int i = path.size() - 1; i >= 0; i--)
				{
					System.out.print(path.get(i) + " ");
				}
			}
			else
			{
				System.out.print("-1");
			}
		}
		catch(FileNotFoundException e) {
			
		}
	}
}

class QueueObject implements Comparable<QueueObject> {
	 int cost;
	 int parent;
	 int target;

	 public QueueObject(int c, int p, int t) {
	  cost = c;
	  parent = p;
	  target = t;
	 }

	 public int compareTo(QueueObject q) {
	  if(cost < q.cost) {
	   return -1;
	  } else if(cost > q.cost) {
	   return 1;
	  } else {
	   return 0;
	  }
	 }
	}

