import java.util.*;

public class RevealCardsInIncreasingOrder_950 {
    public static void main(String[] args) {
        int[] deck={17,13,11,2,3,5,7};
        deckRevealedIncreasing(deck);
    }
    public  static int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue=new LinkedList<>();
        Arrays.sort(deck);
        for (int i = deck.length-1; i >=0 ; i--) {
            if(!queue.isEmpty()){
                Integer a=queue.poll();
                queue.offer(a);
            }
            queue.offer(deck[i]);
        }
        for (int i = 0; i < deck.length; i++) {
          deck[i]= (int) ((LinkedList) queue).get(deck.length-i-1);
        }
        return deck;
    }
}
