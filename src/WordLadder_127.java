import java.util.*;

public class WordLadder_127 {
    public static void main(String[] args) {
        int n = 1234;
        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot","dot","dog"};
        WordLadder_127 wordLadder_127=new WordLadder_127();

        System.out.println(wordLadder_127.ladderLength(beginWord,endWord, Arrays.asList(wordList)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        if(isSimilar(beginWord,endWord)){
            return 2;
        }
        LinkedList<String> newLevelList=new LinkedList<>();
        newLevelList.add(beginWord);
       LinkedList<String> newWordList=new LinkedList<>(wordList);
       if(newWordList.contains(beginWord)){
           newWordList.remove(beginWord);
       }
        return bfs(1,  newWordList,newLevelList,endWord);
    }

    /**
     *广度优先搜索
     *
     * @param level 深度
     * @param wordList 剩余未查找单词
     * @param thisLevelList 当前层次单词
     * @param endWord 目标单词
     */
    public int bfs(int level, LinkedList<String> wordList,LinkedList<String> thisLevelList,String endWord){
        if(wordList.size()==0){
            return 0;
        }
        level++;
        LinkedList<String> newLevelList=new LinkedList<>();
        Iterator<String> stringIterator=thisLevelList.iterator();
        while (stringIterator.hasNext()){
            String tmp=stringIterator.next();
            Iterator<String> wordIterator=wordList.iterator();
            while (wordIterator.hasNext()){
                String word=wordIterator.next();
                if(isSimilar(tmp,word)){
                    if(word.equals(endWord)){
                        return level;
                    }else {
                       wordIterator.remove();
                        newLevelList.add(word);
                    }
                }

            }
        }
        if(newLevelList.size()==0){
            return 0;
        }
        return bfs(level,wordList,newLevelList,endWord);
    }
    /**
     * 判断两个单词是否相似（仅差一个字母）
     *
     * @return true 相似
     * @return false 不相似
     */
    public boolean isSimilar(String word0,String word1){
        int num=0;
        for (int i = 0; i < word0.length(); i++) {
            if(word0.charAt(i)!=word1.charAt(i)){
                num++;
            }
            if(num==2){
                return false;
            }
        }
        return true;
    }
}
