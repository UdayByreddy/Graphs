class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
                else {
                   mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int [][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int i = temp[0];
            int j= temp[1];
            for(int[] d: dir){
                int nx = i+d[0];
                int ny = j+d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && mat[nx][ny]>mat[i][j]+1){
                    mat[nx][ny] = mat[i][j]+1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return mat;
        
    }
}