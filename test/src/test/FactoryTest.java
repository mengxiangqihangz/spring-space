package test;

public class FactoryTest {
	private Factory factory;
	
		public Factory test0(){
			return new FactoryImpl();
		};
		
		public Factory test1(){
			return new FactoryImpl_();
		};
			
		
	
	
public static void main(String[] args) {
	Factory fy=new FactoryTest().test0();
	fy.work();
}
	
}
