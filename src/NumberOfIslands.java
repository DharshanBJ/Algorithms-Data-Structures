import java.util.Stack;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {

        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        boolean[][] seen=new boolean[grid.length][grid[0].length];
        Stack<int[]>stack=new Stack<>();
        int[] sr=new int[]{0,0,1,-1};
        int[] sc=new int[]{1,-1,0,0};
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !seen[i][j]){
                    stack.push(new int[]{i,j});
                    seen[i][j]=true;
                    count++;
                    while(!stack.isEmpty()){
                        int[] node=new int[2];
                        node=stack.pop();

                        for(int k=0;k<4;k++){
                            int nr=node[0]+sr[k];
                            int nc=node[1]+sc[k];

                            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && !seen[nr][nc]){
                                stack.push(new int[]{nr,nc});
                                seen[nr][nc]=true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        char[][] input=new char[4][5];
        input[0]=new char[]{'1','1','1','1','0'};
        input[1]=new char[]{'1','1','0','1','0'};
        input[2]=new char[]{'1','1','0','0','0'};
        input[3]=new char[]{'0','0','1','0','1'};
        int num=numIslands(input);
        System.out.println("Number of islands is "+num);
    }

}
