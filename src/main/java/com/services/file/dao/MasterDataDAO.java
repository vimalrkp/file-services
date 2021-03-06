package com.services.file.dao;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class MasterDataDAO {

	public Set<String> getCategoryList() {
		Set<String> categoryList = new LinkedHashSet<>();
		categoryList.add("");
		categoryList.add("Phone");
		return categoryList;
	}

	public Set<String> getSubCategory1List() {
		Set<String> subCategory1List = new LinkedHashSet<>();
		subCategory1List.add("");
		subCategory1List.add("ANDROID");
		subCategory1List.add("IOS");
		return subCategory1List;
	}

	public Set<String> getsubCategory2List() {
		Set<String> subCategory2List = new LinkedHashSet<>();
		subCategory2List.add("");
		// Android
		subCategory2List.add("SAMSUNG-S20");
		subCategory2List.add("SAMSUNG-S21");
		// IOS
		subCategory2List.add("IPHONE-X");
		subCategory2List.add("IPHONE-11");
		subCategory2List.add("IPHONE-12");
		
		return subCategory2List;
	}

}
