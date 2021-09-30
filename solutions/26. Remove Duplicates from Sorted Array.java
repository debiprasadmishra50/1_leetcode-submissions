class Solution {
    public int removeDuplicates(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res-1] != arr[i]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }
}
