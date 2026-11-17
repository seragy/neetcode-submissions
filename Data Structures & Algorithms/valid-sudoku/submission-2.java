class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //ROWS
        for(int r=0; r<9; r++)
        {
            Set<Character> seen = new HashSet<>();
            for(int c=0; c<9; c++)
            {
                char ch = board[r][c];
                if(ch == '.') continue;
                if(seen.contains(ch)) return false;
                seen.add(ch);
            }
        }

        //COLUMNS
        for(int c=0; c<9; c++)
        {
            Set<Character> set = new HashSet<>();
            for(int r=0; r<9; r++)
            {
                char ch = board[r][c];
                if(ch =='.') continue;
                if(set.contains(ch)) return false;
                set.add(ch);
            }
        }

        for(int box=0; box<9; box++)
        {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++)
            {
                int r = (box / 3) * 3 + i / 3;
                int c = (box % 3) * 3 + i % 3;
                char ch = board[r][c];
                if (ch == '.') continue;
                if (seen.contains(ch)) return false;
                seen.add(ch);
            }
        }

        return true;
    }
}