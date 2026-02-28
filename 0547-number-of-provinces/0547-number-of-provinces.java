class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int res =0;
         for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                res++;
            }
        }
        return res;
       
    }
    public void dfs(int edge,boolean[] vis,int[][] isConnected){
        vis[edge] = true;
         for(int i=0;i<isConnected.length;i++){
            if(isConnected[edge][i]==1 && !vis[i]) dfs(i,vis,isConnected);
         }
    }
}