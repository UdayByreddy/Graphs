class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0,0,0});
        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int dis = temp[0];
            int row = temp[1];
            int col = temp[2];
            if(row==n-1 && col==m-1) return dis;
            for(int[] d: dir){
                int newRow = d[0]+row;
                int newCol = d[1]+col;
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                    int newDis = Math.max(Math.abs(heights[row][col]-heights[newRow][newCol]),dis);
                    if(newDis<dist[newRow][newCol]){
                        pq.offer(new int[]{newDis,newRow,newCol});
                        dist[newRow][newCol] = newDis;
                    }
                }
            }
        }
     return 0;   
    }
}