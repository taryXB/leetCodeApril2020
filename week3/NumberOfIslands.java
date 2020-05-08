/* Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {

    public int numIslands(char[][] grid) {
        if(grid.length ==0 || grid[0].length==0)
            return 0;
        int numberOfIsland = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        Queue<Integer> islandQueue  = new LinkedList<>();
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(toVisit(grid,i,j,isVisited,islandQueue)){
                    while (!islandQueue.isEmpty()){
                        int currentI = islandQueue.poll();
                        int currentJ = islandQueue.poll();
                        toVisit(grid,currentI+1,currentJ,isVisited,islandQueue);
                        toVisit(grid,currentI,currentJ+1,isVisited,islandQueue);
                        toVisit(grid,currentI-1,currentJ,isVisited,islandQueue);
                        toVisit(grid,currentI,currentJ-1,isVisited,islandQueue);
                    }
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }
    public boolean toVisit(char[][] grid, int i, int j, boolean[][] isVisited, Queue<Integer> queue){
        if(i>=0 && i<grid.length && j >=0 && j<grid[0].length && !isVisited[i][j] && grid[i][j]=='1'){
            queue.offer(i);
            queue.offer(j);
            isVisited[i][j]=true;
            return true;
        }
        return false;
    }
}

