package net.dianlei.leetcode;

import net.dianlei.algo.leetcode.LongestSubstringWithoutRepeatChar;
import net.dianlei.algo.leetcode.LongestSubstringWithoutRepeatCharSolution;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestSubstringWithoutRepeatCharTest {

    @Test
    public void testLengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatChar longestSubstringWithoutRepeatChar = new LongestSubstringWithoutRepeatChar();
        String str = "Belo~warethedetailsandprocessofhowI*gothired:Educ^ation:B.TechinComputerScience";
        // String str = "pwwkew";
        int lengthOf = longestSubstringWithoutRepeatChar.lengthOfLongestSubstring(str);
        int expected = new LongestSubstringWithoutRepeatCharSolution().lengthOfLongestSubstring(str);
        Assert.assertEquals(lengthOf, expected);
        System.out.println("lengthOf:" + lengthOf + " expected:" + expected);

        str = "pwwkew";
        lengthOf = longestSubstringWithoutRepeatChar.lengthOfLongestSubstring(str);
        expected = new LongestSubstringWithoutRepeatCharSolution().lengthOfLongestSubstring(str);
        Assert.assertEquals(lengthOf, expected);
    }
}
