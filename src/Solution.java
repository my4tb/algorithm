import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {3, 1, 2, 3, 6, 3, 7, 8, 5, 3};
        for (int i = 0; i < nums.length; i++) {
            solution.heapInsert(i, nums);
        }
        System.out.println(Arrays.toString(nums));
        nums[0] = 0;
        solution.heapify(0, nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public void heapify(int idx, int[] nums, int heapSize) {
        int left = idx * 2 + 1;
        while (left < heapSize) {
            int largest;
            if (left + 1 < heapSize) { // has right child
                largest = nums[left] > nums[left + 1] ? left : left + 1;
            }
            else { // only left child
                largest = left;
            }
            if (nums[idx] >= nums[largest])
                break;
            swap(idx, largest, nums);
            idx = largest;
            left = idx * 2 + 1;
        }
    }

    public void heapInsert(int idx, int[] nums) {
        while (nums[idx] > nums[(idx - 1) / 2]) {
            swap(idx, (idx - 1) / 2, nums);
            idx = (idx - 1) / 2;
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

}
