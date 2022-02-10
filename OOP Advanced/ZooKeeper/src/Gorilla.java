
public class Gorilla extends Mammal {
	
	public Gorilla() {
		
	}
	
	public void throwSomething() {
		System.out.println("Gorilla throws something!");
		this.setEnergyLevel(this.getEnergyLevel() - 5);
		System.out.println("Energy is now: " + this.getEnergyLevel());
	}
	
	public void eatBananas() {
		System.out.println("Gorilla eats bananas!");
		this.setEnergyLevel(this.getEnergyLevel() + 10);
		System.out.println("Energy is now: " + this.getEnergyLevel());
	}
	
	public void climb() {
		System.out.println("Gorilla climbs!");
		this.setEnergyLevel(this.getEnergyLevel() - 10);
		System.out.println("Energy is now: " + this.getEnergyLevel());
	}
}
