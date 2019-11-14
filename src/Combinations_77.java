import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
        List<Integer> newList=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newList.add(i);
        }
        newList.remove(1);
        newList.remove((Integer)(1));
        combine(4,2);
        int a=0;

    }
    public static List<List<Integer>> combine(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i){
            nums.add(i);
        }

        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)){
                nums.set(j, j++ + 1);
            }

            nums.set(j, nums.get(j) + 1);
        }
        return output;

    }
    public static List<List<Integer>> creat(List<Integer> A,int n){
        List<List<Integer>> result=new ArrayList<>();
        if(n==1){
            for (int i = 0; i < A.size(); i++) {
                List<Integer> newList=new ArrayList<>();
                newList.add(A.get(i));
                result.add(newList);
            }
        }
        for (Integer  e:new ArrayList<>(A)){
            A.remove(e);
            List<List<Integer>> temp= new ArrayList<>(creat(new ArrayList<>(A),n-1));
            for (List<Integer> list:temp){
                list.add(e);
                result.add(new ArrayList<>(list));
            }
        }

        return result;

    }
}
