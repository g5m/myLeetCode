import java.util.Arrays;
import java.util.LinkedList;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int crr=i;
        int tmp;
        while (crr<j){
            if(nums[crr]==0){
                tmp=nums[crr];
                nums[crr]=nums[i];
                nums[i]=tmp;
                i++;
                crr++;
            }else
            if(nums[crr]==2){
                tmp=nums[crr];
                nums[crr]=nums[j];
                nums[j]=tmp;
                j--;
            }else {
                crr++;
            }

        }
    }
    public void sortColors1(int[] nums) {
      int[] count=new int[3];
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i<count[0]){
                nums[i]=0;
            }else if (i<count[0]+count[1]){
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
    }
}
