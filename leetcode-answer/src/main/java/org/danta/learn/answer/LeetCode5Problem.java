package org.danta.learn.answer;

/**
 * @Author danke
 * @Date :Create in 12:42 下午 2021/2/10
 * 5.最长回文字符串
 * @Link https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LeetCode5Problem {

    public String longestPalindrome(String s) {
        if(null == s || s.trim().length() <= 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        char[] ca = s.toCharArray();
        int j = ca.length;
        int evenFront=0;
        int evenEnd=0;
        int oddFront=0;
        int oddEnd=0;
        int maxOddCycle=0;
        int maxEvenCycle=0;
        if (ca[0] == ca[1]){
            evenEnd = 1;
        }

        for (int i = 1 ;i < j-1;i++){
            int evenCycle = doIngEven(i,i,ca);
            int oddCycle = doIngOdd(i,i,ca);
            if (evenCycle >0){
                if (evenCycle > maxEvenCycle){
                    maxEvenCycle = evenCycle;
                    evenFront = i - evenCycle +1;
                    evenEnd = i+evenCycle;
                }
            }
            if (oddCycle > 0){
                if (oddCycle > maxOddCycle){
                    maxOddCycle = oddCycle;
                    oddFront = i - oddCycle;
                    oddEnd = i+oddCycle;
                }
            }
        }
        if (oddEnd -oddFront > evenEnd -evenFront){
            return s.substring(oddFront,oddEnd+1);
        }else{
            return s.substring(evenFront,evenEnd+1);
        }
    }

    private static int doIngEven(int front ,int end ,char[] str){
        int cycle = 0;
        if (str[front] == str[end+1]){
            cycle++;
            end++;
            while (front > 0 && end < str.length-1){
                if (str[front-1] != str[end+1]){
                    break;
                }
                front--;
                end++;
                cycle++;
            }
        }
        return cycle;
    }

    private static int doIngOdd(int front ,int end ,char[] str){
        int cycle = 0;
        while (front > 0 && end < str.length-1){
            if (str[front-1] != str[end+1]){
                break;
            }
            front--;
            end++;
            cycle++;
        }
        return cycle;
    }

}
