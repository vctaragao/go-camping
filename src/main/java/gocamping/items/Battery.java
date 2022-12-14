package gocamping.items;

public class Battery extends Item {

	/* Constructor method */
	public Battery(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Charge() {
		System.out.println("Charging your utensil.");
	}
}
