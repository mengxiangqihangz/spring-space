package test;
	/**
	* http://cantellow.iteye.com/blog/838473
	*�������̲߳���ȫ���������߳�ͬʱ�ߵ�if��ʱ���������жϡ���Ϊnull������������ʵ��
	*/
//public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//
//    public static Singleton getInstance() {
//		if (instance == null) {
//		    instance = new Singleton();
//		}
//		return instance;
//    }
//}
	/**�������̰߳�ȫ������synchronizedͬ��ͬ������*/
//public class Singleton {
//    private static Singleton instance;
//    private Singleton (){}
//    public static synchronized Singleton getInstance() {
//		if (instance == null) {
//		    instance = new Singleton();
//		}
//		return instance;
//    }
//}
    /** ������ ���ַ�ʽ����classloder���Ʊ����˶��̵߳�ͬ������*/
//public class Singleton {  
//    private static Singleton instance = new Singleton();
//    private Singleton (){}
//    public static Singleton getInstance() {
//    	return instance;        
//    }
//}
	
	/**���������֣�����һ�ֲ��*/
//public class Singleton {
//        private static Singleton instance = null;
//        static {
//        	instance = new Singleton();
//        }
//        private Singleton (){}
//        public static Singleton getInstance() {
//    	return instance;
//    }
	
    /*��̬�ڲ���*/
/**	�����ֺ͵����ַ�ʽ��ֻҪSingleton�౻װ���ˣ���ôinstance�ͻᱻʵ������û�дﵽlazy loadingЧ�����������ַ�ʽ��Singleton�౻װ���ˣ�
 *instance��һ������ʼ������ΪSingletonHolder��û�б�����ʹ�ã�ֻ����ʾͨ������getInstance����ʱ���Ż���ʾװ��SingletonHolder�࣬�Ӷ�ʵ����instance
*���ʵ������������Դ�������������ӳټ��ء������ǲ�ϣ��Singleto�����ʱ��ʵ������
*��ô���ʱ�����ǲ��ô˷����ͷǳ�����	
*/
//public class Singleton {
//    private static class SingletonHolder {
//    	private static final Singleton INSTANCE = new Singleton();
//    }
//    private Singleton (){}
//    public static final Singleton getInstance() {
//    	return SingletonHolder.INSTANCE;
//    }
//}
	/**ö��        ����Effective Java����Josh Bloch �ᳫ�ķ�ʽ*/
	//�����ܱ�����߳�ͬ�����⣬���ܷ�ֹ�����л����´����µĶ���
//public enum Singleton {
//    INSTANCE;
//    public void whateverMethod() {
//    }
//}
	/**˫��У����*/
//public class Singleton {
//    private volatile static Singleton singleton;
//    private Singleton (){}
//    public static Singleton getSingleton() {
//		if (singleton == null) {
//		    synchronized (Singleton.class) {
//			if (singleton == null) {
//			    singleton = new Singleton();
//			}
//		}
//	}
//	return singleton;
//    }
//}
/*
1.��������ɲ�ͬ����װ����װ�룬�Ǳ��п��ܴ��ڶ���������ʵ�����ٶ�����Զ�˴�ȡ������һЩservlet������ÿ��servletʹ����ȫ��ͬ����װ�����������Ļ����������servlet����һ�������࣬���ǾͶ����и��Ե�ʵ����
2.���Singletonʵ����java.io.Serializable�ӿڣ���ô������ʵ���Ϳ��ܱ����л��͸�ԭ��������������������л�һ��������Ķ��󣬽�������ԭ����Ǹ���������ͻ��ж���������ʵ����
*/
	/*��һ�������޸��취*/
//public class Singleton {
//	private static Class getClass(String classname) throws ClassNotFoundException {   
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();   
//
//		if(classLoader == null){
//			classLoader = Singleton.class.getClassLoader();   
//		}
//		return (classLoader.loadClass(classname));   
//	}   
//}
	/*��һ�������޸��İ취*/
//public class Singleton implements java.io.Serializable {   
//	   public static Singleton INSTANCE = new Singleton();   
//	    
//	   protected Singleton() {   	      
//	   }   
//	   private Object readResolve() {   
//		   return INSTANCE;   
//	   }  
//} 