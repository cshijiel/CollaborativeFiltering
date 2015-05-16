package com.roc.collaborativeFiltering;

import com.roc.collaborativeFiltering.entity.EntityDemo;
import com.roc.collaborativeFiltering.handler.CoFilter;
import com.roc.collaborativeFiltering.handler.CollaborativeFiltering;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		CollaborativeFiltering collaborativeFiltering = new CoFilter();
		Object o = new EntityDemo();
		((EntityDemo) o).setSex(1);
		EntityDemo o1 = new EntityDemo();
		o1.setSex(-9);
		o1.setAge(88);
		double d = collaborativeFiltering.getSimilarity(o, o1);
		System.out.println("similar:" + d);
	}
}
