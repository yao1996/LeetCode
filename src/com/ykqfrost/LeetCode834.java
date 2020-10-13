package com.ykqfrost;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/10/6
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 * <p>
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 * <p>
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 * 0
 * / \
 * 1   2
 * /|\
 * 3 4 5
 * <p>
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * 说明: 1 <= N <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode834 {

    private ArrayList<ArrayList<Integer>> nodeList;
    private int[] answers;
    /**
     * 树的子节点数量
     */
    private int[] counts;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        answers = new int[N];
        counts = new int[N];
        nodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodeList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            ArrayList<Integer> node1s = nodeList.get(node1);
            node1s.add(node2);
            ArrayList<Integer> node2s = nodeList.get(node2);
            node2s.add(node1);
        }
        postOrder(0, -1);
//        System.out.println(Arrays.toString(counts));
//        System.out.println(Arrays.toString(answers));
        preOrder(0, -1);
        return answers;
    }

    // 后序遍历
    private void postOrder(int node, int parent) {
        ArrayList<Integer> sons = nodeList.get(node);
        for (int son : sons) {
            if (son == parent) {
                continue;
            }
            postOrder(son, node);
            counts[node] += counts[son] + 1;
            answers[node] += answers[son] + counts[son] + 1;
        }
    }

    private void preOrder(int node, int parent) {
        ArrayList<Integer> sons = nodeList.get(node);
        for (int son : sons) {
            if (son == parent) {
                continue;
            }
            answers[son] = answers[node] + counts[0] + 1 - counts[son] * 2 - 2;
            preOrder(son, node);
        }
    }

    public static void main(String[] args) {
        LeetCode834 leetCode834 = new LeetCode834();

        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
//        int[][] edges = {{1, 3}, {5, 0}, {2, 5}, {6, 2}, {4, 2}, {6, 3}};
//        int[][] edges = {{1, 2}, {3, 2}, {3, 0}};
//        int[][] edges = {{2, 3}, {0, 3}, {4, 1}, {4, 3}};
        int[] answers = leetCode834.sumOfDistancesInTree(6, edges);
        System.out.println(Arrays.toString(answers));
    }

}
