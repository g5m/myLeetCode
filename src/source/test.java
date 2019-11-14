package source;

public class test {
    public static void main(String[] args) {
       String a="qwertyui";
       StringBuffer b=new StringBuffer("qwertyui");
       StringBuilder c=new StringBuilder("qqwqwq");
        b.append("1111");
        System.out.println(b);
        c.replace(0,3,"");
        System.out.println(c);
        System.out.println();
    }
}
