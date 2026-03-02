class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] pre : prerequisites){
            int cor = pre[0];
            int dep = pre[1];
            adj.get(dep).add(cor);
            inDegree[cor]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        int com=0;
        while(!queue.isEmpty()){
            int cor = queue.poll();
            com++;
            for(int t : adj.get(cor)){
                inDegree[t]--;
                if(inDegree[t]==0) queue.offer(t);
            }
        }
        return com==numCourses;
    }
}