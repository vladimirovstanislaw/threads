package threads.cuncurrency;

import java.util.Random;

public class BowLoop implements Runnable {
	private Friend bower;
	private Friend bowee;

	public BowLoop(Friend bower, Friend bowee) {
		this.bower = bower;
		this.bowee = bowee;
	}

	public void run() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		for (;;) {
			try {
				Thread.sleep(rnd.nextInt(10));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			bowee.bow(bower);
		}
		

	}

}
