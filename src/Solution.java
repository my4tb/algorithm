import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{9,1,7,9,7,9,7}));
    }

    public int singleNumber(int[] nums) {
        int[] countBits = new int[32];
        for (int num : nums) {
            int time = 1;
            for (int i = 0; i < 32; i++) {
                if ((num & (time << i)) != 0)
                    countBits[i]++;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res += (countBits[i] % 3);
        }
        return res;
    }

}
