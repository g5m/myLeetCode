import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;

import java.util.List;


public class SearchA2DMatrixII_240 {
    public static void main(String[] args) {
        int[][] matrix = {
                {}

        };
        System.out.println(searchMatrix(matrix, 15));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        System.out.println(matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        if(matrix.length>0&&matrix[0].length>0){
            return false;
        }
        return searchMatrix1(matrix, 0,matrix.length-1,0,matrix[0].length-1,target);
    }

    public static boolean searchMatrix1(int[][] matrix,int rowStart,int rowEnd,int colStart,int colEnd, int target) {
        if(rowStart>rowEnd||colStart>colEnd){
            return false;
        }
        int row=rowStart;
        int col=colStart;
        for (int i = 0; i < Math.min(rowEnd-rowStart+1,colEnd-colStart+1); i++) {
            if(matrix[rowStart+i][colStart+i]==target){
                return true;
            }else if(matrix[rowStart+i][colStart+i]<target){
                row=rowStart+i;
                col=colStart+i;
            }else {
                break;
            }
        }

        return searchMatrix1(matrix,row+1,rowEnd,colStart,col,target)||searchMatrix1(matrix,rowStart,row,col+1,colEnd,target);
    }



}
