import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones)
            queue.add(stone);
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int c = a - b;
            if (c != 0)
                queue.add(c);
        }
        if (queue.size() == 0)
            return 0;
        return queue.peek();
    }
}
