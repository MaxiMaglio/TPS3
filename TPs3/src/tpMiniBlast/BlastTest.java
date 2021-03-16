package tpMiniBlast;

import org.junit.Assert;

import static org.junit.Assert.*;

public class BlastTest {

    @org.junit.Test
    public void blast() {
        Blast mb = new Blast();
         char[] a = {'a','g','c','t'};
         char[] b = {'a','c','g','t'};
        Assert.assertEquals(50.0, mb.blast(a, b), 0);
    }
}