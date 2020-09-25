import java.io.*;
import java.util.*;

public class Commuting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intersections = in.nextInt();
        int roads = in.nextInt();
        double [][] adjMatrix = new double[intersections][intersections];
        int inter1;
        int inter2;
        int speed;
        int length;
        for (int i = 0; i < roads; i++)
        {
            inter1 = in.nextInt() - 1;
            inter2 = in.nextInt() - 1;
            speed = in.nextInt();
            length = in.nextInt();
            adjMatrix[inter1][inter2] = (length * 1.0)/speed;
        }
        
        PriorityQueue<QueueObject> pq = new PriorityQueue<QueueObject>();
        boolean[] visited = new boolean[intersections];
        pq.add(new QueueObject(0, -1, 1));
        QueueObject qo = null;
        while(!pq.isEmpty())
        {    
            qo = pq.peek();
            System.out.println(qo.cost+" "+qo.parent);
            pq.poll();
            if(qo.target == intersections)
            {
                break;
            }
            if(visited[qo.target - 1])
            {
                continue;
            }
            visited[qo.target - 1] = true;
            for (int j = 0; j < adjMatrix[qo.target - 1].length; j++)
            {
                if(adjMatrix[qo.target - 1][j] != 0 && (qo.target - 1) != j)
                {
                    double edgecost = adjMatrix[qo.target - 1][j];
                    if(!visited[j])
                    {
                        pq.add(new QueueObject(edgecost + qo.cost, qo.target, j + 1));
                    }
                }
            }
        }
        System.out.println(qo.cost+" "+qo.parent);
    }
}

class QueueObject implements Comparable<QueueObject> {
     double cost;
     int parent;
     int target;

     public QueueObject(double c, int p, int t) {
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