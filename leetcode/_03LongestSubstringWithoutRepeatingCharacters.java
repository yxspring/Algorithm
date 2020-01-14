package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ProjectName: BCDS
 * @Package: leetcode
 * @ClassName: _03LongestSubstringWithoutRepeatingCharacters
 * @Author: yuxingsheng
 * @Description:
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/14 15:40
 * @Version: 1.0
 */
public class _03LongestSubstringWithoutRepeatingCharacters {
    /**
     * 改造暴力法
     * */
    public int lengthOfLongestSubstring2(String s) {
        int ans=0;
        int i=0,j=0;
        HashSet<Character> set=new HashSet<Character>();
        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    /**使用set  存在超时问题*/
    public int lengthOfLongestSubstring1(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(uninCharacters(s,i,j)){
                    ans=Math.max(ans,j-i);
                }else{
                    break;
                }
            }
        }
        return ans;
    }
     /**定义一个函数,遍历i-j之间的字符串看看是否存在重复的,不重复返回true,否则返回false*/
    public boolean uninCharacters(String s,int start,int end){
        HashSet<Character> set=new HashSet<Character>();
        for(int i=start;i<end;i++){
            Character ch=s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    /**使用map
     * 思路如下：
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，
     * 加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
     * 此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)O(n)
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public int lengthOfLongestSubstring(String s){
        int ans=0,start=0,end=0,n=s.length();
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        while(start<n&&end<n){
            if(map.containsKey(s.charAt(end))){
                start=Math.max(map.get(s.charAt(end)),start);
            }
            map.put(s.charAt(end),++end);
            ans=Math.max(ans,end-start);
        }
        return ans;
    }




    public static void main(String[] args) {
        _03LongestSubstringWithoutRepeatingCharacters ls=new _03LongestSubstringWithoutRepeatingCharacters();
        String s="abba";
        System.out.println(ls.lengthOfLongestSubstring(s));

    }
}
