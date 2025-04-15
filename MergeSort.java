import java.util.*;

class MergeSort
{
    public static void merge(int[] arr,int low,int mid,int high)
    {
        int i=low;
        int j=mid+1;
        int k=low;
        int[] b=new int[high+1];
        while(i<=mid && j<=high)
        {
            if(arr[i]<arr[j])
            {
                b[k]=arr[i];
                i++;
            }
            else
            {
                b[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            b[k]=arr[i];
            i++;
            k++;
        }
        while(j<=high)
        {
            b[k]=arr[j];
            j++;
            k++;
        }
        for(int h=low;h<=high;h++)
        {
            arr[h]=b[h];
        }
    }

    public static void sort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int mid=(low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of Elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sort(arr,0,n-1);
        System.out.println("The Array Elements after sorting = ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}


/**
 * 
 * OUTPUT
 * 
 * Enter the no.of Elements:
10
Enter the elements:
5 3 23 678 12 342 1 45 2 678
The Array Elements after sorting =
1 2 3 5 12 23 45 342 678 678


 */
