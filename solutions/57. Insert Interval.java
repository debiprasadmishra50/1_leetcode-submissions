class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean inserted = false;
        int start = newInterval[0];
        int end = newInterval[1];
        
        List<int[]> resList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < start) {
                resList.add(interval);
            } else if (interval[0] > end) {
                if (!inserted) {
                    inserted = true;
                    resList.add(new int[] {start, end });
                }
                resList.add(interval);
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        
        if (!inserted) {
            resList.add(new int[] {start, end });
        }
        
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }
}
​
