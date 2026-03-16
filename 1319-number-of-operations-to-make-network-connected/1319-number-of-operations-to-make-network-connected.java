class Solution {
    public int Find(int[] parent,int val){
        if(parent[val]==val) return val;
        parent[val]=Find(parent,parent[val]);
        return parent[val];
    }
    public void union(int[] parent,int x,int y,int[] rank){
        int px = Find(parent,x);
        int py = Find(parent,y);
        if(px==py) return;
        if(rank[px]<rank[py]) parent[px]=py;
        else if(rank[py]<rank[px])parent[py]=px;
        else{
            parent[px]=py;
            rank[px]++;
        }

    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] connection:connections){
            union(parent,connection[0],connection[1],rank);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(Find(parent,i));
        }
        return set.size()-1;
        
    }
}