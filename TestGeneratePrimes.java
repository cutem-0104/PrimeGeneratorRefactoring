import junit.framework.*;

public class TestGeneratePrimes extends TestCase {
    public static void main(String[] args) {
        junit.swingui.TestRunner.main(new String[] {"TestGenereatePrimes"});
    }

    public TestGenereatePrimes(String name) {
        super(name);
    }

    public void testPrimes() {
        int[] nullArray = GeneratePrimes.generatePrimes(0);
        assertEquals(nullArray.length, 0);
        int[] minArray = GeneratePrimes.generatePrimes(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);
        int[] threeArray = GeneratePrimes.generatePrimes(3);
        assertEquals(minArray.length, 2);
        assertEquals(minArray[0], 2);
        assertEquals(minArray[1], 3);
        int[] centArray = GeneratePrimes.generatePrimes(100);
        assertEquals(minArray.length, 25);
        assertEquals(minArray[24], 97);
    }
}