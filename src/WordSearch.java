public class WordSearch {

    static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {

        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;

    }

    public static void main(String[] args) {
        char[][] input = new char[3][4];
        input[0] = new char[]{'A', 'B', 'C', 'E'};
        input[1] = new char[]{'S', 'F', 'C', 'S'};
        input[2] = new char[]{'A', 'D', 'E', 'E'};
        boolean answer = exist(input, "ABC");
        System.out.println(answer);

    }
}
