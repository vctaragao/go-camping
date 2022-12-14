/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gocamping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gocamping.items.*;

/**
 *
 * @author Ken Healy
 */
public class App {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		int sizeOfBag = 10; // Total Size of the Bag

		// Instantiating the camping bag with it's size
		CampingBag myCampingBag = new CampingBag(sizeOfBag);

		/*
		 * Instantiating the variables related to the Items
		 */
		List<Item> itemsList = new ArrayList<Item>();
		Rope rope = new Rope(5, "Rope");
		itemsList.add(rope);

		Knife knife = new Knife(4, "Knife");
		itemsList.add(knife);

		SwitchBlade switchblade = new SwitchBlade(3, "SwitchBlade");
		itemsList.add(switchblade);

		PurifyingCanteen purifyingcanteen = new PurifyingCanteen(2, "Purifying Canteen");
		itemsList.add(purifyingcanteen);

		Canteen canteen = new Canteen(1, "Canteen");
		itemsList.add(canteen);

		Battery battery = new Battery(5, "Battery");
		itemsList.add(battery);

		BatteryWithFlashlight battery2 = new BatteryWithFlashlight(4, "Battery with a flashlight");
		itemsList.add(battery2);

		FirstAidKit firstkit = new FirstAidKit(3, "First Aid Kit");
		itemsList.add(firstkit);

		Maps maps = new Maps(2, "Maps");
		itemsList.add(maps);

		Repellent repellent = new Repellent(1, "Repellent");
		itemsList.add(repellent);

		Sunscreen sunscreen = new Sunscreen(1, "Sunscreen");
		itemsList.add(sunscreen);

		Lighter lighter = new Lighter(1, "Lighter");
		itemsList.add(lighter);

		// scanner to catch entries from the keyboard
		try (Scanner scanner = new Scanner(System.in)) {
			int option = -1;

			do {
				/* Menu display */
				System.out.println("\n\n                   ### Camping Planner ###");
				System.out.println("\n                  =========================");
				System.out.println("                  |     1 - Add Items     |");
				System.out.println("                  |     2 - Show bag      |");
				System.out.println("                  |     3 - Remove Item   |");
				System.out.println("                  |     0 - Go camping    |");
				System.out.println("                  =========================\n");

				option = scanner.nextInt();
				System.out.print("\n");
				switch (option) {

					/*
					 * Case 0: display message of exiting and prints the items in the camping bag
					 */
					case 0:
						System.out.println("                  YAY! We're going to camp!");
						Thread.sleep(500);
						PrintBag(myCampingBag);
						break;

					/*
					 * Case 1: Select, Add an item to the camping bag and remove it from the
					 * itemsList
					 */
					case 1:
						if (itemsList.size() > 0) {
							System.out.println("\n\n                   ### Camping Planner ###");
							System.out.println("\n                  ==================================");
							for (int i = 0; i < itemsList.size(); i++) {
								System.out.println("                  |     " + i + " - " + itemsList.get(i).toString()
										+ ", Size = " + itemsList.get(i).getSize());

							}
							System.out.println("                  ==================================\n");
							int value = scanner.nextInt();
							Boolean remove = myCampingBag.addItem(itemsList.get(value));
							if (remove) {
								itemsList.remove(value);
							}
							Thread.sleep(1500);
						} else {
							System.out.println("                  There's no items to be added to the bag!");
							Thread.sleep(500);
						}
						break;

					/*
					 * Case 2: simply prints the items in the camping bag
					 */
					case 2:
						if (myCampingBag.getBagContents().size() > 0) {
							PrintBag(myCampingBag);
						} else {
							System.out.println("                  There's no items in your bag!");
							Thread.sleep(500);
						}
						break;
					/*
					 * Case 3: remove items from the camping bag and replace it back into the
					 * itemsList
					 */
					case 3:
						if (myCampingBag.getBagContents().size() > 0) {
							PrintBag(myCampingBag);
							System.out.println("                  Choose an item to remove from the bag!");
							int delete = scanner.nextInt();
							System.out.println(delete);
							itemsList.add(myCampingBag.RemoveItem(delete));
						} else {
							System.out.println("                  There's no items to be removed!");
							Thread.sleep(500);
						}
						break;

					default:
						System.out.println("Op��o Inv�lida!");
						break;
				}
			} while (option != 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method that prints the items of the camping bag
	 */
	public static void PrintBag(CampingBag myCampingBag) {
		System.out.println("\n\n                  ### List Of Items in your bag ###");
		System.out.println("\n                  ==================================");
		for (int i = 0; i < myCampingBag.getBagContents().size(); i++) {
			System.out
					.println("                  |     " + i + " - " + myCampingBag.getBagContents().get(i).toString());
			System.out.println("                  |     size of the item above = "
					+ myCampingBag.getBagContents().get(i).getSize());

		}
		System.out.println("                  ==================================\n");
		System.out.println("                ***  Actual Size of your bag is " + myCampingBag.GetActualSize() + " ***");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
