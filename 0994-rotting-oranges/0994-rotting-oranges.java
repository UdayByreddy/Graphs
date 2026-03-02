class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) freshCount++;
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(freshCount==0) return 0;
        if(queue.size()==0) return -1;
        int min=-1;
        int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
            int[] temp = queue.poll();
            for(int[] d: dir){
                int nx = temp[0]+d[0];
                int ny = temp[1]+d[1];
                if(nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]!=1) continue;
                else if(grid[nx][ny]==1){
                    queue.offer(new int[]{nx,ny});
                    grid[nx][ny]=2;
                    freshCount--;
                }
            }
            }
            min++;
        }
        if(freshCount>0) return -1;
        return min;
    }
}