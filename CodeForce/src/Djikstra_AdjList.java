import java.util.*;
import java.io.*;

public class Djikstra_AdjList {
	public static void main(String args[])
	{
		File file = new File("Dijkstra.txt");
		try {
			Scanner in = new Scanner(file);
			int vertices = in.nextInt();
			int edges = in.nextInt();
			ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
			for (int i = 0; i < vertices; i++)
			{
				adjList.add(new ArrayList<Edge>());
			}
			int temp;
			int temp1;
			int weight;
			Edge e;
			Edge t;
			for (int i = 0; i < edges; i++)
			{
				temp = in.nextInt() - 1;
				temp1 = in.nextInt() - 1;
				weight = in.nextInt();
				e = new Edge(temp + 1, temp1 + 1, weight);
				t = new Edge(temp1 + 1, temp + 1, weight);
				adjList.get(temp).add(e);
				adjList.get(temp1).add(t);
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
				Edge temp2;
				for (int i = 0; i < adjList.get(qo.target - 1).size(); i++)
				{
					temp2 = adjList.get(qo.target - 1).get(i);
					int edgeCost = temp2.weight;
					if(!visited[temp2.destination - 1] && (qo.target - 1) != (temp2.destination - 1))
					{
						pq.add(new QueueObject(edgeCost + qo.cost, qo.target, temp2.destination));
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
	
	static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public void print()
        {
        	System.out.print(source + " " + destination + " " + weight);
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
