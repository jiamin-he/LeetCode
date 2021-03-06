/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Image Smoother
 Difficulty: Easy
 Notes:

Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].

*/

class Solution1 {
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0) return M;
        int rows = M.length; 
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols ; j++ ) {
                int count = 0, sum = 0;
                for (int inRow : new int[] {-1,0,1} ) {
                    for (int inCol : new int[] {-1,0,1} ) {
                        if(isValid(i+inRow, j+inCol, rows, cols)) {
                            count++;
                            sum += M[i+inRow][j+inCol];
                        } 
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }

    public boolean isValid(int x, int y, int rows, int cols){
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

    public static void main(String[] args) {
        
    }
}
