import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateFileInSystem_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> lists=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap();
        for (String s: paths){
            String[] arr=s.split(" ");
            String root=arr[0]+"/";
            for (int i = 1; i < arr.length; i++) {
                String[] f=arr[i].split("\\(");
                String content=f[1].replace(")","");
                if(map.containsKey(content)){
                    map.get(content).add(root+f[0]);
                }else {
                    List<String> list=new ArrayList<>();
                    list.add(root+f[0]);
                    map.put(content,list);
                }
            }
        }
        for(List<String> list:map.values()){
            if(list.size()>1){
                lists.add(list);
            }

        }
        return lists;
    }
}
