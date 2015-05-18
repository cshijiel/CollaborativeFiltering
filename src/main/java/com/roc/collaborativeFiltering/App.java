package com.roc.collaborativeFiltering;

import java.util.HashMap;
import java.util.Map;

import com.roc.collaborativeFiltering.entity.EntityDemo;
import com.roc.collaborativeFiltering.entity.MapEntity;
import com.roc.collaborativeFiltering.handler.CoFilter;
import com.roc.collaborativeFiltering.handler.CollaborativeFiltering;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		CollaborativeFiltering collaborativeFiltering = new CoFilter();
		EntityDemo o = new EntityDemo();
		o.setSex(1);
		o.setAge(23);
		EntityDemo o1 = new EntityDemo();
		o1.setSex(0);
		o1.setAge(17);
		double d = collaborativeFiltering.getSimilarity(o, o1);
		System.out.println("similar:" + d);
		
		MapEntity mapEntity = new MapEntity();
		Map<Object, Double> map = new HashMap<Object, Double>();
		map.put(1, (double) 2);
		map.put(2, (double) 2);
		map.put(3, (double) 2);
		map.put(4, (double) 2);
		mapEntity.setMap(map);
		
		MapEntity mapEntity2 = new MapEntity();
		Map<Object, Double> map2 = new HashMap<Object, Double>();
		map2.put(1, (double) 2);
		map2.put(2, (double) 2);
		map2.put(3, (double) 2);
		map2.put(5, (double) 2);
		mapEntity2.setMap(map2);
		
		d = collaborativeFiltering.getSimilarity(mapEntity, mapEntity2);
		System.out.println("similar:" + d);	
		
	}
	
	
	
	
	
	
}
