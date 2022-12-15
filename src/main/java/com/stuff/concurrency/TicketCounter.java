package com.stuff.concurrency;

/**
 * Java Concurrency - Threads
 * Ticket Counter class
 *
 * @author Pimentel
 */
public class TicketCounter {

	/**
	 * Ticket's number
	 */
	private int count;

	/**
	 * Ticket's default number
	 */
	private static final int DEFAULT_COUNT = 0;


	/**
	 * Initializes vehicle constructor by default
	 */
	public TicketCounter() {
		count = DEFAULT_COUNT;
	}

	/**
	 * Initializes ticket constructor with ticket's number
	 *
	 * @param count initial counter value
	 */
	public TicketCounter(int count) {
		this.count = count;
	}

	/**
	 * Increments counter
	 */
	public synchronized void increment() {
		count++;
	}

	/**
	 * Decrements counter
	 */
	public synchronized void decrement() {
		count--;
	}

	/**
	 * Returns count value
	 *
	 * @return count
	 */
	public synchronized int getCountValue() {
		return count;
	}

	/**
	 * Prints ticket's count
	 *
	 * @return count
	 */
	@Override
	public String toString() {
		return String.format("Ticket Count: %d%n", count);
	}
}
