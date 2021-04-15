package Grupo10EjCaballo;

import StacksAndQueues.DynamicStack;
import org.junit.Assert;
import org.junit.Test;
import utils.IsEmptyException;

public class KnightTest {

    Knight knight = new Knight(1,1);

    /*@Test
    public void movedKnightCorrectly() {
        knight.moveKnight(3,2);
        int[] expected = {3,2};
        Assert.assertArrayEquals(expected, new int[]{knight.getRowPosition(), knight.getColPosition()});

    }*/

    @Test
    public void validMoveShouldReturnFalse(){
        boolean validMove = knight.validMove(new int[]{1,1},new int[]{5,7});
        Assert.assertFalse(validMove);
    }

    @Test
    public void validMoveShouldReturnFalse2(){
        boolean validMove = knight.validMove(new int[]{1,1},new int[]{0,7});
        Assert.assertFalse(validMove);
    }

    @Test
    public void validMoveShouldReturnTrue(){
        boolean validMove = knight.validMove(new int[]{1,1},new int[]{2,3});
        Assert.assertTrue(validMove);
    }

    @Test
    public void possibleMovesPrintedCorrectly() throws IsEmptyException {
        DynamicStack<int[]> possibleMoves = knight.possibleMoves(new int[]{5,5});
        knight.printStack(possibleMoves);
    }

    @Test
    public void possibleJourneysPrintedCorrectly() throws IsEmptyException {
        knight.possibleJourneys(new int[]{1, 1});
    }

    @Test
    public void stackCopiedCorrectly() throws IsEmptyException{
        DynamicStack<int[]> stack = knight.possibleMoves(new int[]{5,5});
        DynamicStack<int[]> copyStack = knight.createCopyStack(stack);
        knight.printStack(stack);
        System.out.println("");
        knight.printStack(copyStack);

    }

    @Test
    public void menuTest() throws IsEmptyException{
        knight.menu(new int[]{1,1});
    }
}