public class ReverseWordsInaString_151 {
    public static void main(String[] args) {
        String s="a good   example";
        reverseWords(s);
    }
    public static String reverseWords(String s) {
        String[] arr=s.split(" ");
        s="";
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i].length()>0){
                s+=arr[i]+" ";

            }
        }
        return s.trim();
    }
}
