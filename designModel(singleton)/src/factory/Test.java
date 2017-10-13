package factory;

import factory.imp.OperationAdd;
import factory.imp.OperationDiv;
import factory.imp.OperationMul;
import factory.imp.OperationSub;

public class Test {
	public static Operation createOperate(String method){
		{
			Operation oper=null;
			switch(method){
				case "+":{
					oper=new OperationAdd();
					break;
				}
				 case "-":{ 
					oper = new OperationSub(); 
					break; 
				} 
				case "*": { 
					 oper = new OperationMul(); 
					 break; 
	            } 
				case "/": { 
					 oper = new OperationDiv(); 
					 break; 
			    } 		
			}
			return oper;
		}
	}
	/**
	 * 调用工厂，需要createOperator("/")，就能返回除法运算符。
	 * 优点：客户端不需要修改代码。缺点： 当需要增加新的运算类的时候，不仅需新加运算类，还要修改工厂类，违反了开闭原则。
	 */
}
