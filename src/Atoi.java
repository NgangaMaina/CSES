public class Atoi {
    public int myAtoi(String s){
        int i = 0, sign = 1, result = 0;
        int n = s.length();

        //Step 1: Ignore leading whitespaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        //Step 2: check for '+' or '-' sign
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //Step 3: Convert digits to integer
        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            //Step 4: Check for overflow before updating the result
            if(result > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
