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
	 * ���ù�������ҪcreateOperator("/")�����ܷ��س����������
	 * �ŵ㣺�ͻ��˲���Ҫ�޸Ĵ��롣ȱ�㣺 ����Ҫ�����µ��������ʱ�򣬲������¼������࣬��Ҫ�޸Ĺ����࣬Υ���˿���ԭ��
	 */
}
