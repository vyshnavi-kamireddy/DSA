class Solution {
    public static void print_divisors(int n) {
        // code here
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=1;i*i<=n;i++)
        {
            if(n%i==0){
                ts.add(i);
                ts.add(n/i);
            }
        }
        for(Integer ele:ts){
            System.out.print(ele+" ");
        }
    }
}


/*  TC= O(√n * log√n)  SC= O(√n) */