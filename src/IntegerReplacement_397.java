import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerReplacement_397 {
    public static void main(String[] args) {
        int n = 1234;
        String beginWord = "qa";
        String endWord = "sq";
        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));

    }

    public static int integerReplacement(int n) {
        int Step = Integer.toBinaryString(n).length();
        return Step;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if(wordList.contains(beginWord)){
            wordList=new ArrayList<>(wordList);
            wordList.remove(beginWord);
        }
        int min = 9999;
        for (int i = 0; i < wordList.size(); i++) {
            int count = 0;
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWord.charAt(j) != wordList.get(i).charAt(j)) {
                    count++;
                }
                if (count == 2) {
                    break;
                }
            }
            if (count == 2) {
                continue;
            }else if(count==1){
                List<String> list = new ArrayList<>(wordList);
                list.remove(i);
                int tmp = ladderLength(wordList.get(i), endWord, list);
                if (tmp < min && tmp != 0) {
                    min = tmp;
                }
            }

        }

       if(min!=9999){
           min++;
           return min;
       }else {
           return 0;
       }
    }


}
