class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int x=n;
        int sum=0;
        int length=(int)Math.log10(n)+1;
        while(n!=0)
        {
            int rem=n%10;
            sum+=Math.pow(rem,length);
            n=n/10;
        }
        if(x==sum) return true;
        else return false;
    }
}

/* TC= O(log n)  SC= O(1) */