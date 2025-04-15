import java.util.*;

class DPKnapsack
{
    public static void knapsack(int n,int[] w,int[] p,int m)
    {
        int[][] k=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    k[i][j]=0;
                }
                else if(w[i-1]<=j)
                {
                    k[i][j]=Math.max(k[i-1][j],k[i-1][j-w[i-1]]+p[i-1]);
                }
                else
                {
                    k[i][j]=k[i-1][j];
                }
            }
        }
        int i=n;
        int j=m;
        while(i>0 && j>0)
        {
            if(k[i][j]==k[i-1][j])
            {
                System.out.println("Item "+i+" 0 ");
                i--;
            }
            else
            {
                System.out.println("Item "+i+" 1 ");
                j-=w[i-1];
                i--;
            }
        }
        System.out.println("MaxProfit  = "+k[n][m]);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of Objects : ");
        int n=sc.nextInt();
        int[] w=new int[n];
        int[] p=new int[n];
        System.out.println("Enter weight and profit seperated by spaces : ");
        for(int i=0;i<n;i++)
        {
            w[i]=sc.nextInt();
            p[i]=sc.nextInt();
        }
        System.out.println("Enter the maximum weight of the knapsack = ");
        int m=sc.nextInt();
        System.out.println("Items Selected : (1-Taken 0-NotTaken)");
        knapsack(n,w,p,m);
        sc.close();
    }
}

/***
 * 
 * 
 * OUTPUT
 * 
 * Enter the no.of Objects : 
4
Enter weight and profit seperated by spaces :
1 1
2 3
3 5
5 6
Enter the maximum weight of the knapsack =
8
Items Selected : (1-Taken 0-NotTaken)
Item 4 1
Item 3 1
MaxProfit  = 11


 */
