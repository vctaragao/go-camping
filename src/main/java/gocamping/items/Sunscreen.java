package gocamping.items;

public class Sunscreen extends Item {

	/* Constructor method */
	public Sunscreen(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Protect() {
		System.out.println("Protecting against the sun");
	}
}
