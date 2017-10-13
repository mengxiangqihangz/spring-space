package ThreadTest;

public class Test {
	public static void main(String[] args) {
		Thread1 tdx = new Thread1();
		Thread td = new Thread(new Thread2(tdx), "生产者A线程");
		Thread td1 = new Thread(new Thread3(tdx), "消费者B线程");

		td1.start();
		td.start();
	}
}