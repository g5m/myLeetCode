import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.tree.TreeNode;
import java.text.BreakIterator;
import java.util.*;

public class Code {
   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args) {



    }
    public static String  intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {

            while (num >= nums[index]) {

                stringBuilder.append(romans[index] + " ");
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();

    }
    public static int consecutiveNumbersSum(int N) {
        int res=0;
        int max=N*2;
        int k=1;
        //设有k个数字满足，第一个数字之前的数为a,最小值为0，则k个数的和为 (a+k)*(a+k+1)/2-a*(a+1)/2=N
        //推导出：k*(k+1)+ak=2N,所以k*(k+1)必须<=2N,且N-k*(k+1)/2 必须能整除k
        int t=k*(k+1);
        while(t<=max){
            if((N-t/2)%k==0){
                res++;
            }
            k++;
            t=k*(k+1);
        }
        return res;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //发现目标节点则通过返回值标记该子树发现了某个目标节点
        if (root == null || root == p || root == q) {
            return root;
        }
        //查看左子树中是否有目标节点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //查看右子树中是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //都不为空，则说明左右子树都有目标节点，则公共祖先就是本身。
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }


    private static double all = 0;

    /**
     * @param n  红球数量
     * @param m  篮球数量
     * @param re 上一个人不赢的概率
     * @param i  第i个球
     */
    public static void fun(double n, double m, double re, int i) {

        if (n == 0) {
            return;
        }
        if (i % 3 == 1) {
            all += re * (n / (n + m));
            re = re * (m / (n + m));
        } else if (i % 3 == 2) {
            re = re * (m / (n + m));
        }
        if (i % 3 == 0) {
            fun(--n, m, re, ++i);
        }
        if (m != 0) {
            fun(n, --m, re, ++i);
        }


    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allRoute=new ArrayList<>();
        List<Integer> route=new ArrayList<>();
        findRoute(0,graph,route,allRoute);
        return allRoute;
    }

    public  static void findRoute(int location,int[][] graph,List<Integer> route,List<List<Integer>> allRoute){
        if(graph[location].length==0){
            route.add(location);
            allRoute.add(route);
        }
        for (int i=0;i<graph[location].length;i++){
            List<Integer> arr=new ArrayList<>();
            arr.addAll(route);
            arr.add(location);
            findRoute(graph[location][i],graph,arr,allRoute);
        }
    }
    public static test.TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> arr = new ArrayList<>();
        for (int item : preorder) {
            arr.add(item);        }

        return createTree(arr);
    }

    public static test.TreeNode createTree(List<Integer> list){
        test.TreeNode node=new test.TreeNode(list.get(0));
        list.remove(0);
        List<Integer> leftList=new ArrayList<>();
        List<Integer> rightList=new ArrayList<>();
        for(int item:list){
            if(item<node.val){
                leftList.add(item);
                continue;
            }
            if(item>node.val){
                rightList.add(item);
            }
        }
        if(leftList.size()>0){
            node.left=createTree(leftList);
        }
        if(rightList.size()>0){
            node.right=createTree(rightList);
        }
        return node;
    }
}
