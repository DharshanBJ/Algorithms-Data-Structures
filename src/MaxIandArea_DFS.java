import java.util.Stack;

public class MaxIandArea_DFS {
    public static int maxAreaOfIsland(int[][] grid) {
        Stack<int[]> stack=new Stack<>();
        boolean[][] seen=new boolean[grid.length][grid[0].length];
        int result=0;
        int[] sr=new int[]{0,0,1,-1};//horizontal and vertical neighbouring cells(Hamming neighbours)
        int[] sc=new int[]{1,-1,0,0};

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int area=0;
                if(grid[i][j]==1 && !seen[i][j]){
                    stack.push(new int[]{i,j});
                    while(!stack.isEmpty()){
                        int[] node=stack.pop();
                        area++;
                        int r=node[0];
                        int c=node[1];
                        seen[r][c]=true;
                        for(int k=0;k<4;k++){
                            int nr=r+sr[k];
                            int nc=c+sc[k];
                            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !seen[nr][nc] && grid[nr][nc]==1){
                                stack.push(new int[]{nr,nc});
                                seen[nr][nc]=true;
                            }
                        }

                    }

                }
                result=Math.max(area,result);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] input=new int[4][5];
        input[0]=new int[]{1,1,0,0,0};
        input[1]=new int[]{1,1,0,0,0};
        input[2]=new int[]{0,0,0,1,1};
        input[3]=new int[]{1,1,1,1,1};
        int maxArea=maxAreaOfIsland(input);
        System.out.println("Maximum area of island is "+maxArea);
    }
}
