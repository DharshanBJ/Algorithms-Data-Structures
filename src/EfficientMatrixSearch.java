public class EfficientMatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)return false;
        int lastColumn=matrix[0].length-1;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[] requiredRow=new int[columns];
        int possibleRow=-1;

        for(int i=0;i<rows;i++){
            if(matrix[i][lastColumn]==target){
                return true;
            }else if(matrix[i][lastColumn]>target){
                possibleRow=i;
                break;
            }
        }
        if(possibleRow==-1)return false;

        for(int j=0;j<columns;j++){
            requiredRow[j]=matrix[possibleRow][j];
        }
        int len=requiredRow.length;
        boolean result=binarySearch(requiredRow,0,len-1,target);
        return result;
    }

    public static boolean binarySearch(int[] requiredRow,int first,int last,int target){
        int mid=(first+last)/2;
      if(first<=last) {
          if (target == requiredRow[mid]) {
              return true;
          } else if (target < requiredRow[mid]) {
              return binarySearch(requiredRow, first, mid - 1, target);
          } else {
              return binarySearch(requiredRow, mid + 1, last, target);
          }
      }else{
          return false;
      }

    }

    public static void main(String[] args){
        int[][] input=new int[3][4];
        input[0]=new int[]{1,3,5,7};
        input[1]=new int[]{10,11,16,20};
        input[2]=new int[]{23,30,34,50};

        boolean result=searchMatrix(input,3);
        System.out.println(result);
    }
}
