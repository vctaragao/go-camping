package gocamping.items;

public class Knife extends Item {

	/* Constructor method */
	public Knife(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Cut() {
		System.out.println("Cutting");
	}
}
