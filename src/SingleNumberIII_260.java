public class SingleNumberIII_260 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1,2, 5, 3, 7, 4};
        singleNumber(nums);
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums)// 一样的抵消,不一样的两个数字异或运算结果必定有一位是1
        {
            xor ^= i;

        }

        int mask = xor & (-xor);

        int[] ans = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0)//== 0、 == mask 两种结果
            {
                ans[0] ^= i;

            } else {
                ans[1] ^= i;

            }
        }

        return ans;
    }


}
