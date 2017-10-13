package test;
	/**
	* http://cantellow.iteye.com/blog/838473
	*懒汉。线程不安全，当两个线程同时走到if处时。若交替判断。都为null。便会出现两个实例
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
	/**懒汉，线程安全。利用synchronized同步同步机制*/
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
    /** 饿汉， 这种方式基于classloder机制避免了多线程的同步问题*/
//public class Singleton {  
//    private static Singleton instance = new Singleton();
//    private Singleton (){}
//    public static Singleton getInstance() {
//    	return instance;        
//    }
//}
	
	/**饿汉，变种，与上一种差不多*/
//public class Singleton {
//        private static Singleton instance = null;
//        static {
//        	instance = new Singleton();
//        }
//        private Singleton (){}
//        public static Singleton getInstance() {
//    	return instance;
//    }
	
    /*静态内部类*/
/**	第三种和第四种方式是只要Singleton类被装载了，那么instance就会被实例化（没有达到lazy loading效果），而这种方式是Singleton类被装载了，
 *instance不一定被初始化。因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance
*如果实例化很消耗资源，我们想让他延迟加载。或我们不希望Singleto类加载时就实例化，
*那么这个时候我们采用此方法就非常合理	
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
	/**枚举        。。Effective Java作者Josh Bloch 提倡的方式*/
	//不仅能避免多线程同步问题，还能防止反序列化重新创建新的对象
//public enum Singleton {
//    INSTANCE;
//    public void whateverMethod() {
//    }
//}
	/**双重校验锁*/
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
1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
*/
	/*第一个问题修复办法*/
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
	/*第一个问题修复的办法*/
//public class Singleton implements java.io.Serializable {   
//	   public static Singleton INSTANCE = new Singleton();   
//	    
//	   protected Singleton() {   	      
//	   }   
//	   private Object readResolve() {   
//		   return INSTANCE;   
//	   }  
//} 