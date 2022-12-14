/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gocamping;

import gocamping.items.Item;
import java.util.ArrayList;

/**
 * YOU WILL NEED TO ADJUST SOME OF THIS CODE AND/OR ADD YOUR OWN CODE!
 *
 * @author STUDENT DETAILS HERE
 */
public class CampingBag {

    private int ActualSize = 0;
    private int capacity;
    private ArrayList<Item> bagContents = new ArrayList<Item>();

    /**
     * Create a camping bag with a given capacity
     *
     * @param capacity - the capacity as an int
     */
    public CampingBag(int capacity) {
        this.capacity = capacity;
    }

    /**
     * CODE TO BE COMPLETED BY STUDENT
     * YOU NEED TO UPDATE THE COMMENTS ALSO!
     *
     * @return true if bag is full, else false
     */
    public boolean isFull(Item thingToAdd) {
        // If the bag is full then true, else false. Setting 100 to limit of the bag.

        if (ActualSize + thingToAdd.getSize() > capacity) {
            return true;
        } else {
            SetActualSize(ActualSize + thingToAdd.getSize());
            return false;

        }
    }

    /**
     * CODE TO BE COMPLETED BY STUDENT
     * YOU NEED TO UPDATE THE COMMENTS ALSO!
     *
     * @param thingToAdd - an object that is an Item or a sub-class of Item - to be
     *                   added to the bag contents
     * @return - true if the item added successfully; false if the item could not be
     *         added
     */
    public boolean addItem(Item thingToAdd) {
        /*
         * Verify if the bag is full, if it is then warn the user,
         * else add the item to the bag and confirm that by message to the user
         */
        if (isFull(thingToAdd)) {
            System.out.println("The item is bigger then the actual capacity, please try again.");
            return false;
        } else {

            bagContents.add(thingToAdd);
            System.out.println("Added " + thingToAdd + " to the bag!");
            return true;
        }
    }

    /*
     * Remove the item from the bag, warn it to the user
     * and return the item removed to the main class to include it to the itemsList.
     */
    public Item RemoveItem(int value) {

        if (value > bagContents.size() - 1) {
            return null;
        }

        Item item = bagContents.get(value);
        bagContents.remove(value);
        SetActualSize(GetActualSize() - item.getSize());
        System.out.println(item + " removed from the bag!");
        return item;
    }

    /*
     * YOU MAY ADD ADDITIONAL METHODS HERE TO COMPLETE OTHER TASKS
     * REMEMBER THAT METHODS FOR A "CAMPINGBAG" MUST MAKE SENSE!
     */

    /* Getters and Setters */
    public ArrayList<Item> getBagContents() {
        return bagContents;
    }

    private void SetActualSize(int val) {
        this.ActualSize = val;
    }

    public int GetActualSize() {
        return ActualSize;
    }

}
