package com.roc.collaborativeFiltering;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

import com.roc.collaborativeFiltering.annotation.FilterType;
import com.roc.collaborativeFiltering.entity.EntityDemo;
import com.roc.collaborativeFiltering.handler.CollaborativeFiltering;
import com.roc.collaborativeFiltering.handler.CosSimilarity;
import com.roc.collaborativeFiltering.handler.Handler;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		CollaborativeFiltering collaborativeFiltering = new CosSimilarity();
		Object o = new EntityDemo();
		((EntityDemo) o).setSex(1);
		EntityDemo o1 = new EntityDemo();
		o1.setSex(5);
		o1.setAge(0);
		double d = collaborativeFiltering.getSimilarity(o, o1);
		System.out.println("similar:" + d);

		Class<?> objectType = o.getClass();
		Annotation[] as = objectType.getAnnotations();
		for (Annotation a : as) {

			String className = a
					.toString()
					.substring(a.toString().indexOf("value=class "),
							a.toString().length() - 1)
					.replace("value=class ", "");
			System.out.println(className);
			Class<? extends Handler> clazz = null;
			try {
				clazz = (Class<? extends Handler>) Class.forName(className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println(clazz.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}
}
