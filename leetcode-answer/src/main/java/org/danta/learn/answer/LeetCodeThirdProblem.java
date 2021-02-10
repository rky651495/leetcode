package org.danta.learn.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author danke
 * @Date :Create in 12:42 下午 2021/2/10
 * 3.无重复字符的最长字符串
 * @Link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LeetCodeThirdProblem {

    private static String td = "abba";

    public static void main(String[] args) {

        char[] tc = td.toCharArray();

        int result = 0;//这个是返回的结果集
        int tmp = 0;//这个是一直遍历的值
        int head = 0;
        Map<Character,Integer> table = new HashMap<>(tc.length);

        for (int i = 0;i<tc.length;i++){

            if (table.containsKey(tc[i])){//如果包含,说明重复,比较长度

                if(tmp > result){//遇到重复,先保存
                    result = tmp;//保存当前值
                }

                char currentIndex = tc[i];
                int oldIndex = table.get(currentIndex);

                if (head <= oldIndex || head == 0){//记录下重复字段的偏移量,作为接下去遍历的起点
                    head = oldIndex+1;
                }

                //计算当前临时变量的遍历值

                tmp = i - head +1;

                //然后从当前值继续往后遍历
                table.put(currentIndex,i);
            }else {
                table.put(tc[i],i);
                tmp++;
            }
        }
        System.out.println(Math.max(result,tmp));
        //return Math.max(tmp,result);
    }

}
