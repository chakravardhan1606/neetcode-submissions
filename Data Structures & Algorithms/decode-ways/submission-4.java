class Solution {
    public int numDecodings(String s) {
       
      int dp[] = new int [s.length()+1];
     Arrays.fill(dp,0);
     // return sp(s,0,dp); 
      dp[s.length()] =1;

     for(int i = s.length()-1; i>=0;i--){
        if(Integer.valueOf(s.substring(i,i+1))<=0)     
          dp[i]=0;

          else{
            dp[i]+=dp[i+1]; 

            if(i+1<=s.length()-1&&Integer.valueOf(s.substring(i,i+2))<=26){
                dp[i]+=dp[i+2];
            }
          }

     }

     return dp[0];
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
