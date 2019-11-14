import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralMatrix_54 spiralMatrix_54=new SpiralMatrix_54();
        System.out.println(spiralMatrix_54.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 0;
        int i = 0;
        int j = 0;
        int[][] state=new int[matrix.length][matrix[0].length];
        List<Integer> result = new LinkedList<>();
        int sum = matrix[0].length * matrix.length;
        while (result.size() < sum) {
            result.add(matrix[i][j]);
           state[i][j]=1;
            int newI = i;
            int newJ = j;
            switch (direction) {
                case 0:
                    newJ++;
                    break;
                case 1:
                    newI++;
                    break;
                case 2:
                    newJ--;
                    break;
                case 3:
                    newI--;
                    break;
            }

            if ( newI < 0 || newJ < 0 || newI > matrix.length-1 || newJ > matrix[0].length-1||state[newI][newJ]==1) {
                direction = (direction + 1) % 4;
            }
            switch (direction) {
                case 0:
                    j++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
        return result;
    }
}
