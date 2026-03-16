class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = stones.length;
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
                else if(stones[i][1]==stones[j][1]){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(vis,i,map);
                count++;
            }
        }
        return n-count;
    }
    public void dfs(boolean[] vis,int edge,Map<Integer,ArrayList<Integer>> map){
        vis[edge]=true;
        for(int e:map.get(edge)){
        if(!vis[e])
            dfs(vis,e,map);
        }
    }
}