package ThreadTest.threadPlus;

public class Threads implements Runnable {

	@Override
	public void run() {

		System.out.println("dd");
		something();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void something() {
		while (true) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());

		}
	}

}
