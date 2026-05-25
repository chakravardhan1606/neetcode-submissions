class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(a)- hm.get(b));
        for(int i =0; i<nums.length;i++){
             
             hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }

      for(int n : hm.keySet()){
           pq.add(n);
           if(pq.size()>k) pq.poll();
      }
        int i =0;
        while(!pq.isEmpty()) res[i++] = pq.poll();

        return res;
    }
}
class Pair{
    int num;
    int frequency;

    Pair(int num , int frequency){
        this.num = num;
        this.frequency = frequency;
    }
}
