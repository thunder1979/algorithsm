package net.dianlei.algo.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class LongestSubstringWithoutRepeatCharV1 {

    /**
     * to ease duplication check, put all the chars of longest string into array
     * the array is a dictionary of the char in current longest string
     * the ascii value is the index in dictionary array
     * and the value is the absolute position of the char in original string
     * English letters, digits, symbols and spaces
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0; // start position of longest string
        int len = 0; // length of longest string
        int currentStart = 0; // start of next possible longest string
        int currentLen = 0; // length of next possible longest string

        int charDic[] = new int[128];
        // initialize the dictionary with -1 to indicate that there is no such char in current longest string
        Arrays.fill(charDic, - 1000);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++) {
            // test if repeat
            int ch = chars[i];
            if(charDic[ch] < 0) {
                // no repeat char
                // absolute position of the char in original string
                charDic[ch] = i;
                currentLen++;
            } else {
                /**
                 * repeat char, need to reset the longest string
                 * clean all the chars before first occurrence of repeated char in dictionary
                 * including the repeated char
                 * reset the longest string and start over
                 * if current string is longer than previous one, need to override the start and length of previous one
                 */
                int nextStart = charDic[ch] + 1;
                for(int j = currentStart; j < nextStart; j ++) {
                    charDic[chars[j]] = -1000;
                }
                if(len < currentLen) {
                    start = currentStart;
                    len = currentLen;
                }
                currentStart = nextStart;
                currentLen = i - nextStart;
                // add current ch into current longest string
                charDic[ch] = i;
                currentLen ++;
            }
        }
        if(len < currentLen) {
            start = currentStart;
            len = currentLen;
        }
        System.out.println("start:" + start + " len:" + len);
        return len;
    }
    // https://wenku.baidu.com/view/c3df64401dd9ad51f01dc281e53a580217fc505e.html
}
