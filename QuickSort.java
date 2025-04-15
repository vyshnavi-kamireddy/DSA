import java.util.*;

class QuickSort
{
    public static void interchange(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int partition(int[] arr,int low,int high)
    {
        int pivot=arr[low];
        int i=low+1;
        int j=high;
        while(i<j)
        {
            while(i<=j && arr[i]<pivot)
            {
                i++;
            }
            while(j>=i && arr[j]>pivot)
            {
                j--;
            }
            if(i<j)
            {
                interchange(arr,i,j);
            }
        }
        interchange(arr,low,j);
        return j;
    }

    public static void sort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int j=partition(arr,low,high);
            sort(arr,low,j-1);
            sort(arr,j+1,high);
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


i<=j in while

 */