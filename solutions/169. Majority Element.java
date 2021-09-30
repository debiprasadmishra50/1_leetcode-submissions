class Solution {
    public int majorityElement(int[] arr) {
        int res = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
            else
                count--;
​
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
​
        // check if candidate is actually the majority
        count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[res] == arr[i])
                count++;
        if (count <= (arr.length / 2))
//          res = -1; 
            return -1;
​
        return arr[res];
    }
}
