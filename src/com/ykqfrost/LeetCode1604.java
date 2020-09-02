package com.ykqfrost;

/**
 * @author ykq
 * @date 2020/9/2
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 理解题：
 * 1、小数点只能出现一次
 * 2、+-只能出现在开头或者e后面
 * 3、e、E相同，只能出现一次且后续无小数点
 */
public class LeetCode1604 {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numFlag = false;
        boolean eFlag = false;
        boolean dotFlag = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numFlag = true;
            } else if ((c == 'e' || c == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            } else if (c == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            } else if ((c == '-' || c == '+') && (i == 0 || (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))) {

            } else {
                return false;
            }
        }
        // 必须出现过数字，且最后一位不是E
        return numFlag;
    }
}
