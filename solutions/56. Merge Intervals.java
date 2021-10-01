class Solution {
    public int[][] mergeAnother(int[][] intervals) {
         // Step 1: Base Case
        if(intervals.length <= 1){
            return intervals;
        }
        
        // Step 2: Sort the array based on 1st element
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        // Step 3: Declare current result
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        // Step 4: Declare an arraylist to store pairs
        List<int[]> list = new ArrayList<>();
        
        // Step 4: Start from 2nd pair & compare with prev result
        for(int i=1;i<intervals.length;i++){
            
            int first = intervals[i][0];
            int second = intervals[i][1];
            
            // Step 4.1: It's part of prev interval
            if(first <= end){
                start = Math.min(start, first);
                end = Math.max(end, second);
            }
            // Step 4.2: It's not part of prev interval, push prev pair 
            // to final result & make the current pair as current result
            else{
                int[] temp = new int[]{start, end};
                list.add(temp);
                start = first;
                end = second;
            }
            
        }
        
        // Step 5: Push the remaining pair to final result
        int[] temp = new int[]{start, end};
        list.add(temp);
        
        return list.toArray(new int[list.size()][]);
    }
    
    public int[][] merge(int[][] intervals) {
        int nMerged = 1;
        for(int i = 0; i< intervals.length; i++) {
            int[] interval = intervals[i];
            int m0 = interval[0];
            int m1 = interval[1];
            int nRemain = 0;
            for(int j = 0; j<nMerged; j++) {
                int[] candidate = intervals[j];
                int c0 = candidate[0];
                int c1 = candidate[1];
                if(c1 < m0) {
                    nRemain++;
                } else if(m1 < c0) {
                    intervals[nRemain++] = interval;
                    interval = candidate;
                } else {
                    if(c0 < m0) interval[0] = m0 = c0;
                    if(c1 > m1) interval[1] = m1 = c1;
                }
            }
            intervals[nRemain++] = interval;
            nMerged = nRemain;
        }
        
        int[][] result = new int[nMerged][];
        for(int i = 0; i<nMerged; i++) {
            result[i]= intervals[i];
        }
        return result;
    }
}

// class SortComparator implements java.util.Comparator {
//     @Override
// 	public int compare(int[] a, int[] b) {
//         return a[0] - b[0];
// 	}
// }
