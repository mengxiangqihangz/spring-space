package ThreadTest.threadPlus.marketImpl;

import ThreadTest.threadPlus.Market;

/**
 * 顾客类
 * 
 */
public class Customer implements Market {

	@Override
	public synchronized void deal() {
		if (Number.count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			Number.count--;
			System.out.println(Thread.currentThread().getName() + "購買了第"
					+ Number.count + "个玩具");
			notifyAll();
		}

	}

}
