class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        // 옮기기
        for(int i = 0; i < n; i++) {
            int stoneCnt = 0;
            for(int j = 0; j < m; j++) {
                if(boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    stoneCnt += 1;
                }
                else if(boxGrid[i][j] == '*') {
                    for(int k = 1; k <= stoneCnt; k++){
                        boxGrid[i][j - k] = '#';
                    }
                    stoneCnt = 0;
                }
                if(j == m - 1){
                    for(int k = 0; k < stoneCnt; k++){
                        boxGrid[i][j - k] = '#';
                    }
                }
            }
        }

        // 회전시키기
        char[][] boxRotate = new char[m][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boxRotate[j][n - (i + 1)] = boxGrid[i][j];
            }
        }

        // return boxGrid;
        return boxRotate;
    }
}