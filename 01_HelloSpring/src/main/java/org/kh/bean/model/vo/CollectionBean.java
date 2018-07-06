package org.kh.bean.model.vo;

import java.util.ArrayList;

public class CollectionBean {
	private ArrayList<String> nameList;
	
	public CollectionBean() {
		super();
	}

	public CollectionBean(ArrayList<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public ArrayList<String> getNameList() {
		return nameList;
	}

	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}
	
	
}
