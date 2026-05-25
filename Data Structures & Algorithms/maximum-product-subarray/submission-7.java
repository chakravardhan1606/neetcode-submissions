class Solution {
    public int maxProduct(int[] nums) {
       int res = nums[0];
        int currMin = 1, currMax = 1;

        for( int i =0; i<nums.length;i++){
           int temp = currMax*nums[i];

           currMax= Math.max(nums[i],Math.max(temp , nums[i]*currMin));
           currMin =  Math.min(nums[i],Math.min(temp , nums[i]*currMin));
            res = Math.max(res,Math.max(currMax,currMin));
        }
        return res;

    }
}
