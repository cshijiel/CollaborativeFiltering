package com.roc.collaborativeFiltering.handler;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.roc.collaborativeFiltering.annotation.FilterWeight;

public class ObjectTool {

	protected static double getArithmeticProduct(Map<String, Double> map,
			Map<String, Double> other) {
		double sum = 0;
		for (String key : map.keySet()) {
			sum += map.get(key) * other.get(key);
		}
		return sum;
	}

	protected static double getSquareRoot(Map<String, Double> map) {
		double sum = 0;
		for (String key : map.keySet()) {
			sum += Math.pow(map.get(key), 2);
		}
		return Math.pow(sum, 0.5);
	}

	protected static Map<String, Double> getEntityFieldsMap(Object o) {
		Class<?> objectType = o.getClass();
		Field[] fields = objectType.getDeclaredFields();
		Class<FilterWeight> filterWeightClass = FilterWeight.class;
		Map<String, Double> map = new HashMap<String, Double>();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(filterWeightClass)) {
				FilterWeight filterWeight = field
						.getAnnotation(filterWeightClass);

				int weight = filterWeight.value();
				int x = 0;
				try {
					x = (Integer) field.get(o);
				} catch (IllegalAccessException e) {
					System.out.println("error");
					e.printStackTrace();
				}
//				System.out.println(field.getName() + ":" + weight * x);
				map.put(field.getName(), (double) (weight * x));
			}
		}
		return map;
	}
}
