public class JumpGame_55 {
    public static void main(String[] args) {
        JumpGame_55 jumpGame_55=new JumpGame_55();
        int[] nums={2,0,1,0};
        System.out.println(jumpGame_55.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length-1; i++) {

            if (max < i + nums[i]) {
                max = i + nums[i];
            }
            if(nums[i]==0&&max<=i){
                return false;
            }

        }
        return true;
    }
}
