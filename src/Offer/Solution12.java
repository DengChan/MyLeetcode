package Offer;

import java.util.HashMap;

public class Solution12 {
    public static boolean exist(char[][] board, String word) {
        if (word==null || board == null) return false;
        if(word.length()<1) return false;
        if(board.length<1) return false;
        if(board[0].length<1) return false;
        boolean[][] mark = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                mark[i][j] = true;
                if(dfs(board,mark,i,j,0,word)) return true;
                mark[i][j] = false;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,boolean[][] mark, int x, int y, int len, String word){

        if(board[x][y]!=word.charAt(len)) return false;
        else len = len+1;

        if(len==word.length()) return true;

        int[][] new_xy = {{x-1, y},{x+1,y},{x,y-1},{x, y+1}};
        boolean flag = false;
        for(int i =0;i<4;i++){
            int new_x = new_xy[i][0];
            int new_y = new_xy[i][1];
            if(new_x<0||new_x>=board.length||new_y<0|new_y>=board[0].length) continue;
            if(mark[new_x][new_y]) continue;
            mark[new_x][new_y] = true;
            flag = dfs(board, mark, new_x, new_y, len, word);
            if(flag) break;
            mark[new_x][new_y] = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b','c','d'}};
        System.out.println(exist(board,"abcd"));
    }
}
