class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        if(intervals == null || intervals.size() == 0) return 0;

        // Sort by start time
        Collections.sort(intervals, (a,b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            
            // If earliest meeting ended, free the room
            if(!minHeap.isEmpty() && interval.start >= minHeap.peek()){
                minHeap.poll();
            }
            
            // Allocate current meeting
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}