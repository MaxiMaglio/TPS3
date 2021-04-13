package Grupo10EjCaballo;

import StacksAndQueues.DynamicStack;
import utils.IsEmptyException;

import java.util.Arrays;

public class Knight {
    //private int[] knightPosition;
    private int colPosition;
    private int rowPosition;
    private final int[][] knightMoves = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};  //Possible knight moves

    public Knight(int colPosition, int rowPosition){
        this.colPosition= colPosition;
        this.rowPosition = rowPosition;
        //this.knightPosition = new int[]{colPosition rowPosition};
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    /*public void moveKnight(int newColPosition int newRowPosition) {
        if(validMove(knightPosition, new int[]{newColPosition newRowPosition})){
            colPosition= newColPosition
            rowPosition = newRowPosition;
            knightPosition= new int[]{newRowPosition, newColPosition;
        }
    }*/

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
            if (validMove(position, possiblePosition)){
                stack.stack(possiblePosition);
            }
        }
        return stack;
    }

    public void printPossibleMoves(DynamicStack<int[]> possibleMoves) throws IsEmptyException {
       while(!possibleMoves.isEmpty()){
            System.out.print(positionToNotation(possibleMoves.peek()));
            possibleMoves.pop();
        }
    }

    public String printJourney(int[] initialPosition, int[] firstJump, int[] secondJump, int[] thirdJump, int[] fourthJump){
        return positionToNotation(initialPosition) + " - " +positionToNotation(firstJump) + " - " + positionToNotation(secondJump) + " - " + positionToNotation(thirdJump) + " - " + positionToNotation(fourthJump);
    }

    public String positionToNotation(int[] position){
        return switch (position[0]) {
            case 1 -> "A" + position[1];
            case 2 -> "B" + position[1];
            case 3 -> "C" + position[1];
            case 4 -> "D" + position[1];
            case 5 -> "E" + position[1];
            case 6 -> "F" + position[1];
            case 7 -> "G" + position[1];
            case 8 -> "H" + position[1];
            default -> "";
        };
    }

    /*public int[] getKnightPosition() {
        return knightPosition;
    }*/

    public void possibleJourneys(int[] initialPosition) throws IsEmptyException {
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
