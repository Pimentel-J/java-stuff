package com.stuff.concurrency;

/**
 * Java Concurrency - Threads
 * Ticket class
 *
 * @author Pimentel
 */
public class Ticket {

	/**
	 * Ticket's number
	 */
	private int number;

	/**
	 * Ticket's default number
	 */
	private static final int DEFAULT_NUMBER = 0;


	/**
	 * Initializes ticket constructor by default
	 */
	public Ticket() {
		this.number = DEFAULT_NUMBER;
	}

	/**
	 * Initializes ticket constructor with ticket's number
	 *
	 * @param number a
	 */
	public Ticket(int number) {
		this.number = number;
	}

	/**
	 * Prints ticket's info
	 *
	 * @return number
	 */
	@Override
	public String toString() {
		return String.format("Ticket nº %d", number);
	}
}
