public class MinimumAddtoMakeParenthesesValid_921 {
    public static void main(String[] args) {

    }
    public static int minAddToMakeValid(String S) {

        while (S.contains("()")) {
            S = S.replace("()", "");
        }
        return S.length();
    }
}
