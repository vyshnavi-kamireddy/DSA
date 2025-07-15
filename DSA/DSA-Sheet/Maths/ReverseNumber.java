class Solution {
    public int reverse(int x) {
        double rev=0;
        while(x!=0)
        {
            int rem=x%10;
            rev=rev*10+rem;
            x=x/10;
        }
        double range=Math.pow(2,31);
        if(rev>=-range && rev<range) return (int)rev;
        else return 0;
    }
}

/* TC=O(log(n))   SC=O(1) */