class Solution { 
    public int minEatingSpeed(int[] piles, int h) {
        int maxe = Integer.MIN_VALUE;
        for (int num : piles) {
            maxe = Math.max(num, maxe);
        }

        int start = 1; // Eating speed cannot be 0
        int end = maxe;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // Prevent overflow
           
            if (help(piles, mid, h)) { // Check if mid is a valid eating speed
                res = mid;
                end = mid - 1; // Try to find a smaller valid speed
            } else {
                start = mid + 1; // Increase speed
            }
        }
        return res;    
    }

    // Helper method to calculate hours required to eat all piles at speed k
    public boolean help(int[] nums, int k, int h) {
        int hour = 0;
        for (int i = 0; i < nums.length; i++) {
            hour += (nums[i] + k - 1) / k; // Math.ceil(nums[i] / k) without floating point
        }
        return hour <= h;
    }
}
