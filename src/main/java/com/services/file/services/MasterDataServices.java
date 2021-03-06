package com.services.file.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.file.dao.MasterDataDAO;

@Service
public class MasterDataServices {

	@Autowired
	private MasterDataDAO dao;

	public Set<String> getCategoryList() {
		return dao.getCategoryList();
	}

	public Set<String> getSubCategory1List() {
		return dao.getSubCategory1List();
	}

	public Set<String> getsubCategory2List() {
		return dao.getsubCategory2List();
	}
}
