class Solution {
    public int maxArea(int[] heights) {
        int res =0;
        int i= 0; int j = heights.length-1;

        while(i<j){
        
         if(heights[i]<=heights[j]){
          int len =j-i;
          res=Math.max(heights[i]*len,res) ;
          i++;

         }
         else{
            int len = j-i;
            res=Math.max(heights[j]*len,res) ;
            j--;
         }

        } 
        return res;
    }
}
