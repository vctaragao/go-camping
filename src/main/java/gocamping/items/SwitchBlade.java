package gocamping.items;

public class SwitchBlade extends Knife {

	/* Constructor method */
	public SwitchBlade(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	public void OpenBottle() {
		System.out.println("Oppening Bottle");
	}

	public void Screw() {
		System.out.println("Screwing");
	}

	public void Scissor() {
		System.out.println("Scissoring");
	}

}
