package ThreadTest.threadPlus.marketImpl;

import ThreadTest.threadPlus.Market;

public class RunMethod implements Runnable {
	private Merchant merchant;
	private Customer customer;

	RunMethod(Merchant mt, Customer cr) {
		merchant = mt;
		customer = cr;
	}

	@Override
	public void run() {
		while (true) {

			customer.deal();
			 	
		}

	}

}
