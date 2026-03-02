class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        int oriColor = image[sr][sc];
        if(oriColor==color) return image;
        queue.offer(new int[]{sr,sc});
        int n = image.length;
        int m = image[0].length;
        int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            int size = queue.size();
                int[] temp = queue.poll();
                for(int[] d: dir){
                    int nx = temp[0]+d[0];
                    int ny = temp[1]+d[1];
                   if(nx>=0 && nx<n && ny>=0 && ny<m && image[nx][ny]==oriColor){
                    image[nx][ny]=color;
                    queue.offer(new int[]{nx,ny});
                   }
             }
        }
        return image;
        
    }
}