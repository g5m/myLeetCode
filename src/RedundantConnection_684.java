import java.util.*;

public class RedundantConnection_684 {
    public static void main(String[] args) {

        //int[][] edges = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        int[][] edges ={{1,2},{1,3},{2,3}};
        findRedundantConnection(edges);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];

        LinkedList<HashSet> sets=new LinkedList<>();


        for (int i = 0; i < edges.length; i++) {

            int first=-1;
            int second=-1;
            for (int j = 0; j < sets.size(); j++) {
                HashSet set=sets.get(j);
                if(set.contains(edges[i][0])){
                    first=j;
                }
                if(set.contains(edges[i][1])){
                    second=j;
                }

            }
            if(first==-1&&second!=-1){
                HashSet set=sets.get(second);
                set.add(edges[i][0]);
            }else if(first!=-1&&second==-1){
                HashSet set=sets.get(first);
                set.add(edges[i][1]);
            }else if(first==-1&&second==-1){
                HashSet set=new HashSet();
                set.add(edges[i][0]);
                set.add(edges[i][1]);
                sets.add(set);
            }else if(first==second){
                result=edges[i];
            }else {
                HashSet setSecond=sets.get(second);
                HashSet setFirst=sets.get(first);
                setFirst.addAll(setSecond);
                sets.remove(second);
            }
        }
        return result;
    }

    public static boolean find(int start, int previous, int current, HashMap<Integer, List<Integer>> map) {
        List<Integer> list = map.get(current);
        if (list==null||list.size() == 0) {
            return false;
        }
        if (list.contains(start)) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != previous) {
                if (find(start, current, list.get(i), map)) {
                    return true;
                }
            }
        }
        return false;
    }
}
