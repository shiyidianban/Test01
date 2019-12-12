package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月28日上午10:15:00
 * 请实现一个函数用来匹配包括'.'和''的正则表达式。模式中的字符'.'表示任意一个字符，而''表示它前面的字符可以出现任意次（包含0次）
 * 思路：当字符串只有一个字符时，进行判断，否则就有两种递归情况，
 * （1）当模式中的第二个字符不是“”时：
 * 如果字符串第一个字符和模式中的第一个字符相匹配或是点那么字符串和模式都后移一个字符，然后匹配剩余的；
 * 如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * （2）当模式中的第二个字符是“”时：如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配；
 * 如果字符串第一个字符跟模式第一个字符匹配或是点，可以有3种匹配方式：
 * 1 >模式后移2字符，相当于x被忽略；
 * 2 >字符串后移1字符，模式后移2字符；
 * 3 >字符串后移1字符，模式不变，即继续匹配字符下一位，因为 可以匹配多位；
 */
public class T53 {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        // 若字符串的长度为1
        if (str.length == 1) {
            if (pattern.length == 1) {
                if (str[0] == pattern[0] || pattern[0] == '.')
                    return true;
                return false;
            }
        }
        int sindex = 0;
        int pindex = 0;
        return matchIndex(str, sindex, pattern, pindex);
    }

    public boolean matchIndex(char[] str, int sindex, char[] pattern, int pindex) {
        // str和pattern同时到达末尾，则匹配成功
        if (sindex == str.length && pindex == pattern.length)
            return true;
        // 若pattern先到尾，而str没有到达末尾，则匹配失败
        if (sindex != str.length && pindex == pattern.length)
            return false;
        // 若pattern第二个字符是*
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            if (sindex != str.length && pattern[pindex] == str[sindex]
                    || sindex != str.length && pattern[pindex] == '.') {
                return matchIndex(str, sindex + 1, pattern, pindex + 2) || matchIndex(str, sindex, pattern, pindex + 2)
                        || matchIndex(str, sindex + 1, pattern, pindex);
            } else {
                return matchIndex(str, sindex, pattern, pindex + 2);
            }
        } // 若pattern第二个字符不是*
        if (sindex != str.length && pattern[pindex] == str[sindex] || sindex != str.length && pattern[pindex] == '.')
            return matchIndex(str, sindex + 1, pattern, pindex + 1);
        return false;
    }

}
