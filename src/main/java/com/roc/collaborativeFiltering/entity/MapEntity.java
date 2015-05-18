package com.roc.collaborativeFiltering.entity;

import java.util.HashMap;
import java.util.Map;

import com.roc.collaborativeFiltering.annotation.FilterType;
import com.roc.collaborativeFiltering.annotation.MapFilter;
import com.roc.collaborativeFiltering.handler.MapCosineSimilarity;

@FilterType(MapCosineSimilarity.class)
public class MapEntity {

	private int id = 1;

	@MapFilter
	private Map<Object, Double> map = new HashMap<Object, Double>();// 前者为向量名字，后者是向量的长度

	public Map<Object, Double> getMap() {
		return map;
	}

	public void setMap(Map<Object, Double> map2) {
		this.map = map2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
