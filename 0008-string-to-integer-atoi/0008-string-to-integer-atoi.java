class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1;
        long res = 0;
        
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) 
            sign = s.charAt(i++) == '-' ? -1 : 1;
            
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i++) - '0');
            long val = res * sign;
            if (val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        
        return (int) (res * sign);
    }
}