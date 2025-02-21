//Converting a string into a zigzag pattern.

public class ZigZag {
    public String convert(String s, int numRows){

        //Edge case: If only 1 row or string length is too small, return the string as it is.
        if (numRows == 1 || s.length() <= numRows){
            return s;
        }

        //Create a list of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int i = 0, len = s.length();
        while(i < len) {
            //Moving down: Fill rows from 0 to numRows - 1
            for (int row = 0; row < numRows && i < len; row++){
                rows[row]. append(s.charAt(i++));
            }

            //Moving up Diagonally: Fill rows from numRows - 2 to 1
            for(int row = numRows -2; row > 0 && i < len; row--){
                rows[row].append(s.charAt(i++));
            }
        }

        //Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();
    }

    public static void main (String[] args){
        ZigZag sol = new ZigZag();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
        System.out.println(sol.convert("PAYPALISHIRING", 4));
        System.out.println(sol.convert("A", 1));
    }
}
