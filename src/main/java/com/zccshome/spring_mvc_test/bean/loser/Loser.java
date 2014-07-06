package com.zccshome.spring_mvc_test.bean.loser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name", "room"})
@XmlRootElement(name="singleLoser")
public class Loser implements Comparable<Loser> {
	private String name;
	private String room;

	public Loser() {
		super();
	}

	public Loser(String name, String room) {
		super();
		this.name = name;
		this.room = room;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="dormitory")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loser other = (Loser) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public int compareTo(Loser o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "LoserGroup [name=" + name + ", room=" + room + "]";
	}
}
