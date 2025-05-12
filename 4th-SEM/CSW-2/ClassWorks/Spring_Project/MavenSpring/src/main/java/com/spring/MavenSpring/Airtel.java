package com.spring.MavenSpring;

public class Airtel implements Sim{

	@Override
	public void data() {
		System.out.println("Data remaining in Airtel : 500TB");
	}

	@Override
	public void call() {
		System.out.println("Aryan Ji Aapka Airtel wala phone ki ghanti baj raha hai");
	}
	

}
