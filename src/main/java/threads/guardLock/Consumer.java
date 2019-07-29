package threads.guardLock;

import java.util.Random;

public class Consumer implements Runnable {
	private Drop drop;

	public Consumer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		try {
			for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
				System.out.format("MESSAGE RECEIVED: %s%n", message);
				Thread.sleep(5000);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
