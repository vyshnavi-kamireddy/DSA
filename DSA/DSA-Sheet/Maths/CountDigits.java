class Solution {
    public int countDigits(int n) {
        return (int)(Math.log10(n))+1;
    }
}

/*
     Tc= O(1) SC= O(1)
 */
