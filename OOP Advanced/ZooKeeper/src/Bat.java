
public class Bat extends Mammal {
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		System.out.println("WOOSH!");
		this.setEnergyLevel(this.getEnergyLevel() - 50);
		System.out.println("Bat energy is now: " + this.getEnergyLevel());
	}
	
	public void eatHumans() {
		System.out.println("OH GOD IT'S EATING MEEEeeee");
		this.setEnergyLevel(this.getEnergyLevel() + 25);
		System.out.println("Bat energy is now: " + this.getEnergyLevel());
	}
	
	public void attackTown() {
		System.out.println("THE BAT HAS SET EVERYTHING ON FIRE! RUN!!!");
		this.setEnergyLevel(this.getEnergyLevel() - 100);
		System.out.println("Bat energy is now: " + this.getEnergyLevel());
	}
}
