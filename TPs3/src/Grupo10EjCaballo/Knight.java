package Grupo10EjCaballo;

/**
@author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 4/15/2021."
 **/

import StacksAndQueues.DynamicStack;
import utils.Scanner;
import utils.IsEmptyException;
import utils.UI;

import java.util.Arrays;

public class Knight {
    public Knight() {}
    
    private final int[][] knightMoves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};  //Possible knight moves

    //Displays the menu with all the three options (1. Complete a journey 2. Display Stack 3. Exit)
    public void knightMenu(int[] initialPosition) throws IsEmptyException {
        DynamicStack<int[]> firstJump = possibleMovesOfPosition(initialPosition); //Creates the first moves where the knight can move
        while (!firstJump.isEmpty()) {
            DynamicStack<int[]> secondJump = possibleMovesOfPosition(firstJump.peek()); //Creates the 2nd moves where the knight can move from the top of the 1st stack
            while (!secondJump.isEmpty()) {
                DynamicStack<int[]> thirdJump = possibleMovesOfPosition(secondJump.peek());  //Creates the 3rd moves where the knight can move from the top of the 2nd stack
                while (!thirdJump.isEmpty()) {
                    DynamicStack<int[]> fourthJump = possibleMovesOfPosition(thirdJump.peek());  //Creates the 4th moves where the knight can move from the top of the 3rd stack
                    while (!fourthJump.isEmpty()) {
                        UI.title("MENU");
                        System.out.println("\n1. Realizar el siguiente camino\n2. Mostrar el contenido de las pilas\n3. Salir (mostrar todos los caminos)\n");
                        int i = Scanner.getInt("Introduzca su opcion: ");
                        UI.clear();
                        switch (i) {
                            case 1:
                                fourthJump.pop(); //Completes the first path
                                break;
                            case 2: //prints the stacks available at that time
                                System.out.println(printStacks(createCopyStack(firstJump), createCopyStack(secondJump), createCopyStack(thirdJump), createCopyStack(fourthJump)));
                                break;
                            case 3: //exits the system and prints all the journeys.
                                System.out.println(PrintAllPossibleJourneys(initialPosition));
                                System.out.println("\n\n\n\n @author Maximiliano Maglio, Guido Molaro and Juan Manuel Pérez Menéndez on 4/15/2021.");
                                return;
                            default:
                                UI.message("¡Opcion Incorrecta!");

                        }

                    } thirdJump.pop();

                }secondJump.pop();

            }firstJump.pop();

        } PrintAllPossibleJourneys(initialPosition);
    }

    //Verifies if the jump is possible from one position to another
    public boolean validMove(int[] position, int[] newPosition) {
        if ((newPosition[0] < 1 || newPosition[0] > 8) || (newPosition[1] < 1 || newPosition[1] > 8)) {
            return false; //New position wasnt on the board
        }
        int[] move = {position[0] - newPosition[0], position[1] - newPosition[1]};
        for (int i = 0; i < knightMoves.length; i++) {
            if (Arrays.equals(move, knightMoves[i])) {
                return true; //New position can be arrived by one of the knight moves
            }
        }
        return false; //New position can't be arrived by one of the knight moves
    }

    //Stacks all the possible moves from a position
    public DynamicStack<int[]> possibleMovesOfPosition(int[] position) {
        DynamicStack<int[]> stack = new DynamicStack<int[]>();
        for (int i = 0; i < knightMoves.length; i++) {
            int[] possiblePosition = {(position[0] + knightMoves[i][0]), (position[1] + knightMoves[i][1])};
            if (validMove(position, possiblePosition)) {
                stack.stack(possiblePosition);
            }
        }
        return stack;
    }

    //Creates a copy of the stack to be able to display it fully
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

    //Changes the column number to its letter and returns the whole position in chess notation
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

    //Prints all possible journeys and adds it to a String
    public String PrintAllPossibleJourneys(int[] initialPosition) throws IsEmptyException {
        String s = "";
        int journeyNumber = 1;
        DynamicStack<int[]> firstJump = possibleMovesOfPosition(initialPosition);
        while (!firstJump.isEmpty()) {
            DynamicStack<int[]> secondJump = possibleMovesOfPosition(firstJump.peek());
            while (!secondJump.isEmpty()) {
                DynamicStack<int[]> thirdJump = possibleMovesOfPosition(secondJump.peek());
                while (!thirdJump.isEmpty()) {
                    DynamicStack<int[]> fourthJump = possibleMovesOfPosition(thirdJump.peek());
                    while (!fourthJump.isEmpty()) {
                        s += (printJourney(initialPosition, firstJump.peek(), secondJump.peek(), thirdJump.peek(), fourthJump.peek()));
                        journeyNumber ++;
                        fourthJump.pop();
                    }
                    thirdJump.pop();
                }
                secondJump.pop();
            }
            firstJump.pop();
        }
        return s + "\n- Hay un total de " + journeyNumber + " caminos posibles de 4 saltos empezando desde la posicion " + positionToNotation(initialPosition)+ ".";
    }

    //Prints a 4 move journey
    public String printJourney(int[] initialPosition, int[] firstJump, int[] secondJump, int[] thirdJump, int[] fourthJump) {
        return "  " + positionToNotation(initialPosition) + " --> " + positionToNotation(firstJump) + " --> " + positionToNotation(secondJump) + " --> " + positionToNotation(thirdJump) + " --> " + positionToNotation(fourthJump)+ "\n";
    }

    //Prints the 4 stacks
    public String printStacks(DynamicStack<int[]> firstJump,DynamicStack<int[]> secondJump,DynamicStack<int[]> thirdJump,DynamicStack<int[]> fourthJump) throws IsEmptyException {
        String stacks = " Pilas:  1    2    3    4" +"\n         ^    ^    ^    ^\n";
        while(!(firstJump.isEmpty() && secondJump.isEmpty() && thirdJump.isEmpty() && fourthJump.isEmpty())){
            for (int i = 0; i < 4; i++) {
                stacks += "       ";
                if (!firstJump.isEmpty()) {
                    stacks += "|" + positionToNotation(firstJump.peek()) + "| ";
                    firstJump.pop();
                }else stacks += "     ";
                if (!secondJump.isEmpty()) {
                    stacks += "|" + positionToNotation(secondJump.peek()) + "| ";
                    secondJump.pop();
                }else stacks += "     ";
                if (!thirdJump.isEmpty()) {
                    stacks += "|" + positionToNotation(thirdJump.peek()) + "| ";
                    thirdJump.pop();
                }else stacks += "     ";
                if (!fourthJump.isEmpty()) {
                    stacks += "|" + positionToNotation(fourthJump.peek()) + "|\n";
                    fourthJump.pop();
                }else stacks += "     \n";
            }
        }
        return stacks;
    }

    //Prints a stack
    public void printStack(DynamicStack<int[]> stack) throws IsEmptyException {
        while (!stack.isEmpty()) {
            System.out.print(positionToNotation(stack.peek()) + "| ");
            stack.pop();
        }
    }
}
