class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new ArrayDeque<>();

        // count fresh oranges and enqueue rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4-directional

        // BFS: each pass of the while loop is one minute
        // stops as soon as no fresh oranges are left
        while (!rottenQueue.isEmpty() && freshCount > 0) {
            int size = rottenQueue.size(); // oranges rotten at the start of this minute

            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();

                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    // in bounds and fresh
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;                 // turn fresh orange to rotten
                        freshCount--;
                        rottenQueue.offer(new int[]{x, y});
                    }
                }
            }

            minutes++; // one full minute passed
        }

        // fresh oranges left means some were unreachable
        return freshCount == 0 ? minutes : -1;
    }
}