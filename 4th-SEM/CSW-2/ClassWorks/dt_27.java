package csw2;
class bicycle{
	int gear;
	int speed;
	public bicycle(int gear,int speed){
		this.gear=gear;
		this.speed=speed;
	}
	
	public void applyBrake(int decrement) {
		speed-=decrement;
		
	}
	public void speedUp(int increment) {
		speed+=increment;
	}   
	public String toString() {
		return gear+" "+speed;
	}
}

class mountainBike extends bicycle{
	int seatHeight;
	public mountainBike(int gear,int speed,int seatHeight) {
	super(gear,speed);
	this.seatHeight=seatHeight;
}

	public String toString() {
		return super.toString()+" "+seatHeight;
}

}
public class dt_27 {

	public static void main(String[] args) {
		mountainBike b1=new mountainBike(5,35,54);
		b1.speedUp(32);	
		
		
	}

}
