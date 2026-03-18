class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        minHeap.add(new int[]{grid[0][0],0,0});
        vis[0][0]=true;
        int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        while(!minHeap.isEmpty()){
            int[] temp = minHeap.poll();
            int eval = temp[0];
            int r = temp[1];
            int c = temp[2];
            if(r==n-1 && c==m-1) return eval;
            for(int[] d:dir){
                int nx = r+d[0];
                int ny = c+d[1];
                if(nx>=0 && nx<n &&ny>=0 &&ny<m&&!vis[nx][ny]){
                    minHeap.add(new int[]{Math.max(eval,grid[nx][ny]),nx,ny});
                    vis[nx][ny]=true;
                }
            }
        }
        return -1;
    }
}