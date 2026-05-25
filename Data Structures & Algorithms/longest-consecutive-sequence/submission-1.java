class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hm = new HashSet<>();
       for( int i =0; i<nums.length;i++){
        hm.add(nums[i]);
       }
    int ans =0; 
       for(int i =0; i<nums.length;i++){
        int num = nums[i];int count =0; 

        while(hm.contains(num)){
       count++;
       num--;
        }
        ans= Math.max(ans,count);
       }
       return ans;
    }
}
