class Solution {
    class Disjoint{
        int[] parent,rank;
        int size;
        public Disjoint(int n){
            this.size =n;
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int findParent(int x){
            if(parent[x]==x) return x;
            parent[x]= findParent(parent[x]);
            return parent[x];
        }
        public void union(int x,int y){
            int px = findParent(x);
            int py = findParent(y);
            if(px==py) return;
            if(rank[px]<rank[py]) parent[px]=py;
            else if(rank[py]<rank[px]) parent[py]=px;
            else{
                parent[px]=py;
                rank[px]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint DS = new Disjoint(n);
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    DS.union(i,map.get(mail));
                }
                else{
                    map.put(mail,i);
                }
            }
        }
        ArrayList<String>[] merged = new ArrayList[n];
        for(int i=0;i<n;i++){
            merged[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> en:map.entrySet()){
            int node = DS.findParent(en.getValue());
            merged[node].add(en.getKey());
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged[i].isEmpty()) continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged[i]);
            res.add(temp);
        }
        return res;

        
    }
}