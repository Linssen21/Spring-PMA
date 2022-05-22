package com.sbtutorial.pma.springExample;

import net.bytebuddy.asm.Advice.This;

public class Car {
	Engine e;
	Doors d;
	Tires t;
	
	public Car(Engine e, Doors d, Tires t) {
		
		this.e = e;
		this.d = d;
		this.t = t;
	}
	
	
	public void printCarDetails() {
		System.out.println(this.e + " " + this.d);
	}

}
