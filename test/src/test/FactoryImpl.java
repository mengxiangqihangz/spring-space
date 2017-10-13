package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import test.FactoryImpl_;

public class FactoryImpl {
	private FactoryImpl_ F;

	FactoryImpl() {
		System.out.println("jajdaskdj");
	}

	{
		// System.out.println(F.getClass());
		System.out.println("aaaaaaaaaaaa");
	}

	public void java(Object str) {

		System.out.println(str.getClass());
	}

	public static void main(String args[]) throws Exception {
		// Class<?> cs = Class.forName("test.FactoryImpl_");
		// Class<?> cs1=(Class<?>) cs.newInstance();
		// FactoryImpl_ fl=new FactoryImpl_();

		// Field fd[] = cs.getDeclaredFields();
		//
		// for (Field a : fd) {
		// System.out.println(fl.a);
		// }
		//
		// Class<?> cs = Class.forName("test.FactoryImpl_");
		//
		// Field fd= cs.getField("a");
		// System.out.println("fyf");
		// fd.setInt("f1", 17);
		//
		// System.out.println();
		// FactoryImpl_.j();
		//
		// System.out.println(args[0]);
		//
		// FactoryImpl_ p=new FactoryImpl_();
		// FactoryImpl_ d=p;
		// System.out.println(d==p);
		int d = FactoryImpl_.a;

		FactoryImpl_.j();
		System.out.println(d);

		new FactoryImpl().java(new FactoryImpl_());
		;

	}
}