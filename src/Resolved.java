import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.copyOfRange;

public class Resolved {
    /**
     * 构建一个长度位n的字符串,只包含a，b，c三个字符
     * c最多出现一次
     * B最多出现两次
     * */
    public int  mainFun(int n){
        List<String> strings=new ArrayList<String>();
        fun("",'a',n,strings);
        fun("",'b',n,strings);
        fun("",'c',n,strings);
        return strings.size();
    }



    public static void fun(String s,char c,int n,List<String> strings){
        s=s+c;
        if(s.length()==n){
            if(s.replace("c","").length()>s.length()-2){
                if(!s.contains("bbb")){
                    strings.add(s);
                }
            }
        }else {
            if(s.replace("c","").length()>s.length()-2){
                if(!s.contains("bbb")){
                    fun(s,'a',n,strings);
                    fun(s,'b',n,strings);
                    fun(s,'c',n,strings);
                }
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 两数相加
     */

    public static final int TEN = 10;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        result = temp;
        ListNode temp1 = temp;
        while (l1 != null && l2 != null) {
            int countNum = l1.val + l2.val + temp.val;
            if (countNum >= TEN) {
                temp.val = countNum % TEN;
                temp.next = new ListNode(countNum / TEN);
            } else {
                temp.val = countNum % TEN;
                temp.next = new ListNode(0);
            }
            temp1 = temp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (temp.val == 0) {
                temp1.next = null;
            }
            return result;
        } else {
            ListNode l = null;
            if (l1 == null) {
                l = l2;
            } else {
                l = l1;
            }
            l.val = l.val + temp.val;
            temp1.next = l;
            while (l.next != null) {
                if (l.val >= TEN) {
                    int num = l.val;
                    l.val = num % TEN;
                    l.next.val += num / TEN;
                }
                l = l.next;

            }
            if (l.val >= TEN) {
                int num = l.val;
                l.val = num % TEN;
                l.next = new ListNode(num / TEN);
            }
            return result;
        }

    }

    /**
     *(abc(ui))变成uicba
     */

    public static String resolve(String expr) {
        int start = 0;
        int end = 0;
        while (expr.contains("(") && expr.contains(")")) {
            start = expr.lastIndexOf("(");
            String temp = expr.substring(start + 1, expr.length());
            end = temp.indexOf(")") + start + 1;
            temp = expr.substring(start + 1, end);
            StringBuffer sb = new StringBuffer(expr);
            sb.replace(start, end + 1, reverse(temp));
            expr = sb.toString();
        }
        if (expr.contains(")") && !expr.contains("(")) {
            return "";
        }
        if (!expr.contains(")") && expr.contains("(")) {
            return "";
        }
        return expr;
    }

    public static String reverse(String str) {
        //方法一 将字符串转换为字符数组
        char[] arr = str.toCharArray();
        // 逆序输出字符数组
        for (int i = 0; i < arr.length / 2; i++) {
            char temp;
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return new String(arr);
    }
    public static int reverse(int x) {
        int newNum = 0;
        int MAX = 2147483647;
        int min = -2147483648;
        while (x != 0) {

            newNum = newNum * 10;
            int pop = x % 10;
            newNum += pop;
            x = x / 10;
            if (((newNum > MAX / 10) && x > 0) || ((newNum < min / 10) && x < 0)) {
                return 0;
            }
            if (((newNum == MAX / 10) && x > 0 && pop > 7) || ((newNum == min / 10) && x < 0 && pop < -7)) {
                return 0;
            }

        }
        return newNum;
    }




    public static int length = 0;
    ArrayList<String> arrayList = new ArrayList<>();

    public static void addString(String s, String c) {
        int start = s.indexOf(c);
        int end = s.indexOf(c);
        if (start == end) {
            if (length < s.length()) {
                length = s.length();
            }
        } else {
            addString(s.substring(0, start), c);
            addString(s.substring(start, end), c);
            addString(s.substring(end, s.length() - 1), c);
        }


    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        int uNum = command.length() - command.replace("U", "").length();
        int rNum = command.length() - command.replace("R", "").length();
        int obstaclesSize = obstacles.length;
        for (int i = 0; i < obstaclesSize; i++) {
            int xLocaltion = obstacles[i][0];
            int yLocaltion = obstacles[i][1];
            if(!(xLocaltion>x||yLocaltion>y)){
                if (judge(command, xLocaltion, yLocaltion,  rNum,uNum)) {
                    return false;
                }
            }

        }
        if (!judge(command, x, y, rNum, uNum)) {
            return false;
        }
        return true;
    }

    public static boolean judge(String command, int xLocaltion, int yLocaltion,int rNum, int uNum ) {
        int min = Math.min(xLocaltion /rNum , yLocaltion /uNum );
        xLocaltion -= min * rNum;
        yLocaltion -= min * uNum;
        if (xLocaltion == 0 && yLocaltion == 0) {
            return true;
        }
        int allStep = xLocaltion + yLocaltion;
        if (allStep > command.length()) {
            return false;
        }
        String lastCommand = command.substring(0, allStep);
        int uLastNum = lastCommand.length() - lastCommand.replace("U", "").length();
        int rLastNum = lastCommand.length() - lastCommand.replace("R", "").length();
        if (rLastNum == xLocaltion && uLastNum == yLocaltion) {
            return true;
        }
        return false;


    }


    public static test.TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        int max = 0;
        int location = -1;
        for (int i = 0; i < length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                location = i;
            }
        }
        test.TreeNode node = new test.TreeNode(max);
        if (location != -1) {
            if (location != 0) {
                node.left = constructMaximumBinaryTree(copyOfRange(nums, 0, location));
            }
            if (location != length - 1) {
                node.right = constructMaximumBinaryTree(copyOfRange(nums, location + 1, length));
            }
        }

        return node;
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int size = grid.length;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int xmax = -1;
            int ymax = -1;
            for (int j = 0; j < size; j++) {
                if (grid[i][j] > ymax) {
                    ymax = grid[i][j];
                    arr1[i] = ymax;
                }
                if (grid[j][i] > xmax) {
                    xmax = grid[j][i];
                    arr2[i] = xmax;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += arr1[i] - grid[i][j];
                grid[i][j] = arr1[i];
                if (grid[i][j] > arr2[j]) {
                    sum += arr2[j] - grid[i][j];
                    grid[i][j] = arr2[j];
                }

            }
        }

        return sum;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        re.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = re.size();
            for (int j = 0; j < all; j++) {
                List<Integer> arr = re.get(j);
                arr.add(nums[i]);
                re.add(arr);
            }
        }
        return re;
    }

    public static test.TreeNode mergeTrees(test.TreeNode t1, test.TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            t1 = t2;
        } else {
            if (t2 != null) {
                t1.val += t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
            }
        }
        return t1;
    }
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int num = n * n;
        int count = 0;
        int i = 0;
        int j = 0;
        int direction = 0;
        while (count < num) {
            if (j >= 0 && j < n && i >= 0 && i < n && arr[j][i] == 0) {
                count++;
                arr[j][i] = count;
            } else {
                switch (direction) {
                    case 0:
                        i--;
                        break;
                    case 1:
                        j--;
                        break;
                    case 2:
                        i++;
                        break;
                    case 3:
                        j++;
                        break;
                }
                direction = (direction + 1) % 4;
            }
            switch (direction) {
                case 0:
                    i++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    i--;
                    break;
                case 3:
                    j--;
                    break;
            }
        }
        return arr;
    }
    public int[] countBits(int num) {

        int[] arr=new int[num];
        if(num==0){return arr;}
        arr[1]=1;
        if(num==1){return arr;}
        for(int i=2;i<num;i++){
            if(i%2==0){
                arr[i]=arr[i/2];
            }else{
                arr[i]=arr[i/2]+1;
            }
        }
        return arr;
    }
}
