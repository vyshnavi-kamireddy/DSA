import java.util.*;

class BFSAdjList
{
    int v;
    LinkedList<Integer>[] adj;
    @SuppressWarnings("unchecked")
    BFSAdjList(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<>();
        }
    }

    void addEdge(int src,int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    void BFS(int start)
    {
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty())
        {
            int vis=queue.poll();
            System.out.print(vis+" ");
            for(int neighbour:adj[vis])
            {
                if(!visited[neighbour])
                {
                    queue.add(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v=sc.nextInt();
        BFSAdjList graph=new BFSAdjList(v);
        System.out.println("Enter the no.of Edges: ");
        int e=sc.nextInt();
        System.out.println("Enter the Edge(Source and Destination): ");
        for(int i=0;i<e;i++)
        {
            int src=sc.nextInt();
            int dest=sc.nextInt();
            graph.addEdge(src,dest);
        }
        System.out.println("Enter the Starting vertex : ");
        int start=sc.nextInt();
        System.out.println("The BFS Traversal Starting from vertex "+start+" is : ");
        graph.BFS(start);
        sc.close();
    }
}


/*
 * 
 * OUTPUT
 * 
 * Enter the no.of vertices: 
6
Enter the no.of Edges: 
9
Enter the Edge(Source and Destination): 
0 1
0 2
0 3
0 4
1 3
2 3 
2 4
2 5 
3 5
Enter the Starting vertex : 
1
The BFS Traversal Starting from vertex 1 is : 
1 0 3 2 4 5


 */