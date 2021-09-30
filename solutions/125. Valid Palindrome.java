class Solution {
    public boolean isPalindrome(String s) {
//         s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//      int i = 0, j = s.length()-1;
        
//      // while (i < j) {
//      //  if (s.charAt(i) != s.charAt(j))
//      //      return false;
//      //  i++; j--;
//      // }
//      // return true;
//         StringBuilder sb = new StringBuilder(s);
//      StringBuilder reverse = sb.reverse();
        
//         return s.equals(reverse.toString());
        
        char[] input = new char[s.length()];
​
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                input[i++] = ch;
            if (ch >= 'A' && ch <= 'Z')
                input[i++] = (char) ((int) ch + 32);
            if (ch >= '0' && ch <= '9')
                input[i++] = ch;
        }
​
        int len = i;
​
        int head = 0;
        int tail = len - 1;
​
        while (head < tail) {
            if (input[head] != input[tail])
                return false;
            head++;
            tail--;
        }
        return true;
    }
}
