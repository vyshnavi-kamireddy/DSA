import java.util.*;

class DFSAdjMat
{
    int v;
    int[][] adj;
    boolean[] visited;
    DFSAdjMat(int v)
    {
        this.v=v;
        adj=new int[v][v];
        visited=new boolean[v];
        Arrays.fill(visited,false);
    }

    void DFS(int start)
    {
        visited[start]=true;
        System.out.print(start+" ");
        for(int i=0;i<v;i++)
        {
            if(adj[start][i]==1 && !visited[i])
            {
                DFS(i);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v=sc.nextInt();
        DFSAdjMat graph=new DFSAdjMat(v);
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
        System.out.println("The DFS Traversal Starting from vertex "+start+" is : ");
        graph.DFS(start);
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
The DFS Traversal Starting from vertex 1 is : 
1 0 2 3 5 4


 */