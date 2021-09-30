class Solution {
    public int addDigits(int num) {
        return superDigit(num);
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
