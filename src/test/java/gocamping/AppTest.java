package gocamping;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import gocamping.items.Battery;
import gocamping.items.Item;
import gocamping.items.Knife;
import gocamping.items.Lighter;
import gocamping.items.Maps;
import gocamping.items.Rope;
import gocamping.items.Sunscreen;
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

    public void testRemoveItem() {
        // Create a new CampingBag with a capacity of 10
        CampingBag bag = new CampingBag(10);

        // Add some items to the bag
        bag.addItem(new Knife(1, "Faca"));
        bag.addItem(new Lighter(3, "Isqueiro"));
        bag.addItem(new Maps(2, "Mapa"));

        // Verify that the bag has the expected items
        assertEquals(6, bag.GetActualSize());
        assertNotNull(bag.getBagContents().get(0));
        assertNotNull(bag.getBagContents().get(1));
        assertNotNull(bag.getBagContents().get(2));

        // Remove an item from the bag
        Item removedItem = bag.RemoveItem(1);

        // Verify that the item was removed and the bag's size was updated
        assertEquals(3, bag.GetActualSize());
        assertEquals("Isqueiro", removedItem.getDescription());
        // assertNull(bag.getBagContents().get(2));
    }

    public void testRemoveNonExistentItem() {
        // Create a new CampingBag with a capacity of 10
        CampingBag bag = new CampingBag(10);

        // Add some items to the bag
        bag.addItem(new Knife(1, "Faca"));
        bag.addItem(new Rope(3, "Corda"));
        bag.addItem(new Sunscreen(2, "Nivea"));

        // Verify that the bag has the expected items
        assertEquals(6, bag.GetActualSize());
        assertNotNull(bag.getBagContents().get(0));
        assertNotNull(bag.getBagContents().get(1));
        assertNotNull(bag.getBagContents().get(2));

        // Try to remove an item with a non-existent key
        Item removedItem = bag.RemoveItem(3);

        // Verify that the bag's contents were not modified
        assertEquals(6, bag.GetActualSize());
        assertNotNull(bag.getBagContents().get(0));
        assertNotNull(bag.getBagContents().get(1));
        assertNotNull(bag.getBagContents().get(2));
        // Verify that the RemoveItem function returned null
        assertNull(removedItem);
    }

}
