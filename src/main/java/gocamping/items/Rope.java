package gocamping.items;

public class Rope extends Item {

	/* Constructor method */
	public Rope(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Knot() {
		System.out.println("Knotting");
	}
}
