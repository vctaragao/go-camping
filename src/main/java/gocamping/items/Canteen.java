package gocamping.items;

public class Canteen extends Item {

	/* Constructor method */
	public Canteen(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void KeepWater() {
		StoreWater();
	}

	public void StoreWater() {
		System.out.println("Storing the Water");
	}
}
