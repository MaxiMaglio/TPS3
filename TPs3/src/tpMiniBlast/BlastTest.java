package tpMiniBlast;

import org.junit.Assert;

import static org.junit.Assert.*;

public class BlastTest {

    @org.junit.Test
    public void blast() {
        Blast mb = new Blast();
        String a = "tgctacataatt";
        String b = "agctacatacat";
        Assert.assertEquals(75.0, mb.blast(a, b), 0);
    }
}