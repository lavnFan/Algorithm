
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 解决方案：
 * 1、如果要求不新增空间，则在原有字符串上，需要先计算空格的个数和占的空间，再从后往前进行移位
 * 2、工作中一般可以直接新增一个字符串，直接替换赋值
 * 
 * tips1：StringBuffer 取出的是 char 型，不是对象型
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer result = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(' ' == (str.charAt(i))){
                result.append("%20");
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}