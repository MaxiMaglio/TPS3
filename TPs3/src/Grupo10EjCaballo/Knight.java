package Grupo10EjCaballo;

import java.util.Arrays;

public class Knight {
    private int rowPosition;
    private int colPosition;
    private final int[][] knightMoves = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};  //Possible knight moves

    public Knight(int rowPosition, int colPosition){
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public void moveKnight(int newRowPosition, int newColPosition) {

            if(validMove(newRowPosition, newColPosition)) {
                rowPosition = newRowPosition;
                colPosition = newColPosition;
            }
    }

    private boolean validMove(int newRowPosition, int newColPosition){
        int rowMove = rowPosition - newRowPosition;
        int colMove = colPosition - newColPosition;
        int[] move = {rowMove, colMove};
        for (int i = 0; i < knightMoves.length; i++) {
            if (Arrays.equals(move, knightMoves[i])){
                return true;
            }
        }
        return false;
    }
}
