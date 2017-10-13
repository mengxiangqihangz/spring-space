package test;

public class ReturnTest implements Beauty {

	@Override
	public String LiuShiShi() {
		System.out.println("我们结婚吧");

		return "癞蛤蟆想吃天鹅肉";
	}

	public static void main(String[] args) {
         
		SingletonClass sc1=SingletonClass.getInstance();
		SingletonClass sc2=SingletonClass.getInstance();
		System.out.println(sc1.equals(sc2));
	
	}
	

}
