class Solution {
    int mod = (int) 1e9+7;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int src = road[0];
            int des = road[1];
            int time = road[2];
            adj.get(src).add(new int[]{des,time});
            adj.get(des).add(new int[]{src,time});
        }
        PriorityQueue<LONG[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
         long[] des = new long[n];
        int[] count = new int[n];
        Arrays.fill(des,Long.MAX_VALUE);
        des[0]=0;
        count[0]=1;
        pq.offer(new int[]{0,0});
       
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int d = (int) temp[0];
            long time = temp[1];
            for(int[] edge: adj.get(d)){
                int newDes = edge[0];
                int newTime = edge[1];
                if(time+newTime<des[newDes]){
                    pq.offer(new long[]{newDes,time+newTime});
                    des[newDes]= time+newTime;
                    count[newDes] = count[d];
                }
                else if(time+newTime==des[newDes]){
                    count[newDes]= (count[d]+count[newDes])%mod;
                }
            }
        }
        return count[n-1];
        
    }
}