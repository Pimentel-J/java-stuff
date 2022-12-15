package com.stuff.concurrency;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 * Java Concurrency - Threads
 * Concurrent ticket selling simulation
 *
 * @author Pimentel
 * @see java.lang.Runnable
 */
public class Seller implements Runnable {

	/**
	 * Ticket's vector
	 */
	final Vector<Ticket> tickets;

	/**
	 * Ticket's counter
	 */
	TicketCounter counter;

	/**
	 * Initializes ticket constructor
	 */
	public Seller() {
		this.tickets = new Vector<>();
		this.counter = new TicketCounter();
	}

	/**
	 * Number of sellers
	 */
	private static final int SELLERS_NUMBER = 3;

	/**
	 * Semaphore
	 */
	private final Semaphore semaphore = new Semaphore(1, true);

	/**
	 * To be called by .start()
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		long threadId = Thread.currentThread().threadId();

		try {
			Thread.sleep(1000);
			// Same object hash in both threads means the Object instance is shared between the two threads
			System.out.printf("%s [ID %d] running...[Counter obj hash: %s]\n", threadName, threadId, this.counter.hashCode());
			synchronized (this) { // See context switching in action
				if (!tickets.isEmpty()) {
					Ticket ticket = sell();
					System.out.printf("%s bought by %s [ID %d]\n", ticket, threadName, threadId);
					System.out.println("Available ticket's: " + this.counter.getCountValue());
				} else {
					System.out.println("Tickets sold out!\n");
					System.exit(0);
				}
			}
		} catch (InterruptedException ignored) {
			ignored.printStackTrace();
		}

		// Sync read operation
		synchronized (this) {
			System.out.printf("%s [ID %d] end\n", threadName, threadId);
		}
	}

	/**
	 * Sells the ticket
	 *
	 * @return						ticket
	 * @throws InterruptedException ie
	 */
	protected Ticket sell() throws InterruptedException {
		synchronized (tickets) { // synchronization - critical area start
			// Uncomment to log the available permits
//			String threadName = Thread.currentThread().getName();
//			long threadId = Thread.currentThread().threadId();
//			System.out.printf("%s [ID %d]: acquiring lock... [available permits: %d]\n",
//					threadName, threadId, this.semaphore.availablePermits());
			Thread.sleep(2000);
			this.semaphore.acquire(); // Protected area
			Ticket ticket = tickets.firstElement();
			tickets.removeElementAt(0);
			this.counter.decrement();
			this.semaphore.release(); // Protected area

			return ticket;
		}                        // synchronization - critical area end
	}

	/**
	 * Adds tickets for sale
	 */
	public void insert() {
		synchronized (tickets) { // synchronization - critical area start
			try {

				this.semaphore.acquire(); // Protected area
				for (int i = 0; i < SELLERS_NUMBER; i++) {
					Ticket ticket = new Ticket(i + 1);
					tickets.addElement(ticket);
					this.counter.increment();
				}
				System.out.printf("%d tickets added\n", SELLERS_NUMBER);
				this.semaphore.release(); // Protected area

			} catch (InterruptedException ignored) {
				ignored.printStackTrace();
			}
		}                        // synchronization - critical area end
	}

	/**
	 * Main
	 *
	 * @param args Command-Line Arguments
	 */
	public static void main(String[] args) {
		System.out.println("[main start]");

		Seller seller = new Seller(); // Define class that implements Runnable
		seller.insert();

		for (int i = 0; i < SELLERS_NUMBER; i++) {
			Thread t = new Thread(seller);    // Create thread
			t.start();                          // Starts thread running the run() method
			// Uncomment to test interrupt on 2nd thread
//			if (i == 1) { t.interrupt(); }
		}

	}
}
