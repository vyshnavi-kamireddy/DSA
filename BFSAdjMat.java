import java.util.*;

class BFSAdjMat
{
    int v;
    int[][] adj;
    BFSAdjMat(int v)
    {
        this.v=v;
        adj=new int[v][v];
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
            for(int i=0;i<v;i++)
            {
                if(adj[vis][i]==1 && !visited[i])
                {
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v=sc.nextInt();
        BFSAdjMat graph=new BFSAdjMat(v);
        System.out.println("Enter the Adjacent Matrix of size ( "+v+" X "+v+" ) : ");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                graph.adj[i][j]=sc.nextInt();
            }
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
Enter the Adjacent Matrix of size ( 6 X 6 ) : 
0 1 1 1 1 0
1 0 0 1 0 0
1 0 0 1 1 1 
1 1 1 0 0 1
1 0 1 0 0 0
0 0 1 1 0 0
Enter the Starting vertex : 
1
The BFS Traversal Starting from vertex 1 is : 
1 0 3 2 4 5


 */