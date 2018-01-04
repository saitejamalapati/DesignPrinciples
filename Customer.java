package com.accolite.au;

abstract class Coffee {
	public void serve() {
		System.out.println("Serving\n");
	}
	public void deliver() {
		make_Coffee();
		serve();
		System.out.println("Delivering.....\n");
	}
	public abstract void make_Coffee();
}

class Cappuccino extends Coffee{
	@Override
	public void make_Coffee() {
		System.out.println("Making Cappuccino\n");
	}
}

class Esperano extends Coffee{
	@Override
	public void make_Coffee() {
		System.out.println("Preparing Espareno\n");
	}
}

class Latte extends Coffee{
	@Override
	public void make_Coffee() {
		System.out.println("Preparing Latte\n");
	}
}

class CoffeeFactory {
	
	public static Coffee getCoffee(char opt) {
		switch(opt) {
		case 'C':
			return new Cappuccino();
		case  'E':
			return new Esperano();
		case 'L':
			return new Latte();
		default:
			return null;
		}
	}
}

public class Customer {
	public static void main(String[] args) {
		Coffee coffee = CoffeeFactory.getCoffee('E');
		coffee.deliver();
	}
}
