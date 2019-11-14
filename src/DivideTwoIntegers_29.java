public class DivideTwoIntegers_29 {
    public static void main(String[] args) {
        System.out.println(        divide(-2147483648,-1)
        );
    }
    public static int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        boolean sysmbol=false;
        if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
            sysmbol=true;
        }
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int num=0;
        while (divisor<=dividend){
            dividend-=divisor;
            num++;
        }
        if(sysmbol){
            return num;
        }else {
            return -num;
        }
    }
}
