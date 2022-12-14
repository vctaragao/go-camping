package gocamping.items;

public class PurifyingCanteen extends Canteen {

	/* Constructor method */
	public PurifyingCanteen(int size, String description) {
		super(size, description);

	}

	/* Function of the item methods */
	@Override
	public void KeepWater() {
		PurifyWater();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StoreWater();
	}

	private void PurifyWater() {
		System.out.println("Purifying Water...");

	}
}
