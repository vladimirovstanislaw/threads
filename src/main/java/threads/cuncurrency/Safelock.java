package threads.cuncurrency;

public class Safelock {
	public static void main(String args[]) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new BowLoop(alphonse, gaston)).start();
		new Thread(new BowLoop(gaston, alphonse)).start();
	}

}
