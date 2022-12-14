package gocamping.items;

public class BatteryWithFlashlight extends Battery {

	/* Constructor method */
	public BatteryWithFlashlight(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Enlight() {
		System.out.println("Enlightening the way.");
	}
}
