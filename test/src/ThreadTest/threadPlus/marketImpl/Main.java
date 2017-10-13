package ThreadTest.threadPlus.marketImpl;

public class Main {
	public static void main(String[] args) {
		RunMethod rd = new RunMethod(new Merchant(), new Customer());
		Thread td = new Thread(rd, "张三");
		Thread td1 = new Thread(rd, "李四");
		Thread td2 = new Thread(rd, "王五");  	
		Thread td3 = new Thread(rd, "沈六");
		Thread td4 = new Thread(rd, "钱七");

		td.start();
		td1.start();
		td2.start();
		td3.start();
		td4.start();

	}

}
