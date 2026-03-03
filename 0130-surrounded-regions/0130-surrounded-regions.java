class Solution {
    int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public void dfs(int[][] vis,int x,int y,char[][] board){
        vis[x][y]=1;
        for(int[] d: dir){
            int nx = x+d[0];
            int ny = y+d[1];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && vis[nx][ny]==0 && board[nx][ny]=='O'){
                dfs(vis,nx,ny,board);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(vis,0,j,board);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(vis,n-1,j,board);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(vis,i,0,board);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(vis,i,m-1,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}