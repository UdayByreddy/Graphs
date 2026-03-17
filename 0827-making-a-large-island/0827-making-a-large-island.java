class Solution {
    class Disjoint {
        int[] parent;
        int[] size;

        public Disjoint(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int x) {
            if (parent[x] == x)
                return parent[x];
            parent[x] = findParent(parent[x]);
            return parent[x];
        }

        public void findUnion(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            if (px == py)
                return;
            if (size[px] > size[py]) {
                parent[py] = px;
                size[px] += size[py];
            } else {
                parent[px] = py;
                size[py] += size[px];
            }
        }

        public int getSize(int x) {
            return size[x];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n * n);
        int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int dx = i + d[0];
                        int dy = j + d[1];
                        if (dx >= 0 && dx < n && dy >= 0 && dy < n && grid[dx][dy] == 1) {
                            if (ds.findParent(i * n + j) != ds.findParent(dx * n + dy)) {
                                ds.findUnion(i * n + j, dx * n + dy);
                            }
                        }
                    }
                }

            }
        }
        int ans = 0;
        for (int i = 0; i < n * n; i++) {
            ans = Math.max(ans, ds.getSize(ds.findParent(i)));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int[] d : dir) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            set.add(ds.findParent(nx * n + ny));
                        }
                    }
                    int size = 1;
                    for (int s : set) {
                        size += ds.getSize(s);
                    }
                    ans = Math.max(ans, size);
                }
            }
        }
        return ans;

    }
}