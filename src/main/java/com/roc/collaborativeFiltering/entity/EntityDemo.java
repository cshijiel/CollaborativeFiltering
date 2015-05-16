package com.roc.collaborativeFiltering.entity;

import com.roc.collaborativeFiltering.annotation.FilterType;
import com.roc.collaborativeFiltering.annotation.FilterWeight;
import com.roc.collaborativeFiltering.handler.CosSimilarity;

@FilterType(CosSimilarity.class)
public class EntityDemo {

	@FilterWeight(5)
	private int age = 15;

	@FilterWeight
	private int sex = 1;

	private int id = 0;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
