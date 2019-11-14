public class ScoreAfterFlippingMatrix_861 {
    public static void main(String[] args) {
        int[][] A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        matrixScore(A);
    }
    public static int matrixScore(int[][] A) {
        int sum=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i][0]==0){
                for (int j = 0; j <A[i].length ; j++) {
                    A[i][j]=A[i][j]==0?1:0;
                }
            }
        }
        for (int i = 0; i < A[0].length; i++) {
            int count=0;
            for (int j = 0; j < A.length; j++) {
                if(A[j][i]==0){
                    count++;
                }
            }
            if(count>A.length-count){
                for (int j = 0; j <A.length ; j++) {
                    A[j][i]=A[j][i]==0?1:0;
                }
                sum+=Math.pow(2,A[0].length-1-i)*count;
            }else {
                sum+=Math.pow(2,A[0].length-1-i)*(A.length-count);
            }

        }
        return sum;
    }
}
