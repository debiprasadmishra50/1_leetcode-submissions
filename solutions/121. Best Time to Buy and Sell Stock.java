class Solution {
    public int maxProfit(int[] arr) {
//         if (arr.length < 2)
//             return 0;
        
//         int diff = arr[1] - arr[0], minVal = arr[0];
        
//      for (int i = 1; i < arr.length; i++) {
//          diff = Math.max(diff, arr[i] - minVal);
//          minVal = Math.min(minVal, arr[i]);
//      }
        
//      return diff <= 0 ? 0 : diff;
        
        int min = Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min)
                min=arr[i];
            
            if(arr[i]-min>max)
                max=arr[i]-min;
        }
        return max;
    }
}
