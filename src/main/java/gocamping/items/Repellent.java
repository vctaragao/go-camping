package gocamping.items;

public class Repellent extends Item {

	/* Constructor method */
	public Repellent(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Repell() {
		System.out.println("Repelling insects..");
	}
}
