class Solution {
    public int numDecodings(String s) {
       
      int dp[] = new int [s.length()+1];
     Arrays.fill(dp,-1);
      return sp(s,0,dp); 
    }

    public int sp(String s, int i, int [] dp){
        if(i>=s.length()) return 1;
        if(dp[s.length()-i]!=-1) return dp[s.length()-i]; 

   if(Integer.valueOf(s.substring(i,i+1))<=0) return 0;

   int one = 0;
      one = sp(s,i+1,dp);
      int two =0;
      if(i<s.length()-1&&Integer.valueOf(s.substring(i,i+2))<=26){
             two = sp(s,i+2,dp);
      }
      dp[s.length()-i] = one+two;
      return one+two;
    }
}
