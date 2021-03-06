public class LintCode_630 {
    /**
     * @param grid a chessboard included 0 and 1
     * @return the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // Write your code here
        if(grid == null){
            return -1;
        }
        if(grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] f = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        
        f[0][0] = 0;
        for(int j = 1; j < m; j++){
            for(int i = 0; i < n; i++){
                if(grid[i][j]){
                    continue;
                }
                
                if(i >= 1 && j >= 2 && f[i - 1][j - 2] != Integer.MAX_VALUE){
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 2] + 1);
                }
                if(i >= 2 && j >= 1 && f[i - 2][j - 1] != Integer.MAX_VALUE){
                    f[i][j] = Math.min(f[i][j], f[i - 2][j - 1] + 1);
                }
                if(i + 1 < n && j >= 2 && f[i + 1][j - 2] != Integer.MAX_VALUE){
                    f[i][j] = Math.min(f[i][j], f[i + 1][j - 2] + 1);
                }
                if(i + 2 < n && j >= 1 && f[i + 2][j - 1] != Integer.MAX_VALUE){
                    f[i][j] = Math.min(f[i][j], f[i + 2][j - 1] + 1);
                }
            }
        }
        
        if(f[n - 1][m - 1] == Integer.MAX_VALUE){
            return -1;
        }
        return f[n - 1][m - 1];
    }
}