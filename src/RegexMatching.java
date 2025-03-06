public class RegexMatching {
    public boolean isMatch(String s, String p){
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; //empty string matches empty pattern

        //Handle cases where pattern has "*" at even indices
        for (int j = 2; j <= n; j+=2){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 2]; // '*' can mean removing preciding character
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j=1; j <= n; j++){
                char sc = s.charAt(i - 1); // current character in s
                char pc = p.charAt(j - 1); //Current character in p

                if(pc == '.' || pc == sc){
                    dp[i][j] = dp[i-1][j-1]; //Direct match or wildcard mactch
                }else if(pc == '*'){
                    char prev = p.charAt(j - 2); //Character before "*"
                    dp[i][j] = dp[i][j-2]; // '*' means zero occurrence
                    if(prev == '.' || prev == sc){
                        dp[i][j] |= dp[i-1][j];// '*' means one  or more occurrences
                    }
                }
            }
        }
        return dp[m][n]; //Check if the entire string matches
    }
}
