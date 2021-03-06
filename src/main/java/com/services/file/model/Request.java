package com.services.file.model;

public class Request {

	private String category;

	private String subCategory1;

	private String subCategory2;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory1() {
		return subCategory1;
	}

	public void setSubCategory1(String subCategory1) {
		this.subCategory1 = subCategory1;
	}

	public String getSubCategory2() {
		return subCategory2;
	}

	public void setSubCategory2(String subCategory2) {
		this.subCategory2 = subCategory2;
	}

	@Override
	public String toString() {
		return "Request [category=" + category + ", subCategory1=" + subCategory1 + ", subCategory2=" + subCategory2
				+ "]";
	}

	
}
