import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result=new ArrayList<>();
        while (S.length()>0){
            int i=0;
            int max=0;
            while (i<=max){
              int localtion=  S.lastIndexOf(S.charAt(i));
              if(max<localtion){
                  max=localtion;
              }
              i++;
            }
            result.add(i);
            S=S.substring(i,S.length());
        }
        return result;
    }
}
