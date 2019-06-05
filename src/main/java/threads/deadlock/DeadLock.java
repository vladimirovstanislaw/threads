package threads.deadlock;

public class DeadLock {
	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void bow(Friend bower) {
			System.out.format("%s: %s" + " has bowed to me!%n", this.name, bower.getName());			
			bower.bowBack(this);
		}

		public  void bowBack(Friend bower) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				alphonse.bow(gaston);
			}

		});
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				gaston.bow(alphonse);
			}

		});
	}
}
