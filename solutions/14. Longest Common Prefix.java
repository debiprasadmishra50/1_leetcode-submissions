class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 1)
            return strs[0];
​
        String first = "";
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].equals(""))
                continue;
            else {
                first = strs[i];
                break;
            }
        }
        
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < first.length())
                first = strs[i];
        }
        
        
        for (int i = 0; i < strs.length; i++) {
            String second = strs[i];
            int f = first.length(), s = second.length();
            int a = 0, b = 0;
            
            // System.out.println(first+" "+second);
            
            // skip duplicates
            while (i+1 < strs.length && strs[i].equals(strs[i+1])) {
                i++;
                if (i == strs.length-1)
                    res = strs[i];
            }
