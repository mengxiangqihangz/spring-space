package ThreadTest.threadPlus;

public class Test1 {
	public static void main(String[] args) {
		Thread td = new Thread(new Threads(), "A");

		td.start();

	}

}
