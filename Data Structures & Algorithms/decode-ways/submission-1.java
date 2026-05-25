class Solution {
    public int numDecodings(String s) {
       return dp(s,0); 
    }

    public int dp(String s, int i){
        if(i>=s.length()) return 1;
   if(Integer.valueOf(s.substring(i,i+1))<=0) return 0;

   int one = 0;
      one = dp(s,i+1);
      int two =0;
      if(i<s.length()-1&&Integer.valueOf(s.substring(i,i+2))<=26){
             two = dp(s,i+2);
      }
      return one+two;
    }
}
