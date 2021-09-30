class Solution {
    public int addDigits(int num) {
        // return superDigit(num);
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
    
    private static int getDigitSum(int n, int sum) {
        if (n == 0) return sum;
        
        return getDigitSum(n/10, sum + n%10);
    }
    
    private static int superDigit(int k) {
        
        int sum = getDigitSum(k, 0);
        
        while(sum > 9) sum = getDigitSum(sum, 0);
        
        return sum;
    }
}
