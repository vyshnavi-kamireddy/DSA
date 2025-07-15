class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n=x;
        int rev=0;
        while(n!=0)
        {
            int rem=n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        if(x==rev) return true;
        else return false;
    }
}

/* TC=O(log(n))    SC= O(1)   */