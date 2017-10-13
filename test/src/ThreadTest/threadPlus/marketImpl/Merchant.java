package ThreadTest.threadPlus.marketImpl;

import ThreadTest.threadPlus.Market;

/**
 * 商家类
 * 
 */
public class Merchant implements Market {

	@Override
	public synchronized void deal() {
		if (Number.count == 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			Number.count++;
			System.out.println("商店进了第"+Number.count+"个玩具");
			notifyAll();
		}

	}

}
