class Solution {
    public int[] twoSum(int[] arr, int sum) {
        int[] res = new int[2];
        
//         HashMap<Integer, Integer> s = new HashMap<Integer, Integer>(); 
//      for (int i = 0; i < arr.length; ++i) { 
//          int temp = sum - arr[i]; 
​
//          // checking for condition 
//          if (s.containsKey(temp)) { 
//              res[0] = i;
//                 res[1] = s.get(temp);
//                 return res;
//          }
            
//          s.put(arr[i], i); 
//      }
        
//         return res;
        
        for (int i = 1; i < arr.length; i++) {
​
            for (int j = i; j < arr.length; j++) {
​
                if (arr[j] + arr[j - i] == sum) {
​
                    res[0] = j - i;
                    res[1] = j;
​
                    return res;
                }
            }
        }
        return res;
    }
}
