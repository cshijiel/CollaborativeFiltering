package com.roc.collaborativeFiltering.handler;

import java.lang.annotation.Annotation;

public class CoFilter implements CollaborativeFiltering {

	public double getSimilarity(Object o, Object other) {
		if (o.getClass() == other.getClass()) {
			Class<?> objectType = o.getClass();
			Annotation[] as = objectType.getAnnotations();
			for (Annotation annotation : as) {
			}
		}
		return 0;
	}

}
