package backtracking;

import java.util.Arrays;

public class NQueen {

    private int size = 0;
    public char[][] board;

    NQueen(int size) {
            this.size = size;
            board = new char[size][size];
            for(int i=0; i<size; i++)
            	Arrays.fill(board[i], '.');
    }

    public boolean nQueenSol(int col) {

            if(col >= size)
                    return true;

            for(int index=0; index<size; index++) {
                    if(isSafe(index, col)) {

                            board[index][col] = 'Q';
                            
                            if(nQueenSol(col+1)) 
                                    return true;
                            
                            board[index][col] = '.';
                    }
            }
            
            return false;
    }

    public boolean isSafe(int row_pos, int col_pos) {

            for(int i=0; i<size; i++) {
                    if(i!=row_pos && board[i][col_pos] == 'Q')
                            return false;
            }

            for(int j=0; j<size; j++) {
                    if(j!=col_pos && board[row_pos][j] == 'Q')
                            return false;
            }
            
            for(int i=row_pos+1, j=col_pos+1; i<size && j<size; i++, j++) {
                    if(board[i][j] == 'Q')
                            return false;
            }

            for(int i=row_pos-1, j=col_pos+1; i>=0 && j<size; i--, j++) {
                    if(board[i][j] == 'Q')
                            return false;
            }

            for(int i=row_pos-1, j=col_pos-1; i>=0 && j>=0; i--, j--) {
                    if(board[i][j] == 'Q')
                            return false;
            }

            for(int i=row_pos+1, j=col_pos-1; i<size && j>=0; i++, j--) {
                    if(board[i][j] == 'Q')
                            return false;
            }

            return true;
    }
}