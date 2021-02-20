package org.danta.learn.answer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author danke
 * @Date :Create in 12:42 下午 2021/2/10
 * 20.有效字符串
 * @Link https://leetcode-cn.com/problems/valid-parentheses/
 */
public class LeetCode20Problem {

    public boolean isValid(String s) {
        //映射
        char sl = '(';
        char ml = '[';
        char bl = '{';
        char sr = ')';
        char mr = ']';
        char br = '}';
        Map<Character,Integer> container = new HashMap<>();
        container.put(sl,-1);
        container.put(ml,-2);
        container.put(bl,-3);
        container.put(sr,1);
        container.put(mr,2);
        container.put(br,3);

        //结果集
        boolean result = true;

        char[] stChar = s.toCharArray();
        //定义数组栈,长度为st的字符串长度
        int[] stack = new int[s.length()];
        //定义栈顶指针位置
        int index = 0;
        for (int i = 0;i<stChar.length;i++){

            char element = stChar[i];

            Integer map = container.get(element);
            //如果小于0,说明左括号,压入栈
            if (map<0){

                stack[index++] = map;

            }else{//大于0取出,栈顶元素,与之匹配,如果匹配,则继续,反之,则跳出,处理结果
                if (index == 0){
                    result = false;
                    break;
                }
                int leftMap = stack[--index];
                if (Math.abs(leftMap) != map){
                    result = false;
                    break;
                }
            }
        }
        return result && index == 0;
    }

}
