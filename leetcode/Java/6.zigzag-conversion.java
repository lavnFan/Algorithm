/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.40%)
 * Total Accepted:    297.5K
 * Total Submissions: 958.2K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    /**
    * 之字形排列，然后按横向输出
    * 思路：
    * 1、每行可以构成一个字符串，再按序输出，不同行对字符根据row分散到不同到字符串中
    * 2、计算每行每列位于字符串中到哪一个，第k列第i行的字符就是第 k*(2n - 2) + i 或 (k + 1)*(2n - 2) - i
    * tips:
    * array 声明和赋值
    */
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1){
            return s;
        }
        List<StringBuilder> sbArray = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            sbArray.add(new StringBuilder());
        }
        int curRow = 0, position = -1;
        for(int i = 0; i < s.length(); i++){
            sbArray.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1){
                position = - position;
            }
            curRow += position;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sbArray.size(); i++){
            result.append(sbArray.get(i).toString());
        }
        return result.toString();
    }
}
