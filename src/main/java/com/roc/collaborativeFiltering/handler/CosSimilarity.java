package com.roc.collaborativeFiltering.handler;

import java.util.Map;

public class CosSimilarity implements Handler {

public double getSimilarity(Object o, Object other) {
	Map<Object, Double> oMap = ObjectTool.getEntityFieldsMap(o);
	Map<Object, Double> otherMap = ObjectTool.getEntityFieldsMap(other);
	double upLine = ObjectTool.getArithmeticProduct(oMap, otherMap);
	double downLine = ObjectTool.getSquareRoot(oMap)
			* ObjectTool.getSquareRoot(otherMap);
	return upLine / downLine;
}

}
