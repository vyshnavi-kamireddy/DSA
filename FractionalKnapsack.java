import java.util.*;

class Item
{
    int weight,profit;
    double ratio;
    Item(int weight,int profit)
    {
        this.profit=profit;
        this.weight=weight;
        ratio=(double)profit/weight;
    }
}

class FractionalKnapsack
{
    public static void knapsack(Item[] arr,int m)
    {
        Arrays.sort(arr,(a,b)->Double.compare(b.ratio,a.ratio));
        double maxProfit=0;
        for(Item item:arr)
        {
            if(item.weight<=m)
            {
                maxProfit+=item.profit;
                System.out.println("Weight = "+item.weight+" Profit = "+item.profit+" -Taken Fully");
                m-=item.weight;
            }
            else{
                double fraction=(double)m/item.weight;
                maxProfit+=item.profit*fraction;
                System.out.println("Weight = "+item.weight*fraction+" Profit = "+item.profit*fraction+" -Taken "+fraction*100);
                break;
            }
        }
        System.out.println("MaxProfit = "+maxProfit);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of Objects: ");
        int n=sc.nextInt();
        Item[] arr=new Item[n];
        System.out.println("Enter Weight and Profit Seperated by Spaces: ");
        for(int i=0;i<n;i++)
        {
            int w=sc.nextInt();
            int p=sc.nextInt();
            arr[i]=new Item(w,p);
        }
        System.out.println("Enter the Maximum Weight of the Knapsack: ");
        int m=sc.nextInt();
        knapsack(arr,m);
        sc.close();
    }
}



/*
 * 
 * OUTPUT
 * 
 * Enter the no.of Objects:
3
Enter Weight and Profit Seperated by Spaces: 
10 60
20 100
30 120
Enter the Maximum Weight of the Knapsack: 
50
Weight = 10 Profit = 60 -Taken Fully
Weight = 20 Profit = 100 -Taken Fully
Weight = 20.0 Profit = 80.0 -Taken 66.66666666666666
MaxProfit = 240.0



 */
