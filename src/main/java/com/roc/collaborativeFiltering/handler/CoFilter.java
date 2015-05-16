package com.roc.collaborativeFiltering.handler;

import java.lang.annotation.Annotation;

public class CoFilter implements CollaborativeFiltering {

	@SuppressWarnings("unchecked")
	public double getSimilarity(Object o, Object other) {
		if (o.getClass() == other.getClass()) {
			Class<?> objectType = o.getClass();
			Annotation[] as = objectType.getAnnotations();
			for (Annotation a : as) {

				String className = a
						.toString()
						.substring(a.toString().indexOf("value=class "),
								a.toString().length() - 1)
						.replace("value=class ", "");
				Class<? extends Handler> clazz = null;
				try {
					clazz = (Class<? extends Handler>) Class.forName(className);
					return clazz.newInstance().getSimilarity(o, other);// 可以改成单例模式，提高效率
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
