package gocamping.items;

public class FirstAidKit extends Item {

	/* Constructor method */
	public FirstAidKit(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void Heal() {
		System.out.println("You're using the kit to heal your injure!");
	}
}
