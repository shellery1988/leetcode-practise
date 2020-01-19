package com.leetcode.practise.practise3;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   liuss
 * Date:     2020/1/15 20:33
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/longest-substring-without-repeating-characters
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstringForce(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        String filterStr = "";
        for(int n=0; n<chars.length; n++){
            Character c = s.charAt(n);
            if(set.contains(c)){
                if("".equals(filterStr)){
                    filterStr = s.substring(s.indexOf(c)+1, n+1);
                } else {
                    filterStr = filterStr.substring(filterStr.indexOf(c)+1) + c;
                }
                set = stringToSet(filterStr);
                set.add(c);
                if(i>j){
                    j = i;
                }
                i=set.size();
            } else {
                filterStr = filterStr + c;
                set.add(c);
                i++;
            }
        }
        if(i>j){
            j = i;
        }
        return j;
    }

    public static Set<Character> stringToSet(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c: chars){
            set.add(c);
        }
        return set;
    }

    public static void main(String[] args) {
        String str = "bbtablud";
        System.out.println(lengthOfLongestSubstringForce(str));
    }

}
