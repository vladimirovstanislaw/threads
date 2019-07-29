package threads.guardLock;

public class Drop {
	private String message;
	private boolean empty = true;

	public synchronized String take() throws InterruptedException {
		// Wait until message is
		// available.
		System.out.println("Drop take() empty = " + empty + " message = " + message);
		while (empty) {
			System.out.println("Drop.take.wait()");
			wait();
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void put(String messString) throws InterruptedException {
		System.out.println("Drop put() empty = " + empty + " message = " + message);
		while (!empty) {
			try {
				System.out.println("Drop.put.wait()");
				wait();
			} catch (InterruptedException ex) {

			}
		}
		empty = false;
		this.message = messString;
		notifyAll();
	}

}
