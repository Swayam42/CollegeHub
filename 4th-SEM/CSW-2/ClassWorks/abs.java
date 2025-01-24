package csw2;

abstract class Remote {
	abstract void turnOff();
	abstract void turnOn();
}

class TVremote extends Remote {
	@Override
	void turnOn() {
		System.out.println("ON");
	}
	@Override
	void turnOff(){
		System.out.println("OFF");
	}
}
public class abs {

	public static void main(String[] args) {

	Remote r1=new TVremote();
	r1.turnOn();
	r1.turnOff();
	}

}
