package Grupo10EjCaballo;

import StacksAndQueues.DynamicStack;
import utils.Scanner;
import utils.IsEmptyException;

import java.util.Arrays;

public class Knight {
    //private int[] knightPosition;
    private int colPosition;
    private int rowPosition;
    private final int[][] knightMoves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};  //Possible knight moves

    public Knight(int colPosition, int rowPosition) {
        this.colPosition = colPosition;
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

    public boolean validMove(int[] position, int[] newPosition) {
        if ((newPosition[0] < 1 || newPosition[0] > 8) || (newPosition[1] < 1 || newPosition[1] > 8)) {
            return false;
        }
        int[] move = {position[0] - newPosition[0], position[1] - newPosition[1]};
        for (int i = 0; i < knightMoves.length; i++) {
            if (Arrays.equals(move, knightMoves[i])) {
                return true;
            }
        }
        return false;
    }

    public DynamicStack<int[]> possibleMoves(int[] position) {
        DynamicStack<int[]> stack = new DynamicStack<int[]>();
        for (int i = 0; i < knightMoves.length; i++) {
            int[] possiblePosition = {(position[0] + knightMoves[i][0]), (position[1] + knightMoves[i][1])};
            if (validMove(position, possiblePosition)) {
                stack.stack(possiblePosition);
            }
        }
        return stack;
    }

    public void printStack(DynamicStack<int[]> stack) throws IsEmptyException {
        while (!stack.isEmpty()) {
            System.out.print(positionToNotation(stack.peek()) + ", ");
            stack.pop();
        }
    }

    public DynamicStack<int[]> createCopyStack(DynamicStack<int[]> stack) throws IsEmptyException {
        DynamicStack<int[]> copyStack = new DynamicStack<>();
        int[][] auxArr = new int[stack.size()][];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            auxArr[i] = stack.peek();
            i--;
            stack.pop();
        }
        for (int j = 0; j < auxArr.length; j++) {
            copyStack.stack(auxArr[j]);
            stack.stack(auxArr[j]);
        }
        return copyStack;
    }

    public String printJourney(int[] initialPosition, int[] firstJump, int[] secondJump, int[] thirdJump, int[] fourthJump) {
        return positionToNotation(initialPosition) + " - " + positionToNotation(firstJump) + " - " + positionToNotation(secondJump) + " - " + positionToNotation(thirdJump) + " - " + positionToNotation(fourthJump);
    }

    public String positionToNotation(int[] position) {
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

    public void menu(int[] initialPosition) throws IsEmptyException {
        DynamicStack<int[]> firstJump = possibleMoves(initialPosition);
        while (!firstJump.isEmpty()) {
            DynamicStack<int[]> secondJump = possibleMoves(firstJump.peek());
            while (!secondJump.isEmpty()) {
                DynamicStack<int[]> thirdJump = possibleMoves(secondJump.peek());
                while (!thirdJump.isEmpty()) {
                    DynamicStack<int[]> fourthJump = possibleMoves(thirdJump.peek());
                    while (!fourthJump.isEmpty()) {
                        System.out.println("~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~\n1. Realizar el siguiente camino\n2. Mostrar el contenido de las pilas\n3. Salir");
                        int i = Scanner.getInt("Introduzca su opcion: ");
                        switch (i) {
                            case 1:
                                fourthJump.pop();
                                break;
                            case 2:
                                DynamicStack<int[]> jump1 = createCopyStack(firstJump);
                                DynamicStack<int[]> jump2 = createCopyStack(secondJump);
                                DynamicStack<int[]> jump3 = createCopyStack(thirdJump);
                                DynamicStack<int[]> jump4 = createCopyStack(fourthJump);
                                printStack(jump1);
                                printStack(jump2);
                                printStack(jump3);
                                printStack(jump4);
                                break;
                            case 3:
                                String s = possibleJourneys(initialPosition);
                                System.out.println(s);
                                return;
                        }
                        thirdJump.pop();
                    }
                    secondJump.pop();
                }
                firstJump.pop();
            }

        }
    }

    public String possibleJourneys ( int[] initialPosition) throws IsEmptyException {
        String s = "";
        DynamicStack<int[]> firstJump = possibleMoves(initialPosition);
        while (!firstJump.isEmpty()) {
            DynamicStack<int[]> secondJump = possibleMoves(firstJump.peek());
            while (!secondJump.isEmpty()) {
                DynamicStack<int[]> thirdJump = possibleMoves(secondJump.peek());
                while (!thirdJump.isEmpty()) {
                    DynamicStack<int[]> fourthJump = possibleMoves(thirdJump.peek());
                    while (!fourthJump.isEmpty()) {
                        s += (printJourney(initialPosition, firstJump.peek(), secondJump.peek(), thirdJump.peek(), fourthJump.peek()));
                        fourthJump.pop();
                    }
                    thirdJump.pop();
                }
                secondJump.pop();
            }
            firstJump.pop();
        }
        return s;
    }

}
