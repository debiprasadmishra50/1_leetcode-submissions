class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = indexOfFirstOccurance(nums, target);
        res[1] = indexOfLastOccurance(nums, target);
        
        return res;
    }
    
    private static int indexOfFirstOccurance(int[] arr, int x) {
		int low = 0, high = arr.length-1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;
			else {
				if (mid == 0 || arr[mid-1] != arr[mid])
					return mid;
				else
					high = mid - 1;
			}
		}
		
		return -1;
	}
    
    private static int indexOfLastOccurance(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] < x)
				low = mid + 1;
			else if (arr[mid] > x)
				high = mid - 1;
			else {
				if (mid == arr.length-1 || arr[mid+1] != arr[mid])
					return mid;
				else
					low = mid + 1;
			}
		}
		
		return -1;
	}
}
