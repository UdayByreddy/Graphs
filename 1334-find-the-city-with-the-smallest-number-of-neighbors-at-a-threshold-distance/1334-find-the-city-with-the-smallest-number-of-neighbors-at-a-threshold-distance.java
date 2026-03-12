class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] dis = new int[n][n];
      for(int i=0;i<n;i++){
        Arrays.fill(dis[i],Integer.MAX_VALUE);
      }
      for(int[] edge:edges){
        dis[edge[0]][edge[1]]=edge[2];
        dis[edge[1]][edge[0]]=edge[2];
      }
      for(int i=0;i<n;i++){
        dis[i][i]=0;
      }
      for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dis[i][k]!=Integer.MAX_VALUE && dis[k][j]!=Integer.MAX_VALUE){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
      }
      int countMax=Integer.MAX_VALUE;
      int city=-1;
      for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<n;j++){
            if(dis[i][j]!=Integer.MAX_VALUE && dis[i][j]<=distanceThreshold){
                count++;
            }
        }
        if(count<=countMax){
            countMax=count;
            city=i;
        }
      }
      return city;

        
    }
}