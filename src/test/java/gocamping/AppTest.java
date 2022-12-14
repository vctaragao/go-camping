package gocamping;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import gocamping.items.Battery;
import gocamping.items.Knife;
import gocamping.items.Lighter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testExpectedItemListed() {
        // Create a mock CampingBag object
        CampingBag myCampingBag = new CampingBag(10);
        myCampingBag.addItem(new Battery(1, "Bateria"));

        // Capture the output of the PrintBag method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the PrintBag method
        App.PrintBag(myCampingBag);

        // Check if the expected item (Tent) is listed in the output
        assertTrue(outContent.toString().contains("Bateria"));
        assertTrue(outContent.toString().contains("Actual Size of your bag is"));
    }

    public void testExpectedItemNotListed() {
        // Create a mock CampingBag object
        CampingBag myCampingBag = new CampingBag(10);
        myCampingBag.addItem(new Knife(1, "Faca"));

        // Capture the output of the PrintBag method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the PrintBag method
        App.PrintBag(myCampingBag);

        // Check if the expected item (Tent) is listed in the output
        assertFalse(outContent.toString().contains("Bateria"));
    }

    public void testAddItemSmallerThanBagCapacity() {
        CampingBag bag = new CampingBag(10);
        Knife item = new Knife(5, "A small item"); // size of the Item is 5
        boolean result = bag.addItem(item);
        assertTrue(result);
    }

    public void testAddItemBiggerThanBagCapacity() {
        CampingBag bag = new CampingBag(10);
        Knife item = new Knife(15, "A small item"); // size of the Item is 5
        boolean result = bag.addItem(item);
        assertFalse(result);
    }

    public void testAddItemExectQuantityOfBagCapacity() {
        CampingBag bag = new CampingBag(10);

        Knife item = new Knife(5, "A small item");
        assertTrue(bag.addItem(item));

        Lighter ligher = new Lighter(5, "A small item");
        assertTrue(bag.addItem(ligher));
    }

    public void testAddItemMoreQuantityOfBagCapacityLeft() {
        CampingBag bag = new CampingBag(10);

        Knife item = new Knife(5, "A small item");
        assertTrue(bag.addItem(item));

        Lighter ligher = new Lighter(8, "A small item");
        assertFalse(bag.addItem(ligher));
    }

}
