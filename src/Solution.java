import java.util.Arrays;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++)
            nums[i]  = getRandomInterval();
        System.out.println(Arrays.toString(nums));
    }

    private static int getRandomInterval() {
        return new Random().nextInt(200) - 100;
    }

    /**
     * n个球m个盒子，球相同，盒子相同，每个盒子都不能为空，求有多少种放法。
     *
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
