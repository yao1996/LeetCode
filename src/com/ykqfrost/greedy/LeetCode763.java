package com.ykqfrost.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ykq
 * @date 2020/10/22
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode763 {

    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> occurs = new HashMap<>();
        List<HashMap<Character, Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            Integer pos = occurs.get(c);
            if (pos == null) {
                HashMap<Character, Integer> map = new HashMap<>();
                map.put(c, 1);
                list.add(map);
                res.add(1);
                occurs.put(c, 1);
            } else {
                int num = -1;
                HashMap<Character, Integer> current = null;
                int length = -1;
                for (int j = 0; j < list.size(); j++) {
                    HashMap<Character, Integer> map = list.get(j);
                    if (map.get(c) != null) {
                        num = j;
                        current = map;
                        length = res.get(num);
                        continue;
                    }
                    if (current != null) {
                        current.putAll(map);
                    }
                    if (length != -1) {
                        length += res.get(j);
                    }
                }
                if (list.size() > num + 1) {
                    list.subList(num + 1, list.size()).clear();
                }
                if (res.size() > num) {
                    res.subList(num, res.size()).clear();
                }
                length++;
                res.add(length);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        LeetCode763 leetCode763 = new LeetCode763();
        List<Integer> list = leetCode763.partitionLabels(s);
        System.out.println(list);
    }
}
