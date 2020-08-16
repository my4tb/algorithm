import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addNum(1);
//        solution.addNum(2);
        System.out.println(maxHeap);
        System.out.println(minHeap);
        System.out.println(solution.findMedian());
    }

    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); // 小数
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 大数

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if (maxHeap.size() - 1 > minHeap.size())
            minHeap.add(maxHeap.poll());
        if (minHeap.size() - 1 > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0)
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        else
            return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : (double) minHeap.peek();
    }
}
