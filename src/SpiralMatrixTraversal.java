import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result=new ArrayList<>();
        if(matrix.length==0 )return result;

        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int columnBegin=0;
        int columnEnd=matrix[0].length-1;

        while(rowBegin<=rowEnd && columnBegin <=columnEnd){
            for(int i=columnBegin;i<=columnEnd;i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int j=rowBegin;j<=rowEnd;j++){
                result.add(matrix[j][columnEnd]);
            }
            columnEnd--;

            //if(rowBegin>rowEnd || columnBegin > columnEnd)break;
            if(rowBegin<=rowEnd){
                for(int j=columnEnd;j>=columnBegin;j--){
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            if(columnBegin<=columnEnd){
                for(int k=rowEnd;k>=rowBegin;k--){
                    result.add(matrix[k][columnBegin]);
                }
                columnBegin++;
            }

        }
        return result;
    }

    public static void main(String[]args){
        int[][]input=new int[3][4];
        input[0]=new int[]{1,2,3,4};
        input[1]=new int[]{5,6,7,8};
        input[2]=new int[]{9,10,11,12};

        List<Integer> result;

        result=spiralOrder(input);
        System.out.println(result);
    }
}
