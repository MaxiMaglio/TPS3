package Grupo10EjCaballo;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;

import java.util.Arrays;

public class Knight {
    private int[] knightPosition;
    private int rowPosition;
    private int colPosition;
    private final int[][] knightMoves = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};  //Possible knight moves

    public Knight(int rowPosition, int colPosition){
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
        this.knightPosition = new int[]{rowPosition, colPosition};
    }

    public int getColPosition() {
        return colPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void moveKnight(int newRowPosition, int newColPosition) {
        if(validMove(knightPosition, new int[]{newRowPosition, newColPosition})){
            rowPosition = newRowPosition;
            colPosition = newColPosition;
        }
    }

    public boolean validMove(int[] position, int[] newPosition){
        if((newPosition[0] < 1 || newPosition[0] > 8) || (newPosition[1] < 1 || newPosition[1] > 8)){
            return false;
        }
        int[] move = {position[0] - newPosition[0], position[1] - newPosition[1]};
        for (int i = 0; i < knightMoves.length; i++) {
            if (Arrays.equals(move, knightMoves[i])){
                return true;
            }
        }
        return false;
    }

    public DynamicStack<int[]> possibleMoves(int[] position){
        DynamicStack<int[]> stack = new DynamicStack<int[]>();
        for (int i = 0; i < knightMoves.length; i++) {
            int[] possiblePosition = {(position[0] + knightMoves[i][0]), (position[1]+ knightMoves[i][1])};
            if (validMove(position, new int[]{possiblePosition[0], possiblePosition[1]})){
                stack.stack(possiblePosition);
            }
        }
        return stack;
    }

    public void printPossibleMoves(DynamicStack<int[]> possibleMoves) throws IsEmptyException {
       while(!possibleMoves.isEmpty()){
            System.out.print(Arrays.toString(possibleMoves.peek()));
            possibleMoves.pop();
        }
    }

    public String printJourney(int[] initialPosition, int[] firstJump, int[] secondJump, int[] thirdJump, int[] fourthJump){
        return Arrays.toString(initialPosition) + " - " +Arrays.toString(firstJump) + " - " + Arrays.toString(secondJump) + " - " + Arrays.toString(thirdJump) + " - " + Arrays.toString(fourthJump);
    }

    public String positionToNotation(int[] position){
        switch (position[0]){

        }
          return "";
    }

    public int[] getKnightPosition() {
        return knightPosition;
    }

    public void metodoPija(int[] initialPosition) throws IsEmptyException {
        DynamicStack<int[]> firstJump = possibleMoves(initialPosition);
        while(!firstJump.isEmpty()){
            DynamicStack<int[]> secondJump = possibleMoves(firstJump.peek());
            while (!secondJump.isEmpty()){
                DynamicStack<int[]> thirdJump = possibleMoves(secondJump.peek());
                while (!thirdJump.isEmpty()){
                    DynamicStack<int[]> fourthJump = possibleMoves(thirdJump.peek());
                    while (!fourthJump.isEmpty()){
                        System.out.println(printJourney(initialPosition, firstJump.peek(), secondJump.peek(),thirdJump.peek(),fourthJump.peek()));
                        fourthJump.pop();
                    }
                    thirdJump.pop();
                }
                secondJump.pop();
            }
            firstJump.pop();
        }
    }
}
