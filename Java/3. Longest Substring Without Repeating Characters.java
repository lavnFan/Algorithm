/* 
3. Longest Substring Without Repeating Characters
 求最长连续的不重复子串长度

 Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3.
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        //寻找最长不重复字串
        
        int maxLength = 0;
        int n = s.length();
        
        //方案一：朴素匹配，遍历时，根据起始值构造子串，再判断是否为重复，比较大小返回最长，O(T) = O(n^3)
        //tips1:判重复，是否存在，可以多考虑hash

        //预定子串：取 s 的 i 到 j
        // for(int i = 0; i < n; i++){
        //     for(int j = i + 1; j <= n; j++){
        //         if(isUnique(s, i ,j)){  //子串无重复
        //             maxLength = Math.max(maxLength, j - i);
        //             continue;
        //         }else{
        //             break;
        //         }
        //     }
        // }
        
        //相对朴素匹配的改进：比较子串是否有重复时，不需要每次都比较，有一些包含关系的算是重复比较
        //方案二：滑动窗口算法，使用一个不重复串窗口，用 hash 表示，若有相同，则平移窗口，否则继续扩张
        // Set<Character> slide = new HashSet<>();
        // int i = 0, j = 0;
        // while(i < n && j < n){
        //     //i 表示滑动窗口的起始值，j为窗口滑动值
        //     if(!slide.contains(s.charAt(j))){
        //         slide.add(s.charAt(j++));
        //         maxLength = Math.max(maxLength, j - i);
        //     }else{
        //         slide.remove(s.charAt(i++));
        //     }
        // }
        
        //相对滑动窗口改进：若重复后，不用从下一个开始，而是从重复的那个字符的下一个开始，避免重复
        //方案三：将时间从 O(2n) 降为 O(n)
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){  
                //1、保持继续向前，可能map中存储的值比较老，不能回溯
                //2、若判断相等的值不在当前子串，则此时 i 会保持不变，并更新字符对应的索引，继续向前比较；即保证比较相等的串在 i 之后
                i = Math.max(i, map.get(s.charAt(j)));
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        
        
        
        
        return maxLength;
    }
    
    public static boolean isUnique(String s, int start, int end){
        //子串无重复比较
        Set<Character> hashSet = new HashSet<>();
        for(int i = start; i < end; i++){
            Character c = s.charAt(i);
            if(hashSet.contains(c)){
                return false;
            }else{
                hashSet.add(c);
            }
        }
        return true;
    }
}