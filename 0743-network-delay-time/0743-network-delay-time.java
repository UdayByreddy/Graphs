class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
       for(int[] time : times){
        int src = time[0];
        int des = time[1];
        int t = time[2];
        adj.get(src).add(new int[]{des,t});
       }
       PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
       int[] des = new int[n+1];
       Arrays.fill(des,Integer.MAX_VALUE);
       queue.offer(new int[]{k,0});
       des[k]=0;
       while(!queue.isEmpty()){
        int[] temp = queue.poll();
        int node = temp[0];
        int time = temp[1];
        for(int[] a : adj.get(node)){
            if(time+a[1]<des[a[0]]){
                queue.offer(new int[]{a[0],time+a[1]});
                des[a[0]]=time+a[1];
            }
        }
       }
       int ans =0;
       for(int i=1;i<=n;i++){
        if(des[i]==Integer.MAX_VALUE) return -1;
        ans = Math.max(ans,des[i]);
       }
       return ans;
        
        
    }
}