package Grupo10EjCaballo;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;

import java.util.Arrays;

public class Knight {

    private int rowPosition;
    private int colPosition;
    private final int[][] knightMoves = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};  //Possible knight moves

    public Knight(int rowPosition, int colPosition){
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void moveKnight(int newRowPosition, int newColPosition) {
        if(validMove(newRowPosition, newColPosition)){
            rowPosition = newRowPosition;
            colPosition = newColPosition;
        }
    }

    public boolean validMove(int newRowPosition, int newColPosition){
        if((newRowPosition < 1 || newRowPosition > 8) || (newColPosition < 1 || newColPosition > 8)){
            return false;
        }
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

    private DynamicStack<int[]> posibleMoves(int[] position){
        DynamicStack<int[]> stack = new DynamicStack<int[]>();
        for (int i = 0; i < knightMoves.length; i++) {
            int[] possiblePosition = {(position[0] + knightMoves[i][0]), (position[1]+ knightMoves[i][1])};
            if (validMove(possiblePosition[0], possiblePosition[1])){
                stack.stack(possiblePosition);
            }
        }
        return stack;
    }

    public void printPossibleMoves(DynamicStack<int[]> possibleMoves) throws IsEmptyException {
        for (int i = 0; i <= possibleMoves.size(); i++) {
            System.out.println(Arrays.toString(possibleMoves.peek()));
            possibleMoves.pop();
        }
    }


}
