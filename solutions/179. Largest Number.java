class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumberAnother(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        System.out.println(Arrays.toString(asStrs));
        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
    
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

                int len = Math.min(aLength, bLength);
                
                
                int res = compareSubString(a, b, 0, 0, len);
                
                if (res != 0) {
                    return res;
                }
                
                res = compareSubString(a, a, len, 0, aLength - len);
                
                if ( res != 0){
                    return res;
                }
                
                return compareSubString(b, a, 0, aLength - bLength , bLength);
            }
        });
        
        if (list[0].equals("0")) {
            return "0";
        }
        
        StringBuilder number = new StringBuilder();
        for (String n  : list) {
            number.append(n);
        }
        
        return number.toString();
    }
    
    private int compareSubString (String a, String b, int aStart, int bStart, int len) {
        
        while (len-- > 0) {
            
            char c1 = a.charAt(aStart++);
            char c2 = b.charAt(bStart++);
            
            if (c1 != c2) {
                return c2 - c1;
            }
        }
        
        return 0;
    }
}
