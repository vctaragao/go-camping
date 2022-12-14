package gocamping.items;

public class Lighter extends Item {

	/* Constructor method */
	public Lighter(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Light() {
		System.out.println("lighting the campfire");
	}
}
