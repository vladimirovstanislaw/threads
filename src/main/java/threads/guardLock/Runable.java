package threads.guardLock;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drop drop = new Drop();
		
		(new Thread(new Consumer(drop))).start();
		(new Thread(new Producer(drop))).start();
	}

}
