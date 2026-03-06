class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for(int[] pre: prerequisites){
            int sub = pre[0];
            int cou = pre[1];
            adj.get(cou).add(sub);
            inDegree[sub]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        int com=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            res[com++] = node;
            for(int neg: adj.get(node)){
                inDegree[neg]--;
                if(inDegree[neg]==0)queue.offer(neg);
            }
        }
        if(com==numCourses) return res;
        return new int[0];
    }
}