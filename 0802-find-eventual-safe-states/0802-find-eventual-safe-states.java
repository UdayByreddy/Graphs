class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean[] vis = new boolean[m];
        boolean[] safeNodes = new boolean[m];
        for(int i=0;i<m;i++){
            if(!vis[i]){
                dfs(i,vis,safeNodes,graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            if(!safeNodes[i]) ans.add(i);
        }
        return ans;
        
    }
    public boolean dfs(int edge,boolean[] vis,boolean[] safeNodes,int[][] graph){
        vis[edge] = true;
        safeNodes[edge]=true;
        for(int start: graph[edge]){
            if(!vis[start] && dfs(start,vis,safeNodes,graph)) return true;
            if(safeNodes[start]==true) return true;
        }
        safeNodes[edge]=false;
        return false;

    } 
}