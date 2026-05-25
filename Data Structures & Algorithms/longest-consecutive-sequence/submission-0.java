class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
       for( int i =0; i<nums.length;i++){
        hm.put(i,nums[i]);
       }
    int ans =0; 
       for(int i =0; i<nums.length;i++){
        int num = nums[i];int count =0; 
        while(hm.containsValue(num)){
       count++;
       num--;
        }
        ans= Math.max(ans,count);
       }
       return ans;
    }
}
