package ThreadTest;

public class Thread1 {

	private int count = 0;

	/**
	 * 消费者判断
	 * 
	 */
	public synchronized void count_1() {

		if (count == 0) {
			try {
				System.out.println(Thread.currentThread().getName() + "阻塞");
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {

			System.out.println("消费者购买了第" + count + "个商品"
					+ Thread.currentThread().getName());
			count--;
			notify();

		}
	}

	/**
	 * 生产者者判断
	 * 
	 */
	public synchronized void count_2() {
		if (count == 10) {
			try {
				System.out.println(Thread.currentThread().getName() + "阻塞");
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			count++;
			System.out.println("生产者生产了第" + count + "个商品"
					+ Thread.currentThread().getName());
			notify();

		}
	}

}
