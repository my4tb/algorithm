public class Solution {

    private static int maxPathSum(TreeNode root) {

        return 0;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverseBetween(node1, 1, 4);
        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), p = dummy;
        dummy.next = head;
        int count = 0;
        while (count < m - 1) { // 找到第m - 1个节点
            p = p.next;
            count++;
        }
        ListNode p1 = p.next; // 第m个节点
        // 删除n - m次第m个节点后的节点，进行头插
        for (int i = 0; i < n - m; i++) {
            // 移除下一个节点
            ListNode removed = p1.next;
            p1.next = removed.next;
            // 将移除的节点头插
            removed.next = p.next;
            p.next = removed;
        }
        return dummy.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * n个球m个盒子，球相同，盒子相同，每个盒子都不能为空，求有多少种放法。
     * @param n 球个数
     * @param m 盒子个数
     * @return 放法
     */
    private static int f(int n, int m) {
        /*
            只有1个盒子或球与盒子个数相同，只有一种放法。
         */
        if (m == 1 || m == n)
            return 1;
        /*
            如果盒子数大于球数，放法为0.
         */
        else if (m > n)
            return 0;
        /*
            如果盒子个数为2，有 n / 2 种放法（向下取整）。
         */
        else if (m == 2)
            return n / 2;
        /*
            如果球数大于盒子数，因为要保证每个盒子都有一个球，因此先拿出m个球，分别放入m个盒子中，
            这样就保证了每个盒子至少有一个球，然后剩下residue = n - m个球，接下来的问题就是将
            residue个球放入m个盒子的若干子问题：把residue个球放入1、2、...、m个盒子，每种情况相
            加，就是最终要得到的结果。
         */
        else {
            int result = 0;
            int residue = n - m;
            for (int i = 1; i <= m; i++)
                result += f(residue, i);
            return result;
        }
    }

}
