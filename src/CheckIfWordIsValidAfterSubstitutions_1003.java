import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions_1003 {
    public boolean isValid0(String S) {
        if(S.length()==0){
            return true;
        }
        String base="abc";
        while (S.contains(base)){
            S=S.replace(base,"");
        }
        return S.length()==0;
    }
    public boolean isValid(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='c'){
                if(stack.isEmpty()||stack.pop()!='b'){
                    return false;
                }
                if(stack.isEmpty()||stack.pop()!='a'){
                    return false;
                }
            }else {
                stack.push(S.charAt(i));
            }
        }
        return stack.empty();
    }
}
