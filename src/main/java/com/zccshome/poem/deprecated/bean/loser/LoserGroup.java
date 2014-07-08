package com.zccshome.poem.deprecated.bean.loser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"className", "count", "items"})
@XmlRootElement(name="loserGroup")
public class LoserGroup {
	private String className;
	private int count;
	private List<Loser> loserList;
	
	public LoserGroup() {
		super();
		this.loserList = new ArrayList<Loser>();
	}
	public LoserGroup(String name, int count) {
		super();
		this.className = name;
		this.count = count;
		this.loserList = new ArrayList<Loser>();
	}
	public LoserGroup(String className, int count, List<Loser> loserList) {
		super();
		this.className = className;
		this.count = count;
		if (loserList != null)
			this.loserList = loserList;
		else
			this.loserList = new ArrayList<Loser>();
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="loser")
	public List<Loser> getItems() {
		return loserList;
	}
	public void setItems(List<Loser> loserList) {
		this.loserList = loserList;
	}
	
	public Loser getItem(String name) {
		for (Loser tempLoser: this.loserList)
			if (tempLoser.getName().equals(name))
				return tempLoser;
		return null;
	}
	
	public void addItem(Loser loser) {
		if (loser == null || this.loserList == null) return;
		if (!this.loserList.contains(loser))
			this.loserList.add(loser);
	}

	public void updateItem(Loser loser) {
		if (loser == null || this.loserList == null) return;
		int index = this.loserList.indexOf(loser);
		if (index < 0)
			this.loserList.add(loser);
		else
			this.loserList.set(index, loser);
	}
	
	public void removeItem(String name) {
		Loser loser = new Loser(name, "");
		if (this.loserList.contains(loser))
			this.loserList.remove(loser);
	}
	
	@Override
	public String toString() {
		return  "{ \"name\": " + "\"" + className + "\"" + 
			    ", \"count\": " + "\"" + count + "\"" + 
				", items: " + loserList.toString() + "}";
	}
	
}
