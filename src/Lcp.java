public class Lcp {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0]; //Start with the first string as the prefix

        for(int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Lcp sol = new Lcp();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(sol.longestCommonPrefix(strs2)); // Output: ""
    }
}
