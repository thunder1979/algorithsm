package net.dianlei.algo.leetcode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatChar {

    /**
     * to simplify duplication check, put all the chars of longest string into array
     * the array is a dictionary of all chars in current longest string
     * the ascii code is the index in dictionary array
     * and the in array value is the absolute position of the char in original string
     * English letters, digits, symbols and spaces
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;  // start position of longest string, closed
        int right = 0; // end position of longest string, open
        int len = 0;
        int charPos[] = new int[128]; // array for absolute positions of each char
        Arrays.fill(charPos, - 1);
        while(right < s.length()) {
            int ch = s.charAt(right);
            /**
             * if repeat char found and the char is within the string currently evaluated,
             * we need to reset the current string by adjusting the start
             */
            if(charPos[ch] >= 0 && charPos[ch] >= left) {
                left = charPos[ch] + 1;
            }
            len = Math.max(len, right - left + 1);
            charPos[ch] = right;
            right++;
        }
        return len;
    }
    // https://wenku.baidu.com/view/c3df64401dd9ad51f01dc281e53a580217fc505e.html
}
