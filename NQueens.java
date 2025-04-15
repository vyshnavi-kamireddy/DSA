import java.util.*;

class NQueens
{
    static int[] x;

    public static boolean place(int k,int i)
    {
        for(int j=1;j<k;j++)
        {
            if(x[j]==i || Math.abs(x[j]-i)==Math.abs(j-k))
            {
                return false;
            }
        }
        return true;
    }

    public static void queen(int k,int n)
    {
        if(k>n)
        {
            for(int i=1;i<=n;i++)
            {
                System.out.print(x[i]+" ");
            }
            System.out.println();
        }
        else
        {
            for(int i=1;i<=n;i++)
            {
                if(place(k,i))
                {
                    x[k]=i;
                    queen(k+1,n);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of Queens: ");
        int n=sc.nextInt();
        x=new int[n+1];
        System.out.println("Possible Solutions = ");
        queen(1,n);
        sc.close();
    }
}

/*
 * 
 * OUTPUT
 * 
 * Enter the no.of Queens: 
4
Possible Solutions = 
2 4 1 3
3 1 4 2


 */