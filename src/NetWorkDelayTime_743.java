import java.util.*;
import java.util.logging.Level;

public class NetWorkDelayTime_743 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, N, k));
    }

    /**
     * @param times [u,v,w] u源节点，v目标节点，w耗时
     * @param N     节点总数
     * @param K     初始节点
     */

    public static int networkDelayTime(int[][] times, int N, int K) {
        boolean[] u=new boolean[N];
         int[] dis=new int[N];
        for (int i = 0; i < N; i++) {
            u[i]=false;
            dis[i]=Integer.MAX_VALUE;
        }
        int node=K-1;
        dis[node]=0;

        int oldNode=K-1;
        for (int i = 0; i < N; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if(!u[j]&&dis[j]<min){
                    min=dis[j];
                    node=j;
                }
            }
            u[node]=true;
            for (int j = 0; j <times.length ; j++) {
                if(times[j][0]==node+1){
                    if(dis[times[j][1]-1]>dis[oldNode]+times[j][2]){
                        dis[times[j][1]-1]=dis[oldNode]+times[j][2];
                    }
                }
            }
            min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!u[j]) {
                    if (dis[j] < min) {
                        min = dis[j];
                        oldNode = j;
                    }
                }
            }
        }


        Arrays.sort(dis);
        if (dis[N - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dis[N - 1];
        }
    }
    /**
     * @param map 图
     * @param k   起始节点
     * @param N   节点总数
     */
    public static int[] dijkstra(HashMap<Integer, HashMap<Integer, Integer>> map, int k, int N) {
        int[] dis = new int[N];
        boolean[] u = new boolean[N];
        for (int i = 0; i < N; i++) {
            dis[i] = Integer.MAX_VALUE;
            u[i] = false;
        }
        dis[k - 1] = 0;
        int node = k - 1;
        for (int i = 0; i < N; i++) {
            int oldNode = node;
            if (!u[node]) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!u[j]) {
                        if (dis[j] < min) {
                            min = dis[j];
                            node = j;
                        }
                    }
                }
                u[node] = true;
                if (map.containsKey(node + 1)) {
                    HashMap<Integer, Integer> routes = map.get(node + 1);
                    Iterator<Map.Entry<Integer, Integer>> it = routes.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> entry = it.next();
                        if (dis[entry.getKey() - 1] > dis[oldNode] + entry.getValue()) {
                            dis[entry.getKey() - 1] = dis[oldNode] + entry.getValue();
                        }
                    }

                }
                min = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!u[j]) {
                        if (dis[j] < min) {
                            min = dis[j];
                            node = j;
                        }
                    }
                }
            }

        }
        return dis;
    }



    /**
     * @param map   图
     * @param k     当前所在节点
     * @param list  已走过节点
     * @param costs 耗费时间
     * @param step  层
     */

    public static void bfs(HashMap<Integer, HashMap<Integer, Integer>> map, int k, List<Integer> list, List<List<Integer>> costs, int step, int N) {

        if (!map.containsKey(k)) {
            return;
        }

        HashMap<Integer, Integer> nextNode = map.get(k);
        if (costs.size() < step + 1) {
            List<Integer> temp = new ArrayList<>();
            costs.add(temp);
        }
        HashMap<Integer, Integer> routes = map.get(k);
        List<Integer> addList = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> it = routes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (!list.contains(entry.getKey())) {
                list.add(entry.getKey());
                addList.add(entry.getKey());
                costs.get(step).add(entry.getValue());
                // bfs(map, entry.getKey(), list, N, costs, step + 1);
            }
        }
        if (list.size() == N) {
            return;
        }
        it = routes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (addList.contains(entry.getKey())) {
                bfs(map, entry.getKey(), list, costs, step + 1, N);
            }

        }
    }

    /**
     * 根据二维矩阵构建有向图
     *
     * @param arr 原始矩阵
     */


    public static HashMap<Integer, HashMap<Integer, Integer>> creatMap(int[][] arr) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            HashMap<Integer, Integer> route = new HashMap<>();
            if (map.containsKey(arr[i][0])) {
                route = map.get(arr[i][0]);
            }
            route.put(arr[i][1], arr[i][2]);
            map.put(arr[i][0], route);
        }
        return map;
    }



}
