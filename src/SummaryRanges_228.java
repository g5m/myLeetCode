import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public static void main(String[] args) {
        int[] arr={0,1,2,4,5,7};
        summaryRanges(arr);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        int start=nums[0];
        int end=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1]!=1){
                if(start==end){
                    result.add(String.valueOf(start));

                }else {
                    result.add(start+"->"+end);
                }
                start=nums[i];
            }
            end=nums[i];
        }
        if(start==end){
            result.add(String.valueOf(start));

        }else {
            result.add(start+"->"+end);
        }
        return result;
    }
}
