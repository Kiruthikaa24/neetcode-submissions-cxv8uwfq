class Solution {
    private int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
    ROWS = board.length;
    COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int i)
    {
        if(i==word.length())
        {
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(i) || board[r][c]=='#')
        {
            return false;
        }
        /*So now, 'A' is replaced with '#' temporarily.

Why?
To prevent revisiting the same cell while searching for subsequent characters.
If we don’t mark it, our DFS might loop back and reuse this cell again, causing infinite recursion or invalid paths.
Think of it as “locking” the cell until we finish exploring from it.
*/
        board[r][c]='#';
        boolean res=dfs(board,word, r+1,c,i+1) ||
        dfs(board,word, r-1,c,i+1) ||
        dfs(board,word, r,c+1,i+1) ||
        dfs(board,word, r,c-1,i+1);
        board[r][c]=word.charAt(i);
return res;
    }
    }
