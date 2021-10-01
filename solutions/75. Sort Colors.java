class Solution {
    public void sortColors(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[low] and arr[mid]
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++; mid++;
            } else if (arr[mid] == 1)
                mid++;
            else {
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
//          System.out.println(Arrays.toString(arr));
        }
    }
}
