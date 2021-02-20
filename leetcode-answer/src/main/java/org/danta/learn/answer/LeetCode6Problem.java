package org.danta.learn.answer;

/**
 * @Author danke
 * @Date :Create in 12:42 下午 2021/2/10
 * 6.z字形变换
 * @Link https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class LeetCode6Problem {

    public String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1;i<=numRows;i++){
            int z = 0;
            //从第一排开始
            int headIndex;
            if (i == 1){
                while ((headIndex = 2*(numRows-1)*z+1) <= cs.length){
                    sb.append(cs[headIndex-1]);
                    z++;
                }
                continue;
            }
            //最后一排
            if (i % numRows == 0){
                while ((headIndex = 2*(numRows-1)*z+numRows) <= cs.length){
                    sb.append(cs[headIndex-1]);
                    z++;
                }
                continue;
            }
            while (true){
                headIndex = 2*z*numRows-2*z+1;
                int first = headIndex + i -1;
                if (first > cs.length){
                    break;
                }
                sb.append(cs[first-1]);

                int second = headIndex +  (numRows - 1)+ (numRows -i);
                if (second > cs.length){
                    break;
                }
                sb.append(cs[second-1]);
                z++;
            }
        }
        return sb.toString();
    }

}
