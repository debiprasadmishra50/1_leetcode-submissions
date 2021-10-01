class Solution {
    private class LargerNumberComparator implements Comparator<String> {↔}
​
    public String largestNumberAnother(int[] nums) {↔}
    
    public String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        
        for (int index = 0; index < list.length ; index++) {
            list[index] = Integer.toString(nums[index]);
        }
        
        Arrays.sort(list, new Comparator<String>() {
            
            public int compare(String a, String b) {
                int aLength = a.length();
                int bLength = b.length();
                
                if (aLength < bLength) {
                    return this.compare(b, a) * -1;
                }
​
                int len = Math.min(aLength, bLength);
                
                
                int res = compareSubString(a, b, 0, 0, len);
                
                if (res != 0) {
                    return res;
                }
                
                res = compareSubString(a, a, len, 0, aLength - len);
                
                if ( res != 0){
                    return res;
                }
