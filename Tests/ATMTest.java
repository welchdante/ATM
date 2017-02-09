import GUI.ATM;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class ATMTest {

    /**************************************************
     * Testing the constructor
     **************************************************/

    @Test
    public void testConstructor() throws Exception{

        ATM test1 = new ATM(6,5,4);

        assertEquals(test1.getHundreds(),6);
        assertEquals(test1.getFifties(),5);
        assertEquals(test1.getTwenties(),4);

        ATM test2 = new ATM();
        assertEquals(test2.getHundreds(),0);
        assertEquals(test2.getFifties(),0);
        assertEquals(test2.getTwenties(),0);

        ATM test3 = new ATM(test1);
        assertEquals(test3.getHundreds(),6);
        assertEquals(test3.getFifties(),5);
        assertEquals(test3.getTwenties(),4);
    }

    /**************************************************
     * Testing the equals method
     **************************************************/

    @Test
    public void testEquals1() throws Exception {

        ATM s1 = new ATM(2, 5, 4);
        ATM s2 = new ATM(6, 5, 4);
        ATM s3 = new ATM(2, 5, 4);

        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s3));
    }

    @Test
    public void testEquals2() throws Exception {

        ATM s1 = new ATM(2, 5, 4);
        ATM s2 = new ATM(6, 5, 4);
        ATM s3 = new ATM(2, 5, 4);

        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s3));
    }

    @Test
    public void testEquals3() throws Exception {

        ATM s1 = new ATM(2, 5, 4);
        ATM s2 = new ATM(6, 5, 4);
        ATM s3 = new ATM(2, 5, 4);
        ATM s4 = new ATM(2, 5, 4);
        assertTrue(s1.equals(s3, s4));
        assertFalse(s1.equals(s2,s3));
    }

    /**************************************************
     * Testing the compareTo method
     **************************************************/

    @Test
    public void testCompareTo1() throws Exception {

        ATM s1 = new ATM(2, 5, 4);
        ATM s2 = new ATM(6, 5, 4);
        ATM s3 = new ATM(2, 3, 4);
        ATM s4 = new ATM(2, 5, 4);

        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);
    }

    @Test
    public void testCompareTo2() throws Exception {

        ATM s1 = new ATM(2, 5, 4);
        ATM s2 = new ATM(6, 5, 4);
        ATM s3 = new ATM(0, 0, 0);
        ATM s4 = new ATM(2, 5, 4);

        assertTrue(s1.compareTo(s2,s1) == 1);
        assertTrue(s1.compareTo(s1,s2) == -1);
        assertTrue(s1.compareTo(s1,s4) == 0);
    }

    /**************************************************
     * Testing the putIn method
     **************************************************/

    @Test
    public void testPutIn() throws Exception {

        ATM s1 = new ATM();
        s1.putIn(2,3,4);

        assertEquals (s1.getHundreds(), 2);
        assertEquals (s1.getFifties(), 3);
        assertEquals (s1.getTwenties(), 4);
    }

    @Test
    public void testPutIn1() throws Exception {

        ATM s1 = new ATM();
        ATM s2 = new ATM(0,0,0);

        s1.putIn(2,3,4);
        assertEquals (s1.getHundreds(), 2);
        assertEquals (s1.getFifties(), 3);
        assertEquals (s1.getTwenties(), 4);

        assertEquals (s2.getHundreds(), 0);
        assertEquals (s2.getFifties(), 0);
        assertEquals (s2.getTwenties(), 0);
    }

    @Test
    public void testPutIn2() throws Exception {

        ATM s1 = new ATM(5,5,5);
        ATM s2 = new ATM(2,2,2);

        s1.putIn(s2);
        assertEquals (s1.getHundreds(), 7);
        assertEquals (s1.getFifties(), 7);
        assertEquals (s1.getTwenties(), 7);
    }

    /**************************************************
     * Testing the takeOut methods
     **************************************************/

    @Test
    public void testTakeOut1() throws Exception {

        ATM s1 = new ATM(3,3,2);
        ATM s2 = new ATM(0,0,0);

        s1.takeOut(1,1,1);
        assertEquals (s1.getHundreds(),2);
        assertEquals (s1.getFifties(),2);
        assertEquals (s1.getTwenties(),1);

        s2.takeOut(1,1,1);
        assertEquals (s2.getHundreds(),-1);
        assertEquals (s2.getFifties(),-1);
        assertEquals (s2.getTwenties(),-1);
    }

    @Test
    public void testTakeOut2() throws Exception {

        ATM s1 = new ATM(3,3,2);
        ATM s2 = new ATM(0,0,0);
        ATM s3 = new ATM(8,5,6);
        ATM s4 = new ATM(4,3,1);

        s1.takeOut(s2);
        assertEquals (s1.getHundreds(),3);
        assertEquals (s1.getFifties(),3);
        assertEquals (s1.getTwenties(),2);

        assertEquals (s2.getHundreds(),0);
        assertEquals (s2.getFifties(),0);
        assertEquals (s2.getTwenties(),0);

        s3.takeOut(s4);
        assertEquals (s3.getHundreds(),4);
        assertEquals (s3.getFifties(),2);
        assertEquals (s3.getTwenties(),5);

        assertEquals (s4.getHundreds(),4);
        assertEquals (s4.getFifties(),3);
        assertEquals (s4.getTwenties(),1);
    }

    /**************************************************
     * Testing the takeOut method exhaustively
     * It tests every possible combination of hundreds,
     * fifties. twenties and dollar amounts up to
     * $1500
     **************************************************/

    @Test
    public void testTakeOut3() throws Exception {

        for(int h = 0; h < 5; h++){
            for(int f = 0; f < 10; f++){
                for(int t = 0; t < 25; t++){
                    for(int amt = 0; amt <= 1500; amt++){

                        int availableHundreds = h;
                        int availableFifties = f;
                        int availableTwenties = t;
                        ATM s1 = new ATM(h,f,t);
                        ATM s2 = s1.takeOut(amt);

                        int neededFifties = (amt % 20 == 10 && amt >= 50) ? 1 : 0;

                        availableFifties -= neededFifties;

                        int neededTwenties = (amt - neededFifties*50)/20;

                        int neededHundreds = 0;

                        while(availableHundreds > 0 && neededTwenties >= 5){
                            neededTwenties-=5;
                            neededHundreds++;
                            availableHundreds--;
                        }

                        while(availableFifties > 1 && neededTwenties >= 5){
                            neededTwenties-=5;
                            availableFifties-=2;
                            neededFifties+=2;
                        }

                        if(availableFifties < 0 || neededTwenties > availableTwenties
                                || (amt < 50 && amt % 20 != 0
                                || amt % 10 != 0)){
                            assertTrue(s2 == null);
                        }
                        else{
                            assertEquals(neededTwenties, s2.getTwenties());
                            assertEquals(neededFifties, s2.getFifties());
                            assertEquals(neededHundreds, s2.getHundreds());
                        }
                    }
                }
            }
        }
    }

    /**************************************************
     * Testing the load and save methods
     **************************************************/

    @Test
    public void testLoadSave() {

        ATM s1 = new ATM(6, 5, 4);
        ATM s2 = new ATM(6, 5, 4);

        s1.save("file1");
        s1 = new ATM();  // resets to zero

        s1.load("file1");
        assertTrue(s1.equals(s2));
    }

    /**************************************************
     * Testing the null exceptions in takeOut
     **************************************************/

    @Test
    public void testTakeOutNull() {

        ATM s1 = new ATM(3,1,2);
        ATM s2 = s1.takeOut(700);
        assertEquals(s2,  null);
    }

    /**************************************************
     * Testing the suspend method
     **************************************************/

    @Test
    public void testMutate() {

        ATM s1 = new ATM(6, 5, 4);
        ATM.suspend(true);
        s1.takeOut(120);
        assertEquals (s1.getHundreds(), 6);
        assertEquals (s1.getFifties(), 5);
        assertEquals (s1.getTwenties(), 4);
        ATM.suspend(false);
    }
}