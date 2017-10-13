package ThreadTest;

public class Thread2 implements Runnable {
	private Thread1 threadl;

	public Thread2(Thread1 threadl) {
		this.threadl = threadl;
	}

	/**
	 * 生产者run方法
	 * 
	 */
	public void run() {

		while (true) {

			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			threadl.count_2();
		}

	}

}
