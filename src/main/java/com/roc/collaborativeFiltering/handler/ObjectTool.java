package com.roc.collaborativeFiltering.handler;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.roc.collaborativeFiltering.annotation.FilterWeight;
import com.roc.collaborativeFiltering.annotation.MapFilter;

public class ObjectTool {

	protected static double getArithmeticProduct(Map<Object, Double> map,
			Map<Object, Double> other) {
		for (Object o : map.keySet()) {
			if (other.get(o) == null) {
				other.put(o, (double) 0);
			}
		}
		for (Object o : other.keySet()) {
			if (map.get(o) == null) {
				map.put(o, (double) 0);
			}
		}
		
		
		double sum = 0;
		for (Object key : map.keySet()) {
			sum += map.get(key) * other.get(key);
		}
		return sum;
	}

	protected static double getSquareRoot(Map<Object, Double> map) {
		double sum = 0;
		for (Object key : map.keySet()) {
			sum += Math.pow(map.get(key), 2);
		}
		return Math.pow(sum, 0.5);
	}

	protected static Map<Object, Double> getEntityFieldsMap(Object o) {
		Class<?> objectType = o.getClass();
		Field[] fields = objectType.getDeclaredFields();
		Class<FilterWeight> filterWeightClass = FilterWeight.class;
		Map<Object, Double> map = new HashMap<Object, Double>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(filterWeightClass)) {
				field.setAccessible(true);
				FilterWeight filterWeight = field
						.getAnnotation(filterWeightClass);

				int weight = filterWeight.value();
				int x = 0;
				try {
					x = (Integer) field.get(o);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				map.put(field.getName(), (double) (weight * x));
			} else if (field.isAnnotationPresent(MapFilter.class)) {
				field.setAccessible(true);
				try {
					@SuppressWarnings("unchecked")
					Map<Object, Double> map2 = (Map<Object, Double>) field
							.get(o);
					return map2;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
