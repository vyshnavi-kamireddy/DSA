import java.util.*;

class MinHeap{
    int[] arr;
    int heapsize,maxsize;
    MinHeap(int maxsize)
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

    int getMin()
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
        while(i!=0 && arr[parent(i)]>arr[i])
        {
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }

    void MinHeapify(int i)
    {
        int l=lChild(i);
        int r=rChild(i);
        int smallest=i;
        if(l<heapsize && arr[l]<arr[i])
        {
            smallest=l;
        }
        if(r<heapsize && arr[r]<arr[smallest])
        {
            smallest=r;
        }
        if(smallest!=i)
        {
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            MinHeapify(smallest);
        }
    }

    void removeMin()
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
            MinHeapify(0);
        }
    }

    public static void main(String args[])
    {
        MinHeap h=new MinHeap(15);
        int elements[]={3,10,12,8,2,14};
        for(int e:elements)
        {
            h.insert(e);
        }
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Minimum Element in the heap is = "+h.getMin());
        h.removeMin();
        System.out.println("After Removing Minimum Element...");
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Minimum Element in the heap is = "+h.getMin());
        h.insert(15);
        h.insert(5);
        System.out.println("After Inserting Extra Two EWlements....");
        System.out.println("The Current Size of the heap is = "+h.curSize());
        System.out.println("The Minimum Element in the heap is = "+h.getMin());
    }
}

/*
 * OUTPUT
 * The Current Size of the heap is = 6
The Minimum Element in the heap is = 2
After Removing Minimum Element...
The Current Size of the heap is = 5
The Minimum Element in the heap is = 3
After Inserting Extra Two EWlements....
The Current Size of the heap is = 7
The Minimum Element in the heap is = 3
 */
