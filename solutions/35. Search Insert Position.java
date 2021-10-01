class Solution {
    public int searchInsert(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        // If last element is smaller than x
        if (x > arr[high])
            return high+1;
        // If first element is greater than x
        if (arr[0] >= x)
            return 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // System.out.println(x+" "+low+" "+mid+" "+high);
            // System.out.println("[+]"+arr[low]+" "+arr[mid]+" "+arr[high]);
             
            if (arr[mid] == x)
                return mid;
            
            else if (mid > 0 && arr[mid-1] <= x && x < arr[mid]) {
                if (arr[mid-1] == x)
                    return mid - 1;
                else
                    return mid;
            }
            
            else if (x < arr[mid])
                high = mid - 1;
            
            else
                low = mid + 1;
        }
        
        return -1;
    }
}
