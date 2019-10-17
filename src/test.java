import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import sun.security.util.Length;

import javax.swing.text.AbstractDocument;
import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.util.*;

public class test {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'F', 'G', 'H'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            }
        }
        return doWork(list, n);
    }

    public static int doWork(List<Integer> list, int n) {
        Integer[] arr = new Integer[1];
        arr = list.toArray(arr);
        Arrays.sort(arr, Collections.reverseOrder());
        list = Arrays.asList(arr);
        int size = list.size();
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = n + 1; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        for (int i = 0; i < n + 1; i++) {
            if (i < list.size()) {
                if (list.get(i) - 1 > 0) {
                    newList.add(list.get(i) - 1);
                }
            }

        }
        int time = 0;
        int allTime = 0;
        if (newList.size() != 0) {
            allTime = n + 1;
            allTime += doWork(newList, n);

        } else {
            allTime = size;
        }
        return allTime;

    }

    public void fun() {
        int[] rollMax = {1, 1, 2, 2, 2, 3};
        int n = 2;
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("x1");
        list.add("x2");
        equations.add(list);
        list = new ArrayList<>();
        list.add("x2");
        list.add("x3");
        equations.add(list);
        list = new ArrayList<>();
        list.add("x3");
        list.add("x4");

        equations.add(list);
        list = new ArrayList<>();
        list.add("x4");
        list.add("x5");
        equations.add(list);


        list = new ArrayList<>();
        list.add("x1");
        list.add("x5");
        queries.add(list);
        list = new ArrayList<>();
        list.add("x5");
        list.add("x2");
        queries.add(list);
        list = new ArrayList<>();
        list.add("x2");
        list.add("x4");
        queries.add(list);
        list = new ArrayList<>();
        list.add("x2");
        list.add("x2");
        queries.add(list);
        list = new ArrayList<>();
        list.add("x2");
        list.add("x9");
        queries.add(list);
        list = new ArrayList<>();
        list.add("x9");
        list.add("x9");
        queries.add(list);
        double[] values = {3.0, 4.0, 5.0, 6.0};
        calcEquation(equations, values, queries);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //图的链式表示法
        Map<String, List<String>> pairs = new HashMap<>();
        //图上每条边的权重
        Map<String, List<Double>> valuedPairs = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            //获取第i个方程式
            List<String> equation = equations.get(i);
            String multiplied = equation.get(0);//被除数
            String multiplier = equation.get(1);//除数
            //如果被除数从来没有添加到图中，则将其作为顶点在图中初始化
            if (!pairs.containsKey(multiplied)) {
                pairs.put(multiplied, new ArrayList<>());
                valuedPairs.put(multiplied, new ArrayList<>());
            }
            //如果除数从来没有添加到图中，则将其作为顶点在图中初始化
            if (!pairs.containsKey(multiplier)) {
                pairs.put(multiplier, new ArrayList<>());
                valuedPairs.put(multiplier, new ArrayList<>());
            }
            //添加边和边的权重
            pairs.get(multiplied).add(multiplier);
            pairs.get(multiplier).add(multiplied);
            valuedPairs.get(multiplied).add(values[i]);
            valuedPairs.get(multiplier).add(1.0 / values[i]);
        }

        //结果集
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            //在图中，以被除数作为顶点，深度优先遍历图，直到找到值为除数的顶点
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), pairs, valuedPairs, new HashSet<>(), 1.0);
            result[i] = result[i] == 0.0 ? -1.0 : result[i];
        }
        return result;
    }

    public static double dfs(String multiplied, String multiplier, Map<String, List<String>> pairs, Map<String, List<Double>> valuedPairs, Set<String> visited, double curResult) {
        //如果图中不包含该被除数顶点，则无法获知该表达式的值
        if (!pairs.containsKey(multiplied)) {
            return 0.0;
        }
        //如果再次访问过该被除数，说明找到了一条环路，则该深度优先遍历结果失败，直接抛弃
        if (visited.contains(multiplied)) {
            return 0.0;
        }
        //如果被除数等于除数，则返回1.0
        if (multiplied.equals(multiplier)) {
            return curResult;
        }
        visited.add(multiplied);
        //获得当前被除数的所有邻接顶点
        List<String> multipliers = pairs.get(multiplied);
        //获得所有邻接边的权重
        List<Double> multiplierValues = valuedPairs.get(multiplied);
        double tmp = 0.0;
        for (int i = 0; i < multipliers.size(); i++) {
            //以邻接点为新的顶点，继续深度优先遍历
            //此时调用方法中curResult的值代表的是该原邻接点除以邻接点的值
            //如 a/b=2, b/c=3, 则a=2b，因此当我们以b作为邻接点寻找c时，需要记录原被除数是现被除数的两倍
            tmp = dfs(multipliers.get(i), multiplier, pairs, valuedPairs, visited, curResult * multiplierValues.get(i));
            //找到非零路径，结束深度优先遍历
            if (tmp != 0.0) {
                break;
            }
        }
        visited.remove(multiplied);
        return tmp;
    }


}


