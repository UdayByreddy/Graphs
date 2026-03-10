class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,src,0});
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int stop = temp[0];
            int node = temp[1];
            int val = temp[2];
            if(stop>k) continue;
            for(int[] dir: adj.get(node)){
                int weight = dir[1];
                int d = dir[0];
                if(val+weight<dis[d] && stop<=k){
                    queue.offer(new int[]{stop+1,d,val+weight});
                    dis[d]=val+weight;
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE) return -1;
        return dis[dst];
        
    }
}