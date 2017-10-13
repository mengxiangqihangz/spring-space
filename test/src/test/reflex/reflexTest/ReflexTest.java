package test.reflex.reflexTest;

import java.lang.reflect.Field;

import test.reflex.ReflexOne;

public class ReflexTest {
	private ReflexOne reflexOne;
	public String str(ReflexOne reflexOne,String name) throws Exception{
		this.reflexOne=reflexOne;
		return (String) getProperty(reflexOne, name);
		
	}
	
	     public Object getProperty(Object owner, String fieldName) throws Exception {       
	           Class ownerClass = owner.getClass();       
	         
	           Field field = ownerClass.getField(fieldName);       
	         
	           Object property = field.get(owner);       
	          
	            return property;       
	        }      
	     
	     public static void main(String[] args) throws Exception {
	    	 ReflexTest rt=new ReflexTest();
	    	 rt.str(new ReflexOne(), "fa");
		}

}
