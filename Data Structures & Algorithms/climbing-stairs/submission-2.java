class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
       
       int [] dp = new int [n];

      int nextPrev=1;
     int  prev = 2;
     int curr =0;
       
      for(int i =2; i<dp.length;i++){
          curr = nextPrev+prev;
          nextPrev = prev;
          prev = curr;
      } 
      return curr;
    }
}
