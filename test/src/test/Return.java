package test;

import java.util.HashMap;
import java.util.Map;

public class Return {
	public Map<String, String> map(){
	 Map<String,String> mp=new HashMap<String,String>();
	 mp.put("美女", new Beauty(){
		 public String out(){
			 System.out.println("我爱刘诗诗");
		 return "吴奇隆是傻逼";
		 }

		@Override
		public String LiuShiShi() {
		   System.out.println("寂寞啊");
		return "求你别嫁人啊";
			
		
		}
	 }.LiuShiShi());
	 
	return mp;
	}
	
	
	
	public static void main(String[] args) {
		Return rt1=new Return();
		Return rt2=new Return();
		System.out.println(rt1.equals(rt2));
		
	}
	 
}
