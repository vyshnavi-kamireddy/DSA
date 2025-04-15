import java.util.*;

class MaxHeap{
    int[] arr;
    int heapsize,maxsize;
    MaxHeap(int maxsize)
    {
        this.maxsize=maxsize;
        heapsize=0;
        arr=new int[maxsize];
    }

    int parent(int i)
    {
        return (i-1)/2;
    }

    int lChild(int i)
    {
        return 2*i+1;
    }

    int rChild(int i)
    {
        return 2*i+2;
    }

    int getMax()
    {
        return arr[0];
    }

    int curSize(){
        return heapsize;
    }

    void insert(int x)
    {
        if(heapsize>=maxsize)
        {
            System.out.println("Overflow: Heap is Full....");
            return;
        }
        int i=heapsize;
        arr[i]=x;
        heapsize++;
        while(i!=0 && arr[parent(i)]<arr[i])
        {
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }

    void MaxHeapify(int i)
    {
        int l=lChild(i);
        int r=rChild(i);
        int largest=i;
        if(l<heapsize && arr[l]>arr[i])
        {
            largest=l;
        }
        if(r<heapsize && arr[r]>arr[largest])
        {
            largest=r;
        }
        if(largest!=i)
        {
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            MaxHeapify(largest);
        }
    }

    void removeMax()
    {
        if(heapsize==0)
        {
            System.out.println("Heap is Empty...");
            return;
        }
        if(heapsize==1)
        {
            heapsize--;
        }
        else
        {
            arr[0]=arr[heapsize-1];
            heapsize--;
            MaxHeapify(0);
        }
    }

    public static void main(String args[])
    {
        MaxHeap h=new MaxHeap(15);
        int elements[]={3,10,12,8,2,14};
        for(int e:elements)
        {
            h.insert(e);
        }
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Maximum Element in the heap is = "+h.getMax());
        h.removeMax();
        System.out.println("After Removing Maximum Element...");
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Maximum Element in the heap is = "+h.getMax());
        h.insert(15);
        h.insert(5);
        System.out.println("After Inserting Extra Two EWlements....");
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Maximum Element in the heap is = "+h.getMax());
    }
}


/*
 * OUTPUT
 * 
 * The Current Size of the heap is = 6
The Maximum Element in the heap is = 14
After Removing Maximum Element...
The Current Size of the heap is = 5
The Maximum Element in the heap is = 12
After Inserting Extra Two EWlements....
The Current Size of the heap is = 7
The Maximum Element in the heap is = 15

 */

